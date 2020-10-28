package com.faep.vo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述： email配置
 * 作者： Faep
 * 创建时间： 2020-10-28 13:43
 * 版本： [1.0, 2020-10-28]
 * 版权： Faep
 */
@Component
@ConfigurationProperties(prefix = "spring.mail", ignoreInvalidFields = true)
public class EmailConfigVo
{
    private String host;
    private String username;
    private String password;
    private String protocol;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
