package com.faep.entity;

import java.math.BigDecimal;

/**
 * 描述： 礼簿具体项实体
 * 作者： Faep
 * 创建时间： 2020-10-21 11:09
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public class GiftBookItem
{
    private String itemguid;
    private String bookguid;
    private String username;
    private BigDecimal money;
    private String uppermoney;
    private String remark;
    private int ordernum;

    public GiftBookItem() {
    }

    public GiftBookItem(String itemguid, String bookguid, String username, BigDecimal money, String uppermoney,
            String remark) {
        this.itemguid = itemguid;
        this.bookguid = bookguid;
        this.username = username;
        this.money = money;
        this.uppermoney = uppermoney;
        this.remark = remark;
    }

    public String getItemguid() {
        return itemguid;
    }

    public void setItemguid(String itemguid) {
        this.itemguid = itemguid;
    }

    public String getBookguid() {
        return bookguid;
    }

    public void setBookguid(String bookguid) {
        this.bookguid = bookguid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUppermoney() {
        return uppermoney;
    }

    public void setUppermoney(String uppermoney) {
        this.uppermoney = uppermoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }
}
