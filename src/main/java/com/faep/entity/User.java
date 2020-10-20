package com.faep.entity;

import java.util.Date;

/**
 * 描述： 用户实体
 * 作者： Faep
 * 创建时间： 2020/6/18 8:54
 * 版本： [1.0, 2020/6/18]
 * 版权： Faep
 */
public class User {

    private String rowguid;
    private String username;
    private String loginid;
    private String password;
    private String phone;
    private Date lastlogintime;
    private String roles;
    private String locked;
    private int ordernum;
    private String remark;

    public User() {
    }

    public User(String rowguid, String username, String loginid, String password, String phone, Date lastlogintime, String locked) {
        this.rowguid = rowguid;
        this.username = username;
        this.loginid = loginid;
        this.password = password;
        this.phone = phone;
        this.lastlogintime = lastlogintime;
        this.locked = locked;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
