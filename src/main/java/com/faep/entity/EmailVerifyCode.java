package com.faep.entity;

import java.util.Date;

/**
 * 描述： 手机验证码实体
 * 作者： Faep
 * 创建时间： 2020-10-24 13:53
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
public class EmailVerifyCode
{
    private String rowguid;
    private String email;
    private String emailcode;
    private Date codegeneratetime;
    private String remark;

    public EmailVerifyCode() {
    }

    public EmailVerifyCode(String rowguid, String email, String emailcode, Date codegeneratetime, String remark) {
        this.rowguid = rowguid;
        this.email = email;
        this.emailcode = emailcode;
        this.codegeneratetime = codegeneratetime;
        this.remark = remark;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailcode() {
        return emailcode;
    }

    public void setEmailcode(String emailcode) {
        this.emailcode = emailcode;
    }

    public Date getCodegeneratetime() {
        return codegeneratetime;
    }

    public void setCodegeneratetime(Date codegeneratetime) {
        this.codegeneratetime = codegeneratetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
