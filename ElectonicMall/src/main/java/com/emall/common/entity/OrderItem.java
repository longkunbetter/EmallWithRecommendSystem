package com.emall.common.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private Integer oid;

    private Integer cid;

    private Integer amount;

    private BigDecimal total;

    public OrderItem(Integer cid, Integer amount, BigDecimal total) {
        this.cid = cid;
        this.amount = amount;
        this.total = total;
    }

    public OrderItem(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}