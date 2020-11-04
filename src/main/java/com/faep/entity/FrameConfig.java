package com.faep.entity;

/**
 * 描述： 系统参数实体
 * 作者： Faep
 * 创建时间： 2020-11-04 09:25
 * 版本： [1.0, 2020-11-04]
 * 版权： Faep
 */
public class FrameConfig
{
    private String rowguid;
    private String domain;
    private String keyname;
    private String value;
    private String remark;

    public FrameConfig() {
    }

    public FrameConfig(String rowguid, String domain, String keyname, String value, String remark) {
        this.rowguid = rowguid;
        this.domain = domain;
        this.keyname = keyname;
        this.value = value;
        this.remark = remark;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
