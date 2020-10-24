package com.faep.entity;

import java.util.Date;

/**
 * 描述： 手机验证码实体
 * 作者： Faep
 * 创建时间： 2020-10-24 13:53
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
public class PhoneVerifyCode
{
    private String rowguid;
    private String phone;
    private String verifycode;
    private Date codegeneratetime;
    private String remark;

    public PhoneVerifyCode() {
    }

    public PhoneVerifyCode(String rowguid, String phone, String verifycode, Date codegeneratetime, String remark) {
        this.rowguid = rowguid;
        this.phone = phone;
        this.verifycode = verifycode;
        this.codegeneratetime = codegeneratetime;
        this.remark = remark;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
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
