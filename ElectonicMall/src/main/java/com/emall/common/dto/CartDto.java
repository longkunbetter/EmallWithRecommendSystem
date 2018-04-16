package com.emall.common.dto;

import java.util.List;

public class CartDto {
    private Integer amount;
    private Double price;
    private List<CartItemDto> items;


    public CartDto(Integer amount, Double price, List<CartItemDto> items) {
        this.amount = amount;
        this.price = price;
        this.items = items;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
}
