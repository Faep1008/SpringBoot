package com.faep.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述： 总收入实体
 * 作者： Faep
 * 创建时间： 2020/6/30 10:56
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public class TotalSalary {
    private String rowguid;
    private String userguid;
    private BigDecimal totalsalary;
    private Date opratedate;

    public TotalSalary() {
    }

    public TotalSalary(String rowguid, BigDecimal totalsalary, String userguid, Date opratedate) {
        this.rowguid = rowguid;
        this.totalsalary = totalsalary;
        this.userguid = userguid;
        this.opratedate = opratedate;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public BigDecimal getTotalsalary() {
        return totalsalary;
    }

    public void setTotalsalary(BigDecimal totalsalary) {
        this.totalsalary = totalsalary;
    }

    public String getUserguid() {
        return userguid;
    }

    public void setUserguid(String userguid) {
        this.userguid = userguid;
    }

    public Date getOpratedate() {
        return opratedate;
    }

    public void setOpratedate(Date opratedate) {
        this.opratedate = opratedate;
    }
}
