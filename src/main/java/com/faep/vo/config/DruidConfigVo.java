package com.faep.vo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述： Druid属性配置VO
 * 作者： Faep
 * 创建时间： 2020/6/30 9:22
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Component
@ConfigurationProperties(prefix = "frame.druid", ignoreInvalidFields = true)
public class DruidConfigVo {
    /**
     * ip白名单（没有配置或者为空，则允许所有访问）
     */
    private String allow;
    /**
     * 监控页面登录用户名
     */
    private String loginusername;
    /**
     * 监控页面登录用户密码
     */
    private String loginpassword;
    /**
     * ip黑名单,如果某个ip同时存在，deny优先于allow
     */
    private String deny;
    /**
     * 禁用HTML页面上的“Rest All”功能
     */
    private String resetenable;
    /**
     * Druid访问地址
     */
    private String urlmappings;

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getLoginusername() {
        return loginusername;
    }

    public void setLoginusername(String loginusername) {
        this.loginusername = loginusername;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getResetenable() {
        return resetenable;
    }

    public void setResetenable(String resetenable) {
        this.resetenable = resetenable;
    }

    public String getUrlmappings() {
        return urlmappings;
    }

    public void setUrlmappings(String urlmappings) {
        this.urlmappings = urlmappings;
    }
}
