package com.emall.common.dto;

import com.emall.common.entity.Commodity;

public class CartItemDto {
    Commodity commodity;
    int amount;

    public CartItemDto(Commodity commodity, int amount) {
        this.commodity = commodity;
        this.amount = amount;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
