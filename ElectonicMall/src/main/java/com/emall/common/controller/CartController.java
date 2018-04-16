package com.emall.common.controller;

import com.emall.common.constant.DtoConstant;
import com.emall.common.constant.EmallConf;
import com.emall.common.dto.CartDto;
import com.emall.common.dto.CartItemDto;
import com.emall.common.dto.CommonJsonDto;
import com.emall.common.entity.CartItem;
import com.emall.common.entity.Commodity;
import com.emall.common.entity.EmallUser;
import com.emall.common.service.CartService;
import com.emall.common.service.CommodityService;
import com.emall.recomd.service.impl.UserBehaviorRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private UserBehaviorRecorder userBehaviorRecorder;

    /**
     * 获取当前用户的购物车数据
     * */
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String listCart(HttpServletRequest request){
        //用户信息
        EmallUser userInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        int uid = userInfo.getId();

        List<CartItem> items = cartService.listCartItemForUser(uid);
        List<CartItemDto> itemsDto = new ArrayList<>(items.size());
        int sumAmount = 0;
        double sumPrice = 0;
        for (CartItem item : items){
            Commodity commodity = commodityService.getCommodityById(item.getCid());
            sumAmount += item.getAmount();
            sumPrice += commodity.getPrice().doubleValue() * item.getAmount();
            CartItemDto cartItemDto = new CartItemDto(commodity, item.getAmount());
            itemsDto.add(cartItemDto);
        }
        CartDto cartDto = new CartDto(sumAmount, sumPrice, itemsDto);
        request.setAttribute(EmallConf.INDEX_COMMODITY_DATA_KEY, cartDto);
        return "checkout";
    }

    /**
     * 添加商品到购物车
     * */
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseBody
    public CommonJsonDto addCommodityToCart(Integer commodityId, Integer amount, HttpServletRequest request){
        //用户信息
        EmallUser userInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        int uid = userInfo.getId();

        if (commodityId == null || amount == null){
            return new CommonJsonDto(DtoConstant.FAIL_CODE, DtoConstant.INVALID_PARAMETER_MSG);
        }
        //记录行为日志
        userBehaviorRecorder.putAddCartLog(uid, commodityId);

        //获取所添加商品的信息以计算价格
        Commodity commodity = commodityService.getCommodityById(commodityId);
        //添加
        CartItem item = new CartItem(uid, commodityId, amount);
        boolean addSuccess = cartService.addCart(item);
        if (addSuccess){
            return new CommonJsonDto(DtoConstant.SUCCESS_CODE, DtoConstant.SUCCESS_MSG, commodity.getPrice().doubleValue() * amount);
        }
        else {
            return new CommonJsonDto(DtoConstant.FAIL_CODE, DtoConstant.INNER_ERROR_MSG);
        }
    }

    /**
     * 从购物车移除指定商品
     * */
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonJsonDto removeCommodityFromCart(@PathVariable(value = "id") Integer commodityId, HttpServletRequest request){
        //用户信息
        EmallUser userInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        int uid = userInfo.getId();

        if (commodityId == null){
            return new CommonJsonDto(DtoConstant.FAIL_CODE, DtoConstant.INVALID_PARAMETER_MSG);
        }
        //移除
        CartItem item = new CartItem(uid, commodityId);
        boolean removeRes = cartService.removeCart(item);
        if (removeRes){
            return new CommonJsonDto(DtoConstant.SUCCESS_CODE, DtoConstant.SUCCESS_MSG);
        }
        else {
            return new CommonJsonDto(DtoConstant.FAIL_CODE, DtoConstant.INNER_ERROR_MSG);
        }
    }

    /**
     * 清空当前登录用户的购物车
     * */
    @RequestMapping(value = "/cart/clear")
    @ResponseBody
    public CommonJsonDto clearUserCart(HttpServletRequest request){
        //用户信息
        EmallUser userInfo = (EmallUser) request.getSession().getAttribute(EmallConf.LOGIN_INFO_KEY);
        int uid = userInfo.getId();

        //移除
        boolean clearRes = cartService.removeCart(uid);
        if (clearRes){
            return new CommonJsonDto(DtoConstant.SUCCESS_CODE, DtoConstant.SUCCESS_MSG);
        }
        else {
            return new CommonJsonDto(DtoConstant.FAIL_CODE, DtoConstant.INNER_ERROR_MSG);
        }
    }
}
