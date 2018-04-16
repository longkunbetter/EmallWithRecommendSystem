package com.emall.common.service;

import com.emall.common.dao.CartItemMapper;
import com.emall.common.entity.CartItem;
import com.emall.common.entity.CartItemExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    private static final Log log = LogFactory.getLog(CartService.class);

    @Autowired
    private CartItemMapper cartItemDao;

    /**
     * 将商品添加至用户购物车
     * @param cartItem
     *          购物车条目信息，包含用户id,商品id,添加数量
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public boolean addCart(CartItem cartItem){
        //先查找该用户是否已经将商品添加至购物车
        CartItemExample example = new CartItemExample();
        CartItemExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(cartItem.getUid());
        criteria.andCidEqualTo(cartItem.getCid());
        List<CartItem> existItemList = cartItemDao.selectByExample(example);

        //返回操作结果
        int res = 0;
        //若购物车已存在该商品则将数量加上当前请求增加的值
        if (existItemList.size() > 0){
            CartItem existItem = existItemList.get(0);
            int newAmount = existItem.getAmount() + cartItem.getAmount();
            CartItem newCartItem = new CartItem();
            newCartItem.setAmount(newAmount);
            newCartItem.setId(existItem.getId());
            res = cartItemDao.updateByPrimaryKeySelective(newCartItem);
        }
        //否则直接插入
        else{
            res = cartItemDao.insertSelective(cartItem);
        }

        if (res > 0){
            return true;
        }
        else {
            log.error("在执行addCart操作时遇到异常，传入参数为" + cartItem);
            return false;
        }
    }

    /**
     * 将用户购物车中的指定商品移除
     * @param cartItem
     *          购物车条目信息，包含用户id,商品id
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public boolean removeCart(CartItem cartItem){
        int res = cartItemDao.deleteBySelective(cartItem);
        if (res > 0){
            return true;
        }
        else {
            log.warn("在执行removeCart操作时遇到异常，购物车可能已经被删除，传入参数为" + cartItem);
            return false;
        }
    }

    /**
     * 清空指定用户的购物车
     * @param uid
     *          用户id
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public boolean removeCart(int uid){
        CartItem record = new CartItem();
        record.setUid(uid);
        int res = cartItemDao.deleteBySelective(record);

        if (res > 0){
            log.info("清空用户" + uid + "购物车成功");
        }
        else {
            log.warn("在执行removeCart操作时遇到异常，购物车可能已清空");
        }
        return true;
    }

    /**
     * 获取指定用户的购物车信息
     * @param uid
     *          用户id
     * */
    public List<CartItem> listCartItemForUser(int uid){
        CartItemExample example = new CartItemExample();
        example.createCriteria().andUidEqualTo(uid);

        return cartItemDao.selectByExample(example);
    }
}
