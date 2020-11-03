package com.faep.entity;

import java.util.Date;

/**
 * 描述： 登录历史记录实体
 * 作者： Faep
 * 创建时间： 2020-11-03 14:22
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
public class LoginRecord
{
    private String rowguid;
    private String userguid;
    private String loginid;
    private String logintype;
    private Date logindate;
    private String loginip;
    private String loginmac;
    private String remark;

    public LoginRecord() {
    }

    public LoginRecord(String rowguid, String userguid, String loginid, String logintype, Date logindate,
            String loginip, String loginmac, String remark) {
        this.rowguid = rowguid;
        this.userguid = userguid;
        this.loginid = loginid;
        this.logintype = logintype;
        this.logindate = logindate;
        this.loginip = loginip;
        this.loginmac = loginmac;
        this.remark = remark;
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

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getLoginmac() {
        return loginmac;
    }

    public void setLoginmac(String loginmac) {
        this.loginmac = loginmac;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
