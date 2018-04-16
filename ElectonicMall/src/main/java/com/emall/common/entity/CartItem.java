package com.emall.common.entity;

public class CartItem {
    private Integer id;

    private Integer uid;

    private Integer cid;

    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CartItem(){

    }

    public CartItem(Integer uid, Integer cid) {
        this.uid = uid;
        this.cid = cid;
    }

    public CartItem(Integer uid, Integer cid, Integer amount) {
        this.uid = uid;
        this.cid = cid;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", uid=" + uid +
                ", cid=" + cid +
                ", amount=" + amount +
                '}';
    }
}