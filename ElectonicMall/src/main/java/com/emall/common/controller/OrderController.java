package com.emall.common.controller;

import com.emall.common.constant.DtoConstant;
import com.emall.common.constant.EmallConf;
import com.emall.common.dto.CommonJsonDto;
import com.emall.common.entity.CartItem;
import com.emall.common.entity.EmallUser;
import com.emall.common.entity.OrderItem;
import com.emall.common.service.CartService;
import com.emall.common.service.OrderService;
import com.emall.recomd.service.impl.UserBehaviorRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserBehaviorRecorder behaviorRecorder;

    /**
     * 结算，购买购物车中全部商品，生成订单并清空购物车
     * */
    @ResponseBody
    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public CommonJsonDto checkout(HttpServletRequest request){
        //用户信息
        EmallUser userInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        int uid = userInfo.getId();

        CommonJsonDto responseData = new CommonJsonDto();
        //购物车全部商品
        List<CartItem> items = cartService.listCartItemForUser(uid);
        if (items.size() == 0){
            responseData.setReturnCode(DtoConstant.FAIL_CODE);
            responseData.setReturnMessage(DtoConstant.INVALID_PARAMETER_MSG);
            return responseData;
        }

        //转换成相应的订单细项
        List<OrderItem> orders = orderService.cartItemsToOrderItems(items);
        //提交订单
        int saveId = orderService.checkoutOrderForUser(uid, orders);
        //记录用户行为
        for (OrderItem orderItem : orders){
            behaviorRecorder.putBuyItemLog(uid, orderItem.getCid());
        }

        if (saveId != -1){
            //成功后清空购物车并返回成功信息
            cartService.removeCart(uid);
            responseData.setReturnMessage(DtoConstant.SUCCESS_MSG);
            responseData.setReturnCode(DtoConstant.SUCCESS_CODE);
            return responseData;
        }
        else {
            responseData.setReturnCode(DtoConstant.FAIL_CODE);
            responseData.setReturnMessage(DtoConstant.INNER_ERROR_MSG);
            return responseData;
        }
    }
}
