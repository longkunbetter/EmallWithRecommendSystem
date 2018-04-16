package com.emall.common.dao;

import com.emall.common.entity.CartItem;
import com.emall.common.entity.CartItemExample;
import java.util.List;

public interface CartItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartItem record);

    int insertSelective(CartItem record);

    List<CartItem> selectByExample(CartItemExample example);

    CartItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartItem record);

    int updateByPrimaryKey(CartItem record);

    int deleteBySelective(CartItem record);
}