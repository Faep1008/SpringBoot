package com.faep.entity;

/**
 * 描述： 菜单实体
 * 作者： Faep
 * 创建时间： 2020-10-20 15:13
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
public class FrameMenu
{
    private String rowguid;
    private String menuname;
    private String menuurl;
    private String menuorder;
    private String parentguid;
    private String enabled;
    private String roles;
    private String menutype;
    private String remark;

    public FrameMenu() {
    }

    public FrameMenu(String rowguid, String menuname, String menuurl, String menuorder, String parentguid,
            String enabled, String roles, String menutype, String remark) {
        this.rowguid = rowguid;
        this.menuname = menuname;
        this.menuurl = menuurl;
        this.menuorder = menuorder;
        this.parentguid = parentguid;
        this.enabled = enabled;
        this.roles = roles;
        this.menutype = menutype;
        this.remark = remark;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public String getMenuorder() {
        return menuorder;
    }

    public void setMenuorder(String menuorder) {
        this.menuorder = menuorder;
    }

    public String getParentguid() {
        return parentguid;
    }

    public void setParentguid(String parentguid) {
        this.parentguid = parentguid;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
