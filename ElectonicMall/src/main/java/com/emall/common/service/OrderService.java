package com.emall.common.service;

import com.emall.common.dao.CommodityMapper;
import com.emall.common.dao.OrderItemMapper;
import com.emall.common.dao.OrderMapper;
import com.emall.common.entity.CartItem;
import com.emall.common.entity.Commodity;
import com.emall.common.entity.Order;
import com.emall.common.entity.OrderItem;
import com.emall.system.exception.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class OrderService {
    private static final Log log = LogFactory.getLog(OrderService.class);

    @Autowired
    private CommodityMapper commodityDao;
    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private OrderItemMapper orderItemDao;

    /**
     * 为指定用户结算一笔订单
     *  @return 成功返回订单id，失败返回-1
     * */
    public int checkoutOrderForUser(int uid, List<OrderItem> orderItems){
        //计算出订单总商品数、总额
        int amount = 0;
        double total = 0d;
        for (OrderItem item : orderItems){
            int currentAmount = item.getAmount();
            amount += currentAmount;
            total += currentAmount * item.getTotal().doubleValue();
        }
        //准备创建的订单对象并保存
        Order order = new Order(uid, amount, new BigDecimal(total), orderItems);
        order.setCreatedate(Calendar.getInstance().getTime());
        return saveOrder(order);
    }
    /**
     * 将订单插入数据库
     * @param order
     *          订单信息
     * @return 成功返回订单id，失败返回-1
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int saveOrder(Order order){
        //插入订单
        orderDao.insertSelective(order);
        Integer orderId = order.getId();
        if (orderId == null){
            log.error("插入订单失败，插入参数为" + order);
            throw new ServiceException("插入订单失败");
        }
        //插入订单细项
        List<OrderItem> itemList = order.getOrderItemList();
        for (OrderItem item : itemList){
            item.setOid(orderId);
            int inserRes = orderItemDao.insertSelective(item);
            if (inserRes == 0){
                log.error("插入订单细项" + item + "失败");
                throw new ServiceException("插入订单细项失败");
            }
        }
        return orderId;
    }

    /**
     * 将购物车条目转为订单条目
     * @param cartItems
     *          一组购物车条目
     * */
    public List<OrderItem> cartItemsToOrderItems(List<CartItem> cartItems){
        List<OrderItem> resItems = new ArrayList<>(cartItems.size());
        cartItems.parallelStream().forEach(
                cartItem -> resItems.add(cartItemToOrderItem(cartItem))
        );
        return resItems;
    }
    private OrderItem cartItemToOrderItem(CartItem cartItem){
        Commodity commodity = commodityDao.selectByPrimaryKey(cartItem.getCid());
        BigDecimal total = commodity.getPrice().multiply(new BigDecimal(cartItem.getAmount()));
        return new OrderItem(cartItem.getCid(), cartItem.getAmount(), total);
    }
}
