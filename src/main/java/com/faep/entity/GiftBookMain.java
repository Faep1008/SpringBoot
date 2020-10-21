package com.faep.entity;

import java.util.Date;

/**
 * 描述： 礼簿主表实体
 * 作者： Faep
 * 创建时间： 2020-10-21 11:09
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public class GiftBookMain
{
    private String bookguid;
    private String bookname;
    private Date occurdate;
    private String remark;

    public GiftBookMain() {
    }

    public GiftBookMain(String bookguid, String bookname, Date occurdate, String remark) {
        this.bookguid = bookguid;
        this.bookname = bookname;
        this.occurdate = occurdate;
        this.remark = remark;
    }

    public String getBookguid() {
        return bookguid;
    }

    public void setBookguid(String bookguid) {
        this.bookguid = bookguid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Date getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(Date occurdate) {
        this.occurdate = occurdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
