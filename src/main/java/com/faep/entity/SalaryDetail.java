package com.faep.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述： 工资收支详细记录实体
 * 作者： Faep
 * 创建时间： 2020/6/30 10:58
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public class SalaryDetail {
    private String rowguid;
    private String userguid;
    private String type;
    private Date opratedate;
    private BigDecimal outlay;
    private BigDecimal income;

    public SalaryDetail() {
    }

    public SalaryDetail(String rowguid, String userguid, String type, Date opratedate, BigDecimal outlay, BigDecimal income) {
        this.rowguid = rowguid;
        this.userguid = userguid;
        this.type = type;
        this.opratedate = opratedate;
        this.outlay = outlay;
        this.income = income;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getUserguid() {
        return userguid;
    }

    public void setUserguid(String userguid) {
        this.userguid = userguid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getOpratedate() {
        return opratedate;
    }

    public void setOpratedate(Date opratedate) {
        this.opratedate = opratedate;
    }

    public BigDecimal getOutlay() {
        return outlay;
    }

    public void setOutlay(BigDecimal outlay) {
        this.outlay = outlay;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
