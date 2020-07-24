package com.faep.config;

import com.faep.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/24 13:49
 * 版本： [1.0, 2020/7/24]
 * 版权： Faep
 */
@Configuration
public class WebConfig {

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean(new WebFilter());
        registration.addUrlPatterns("/*");
        registration.setName("WebFilter");
        registration.setAsyncSupported(true);
        return registration;
    }

}
