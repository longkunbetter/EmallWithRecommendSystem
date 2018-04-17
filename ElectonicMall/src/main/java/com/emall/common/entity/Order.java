package com.emall.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;

    private Integer uid;

    private Integer amount;

    private Date createdate;

    private BigDecimal total;

    private List<OrderItem> orderItemList;

    public Order(Integer uid, Integer amount, BigDecimal total, List<OrderItem> orderItemList) {
        this.uid = uid;
        this.amount = amount;
        this.total = total;
        this.orderItemList = orderItemList;
    }

    public Order(){

    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}