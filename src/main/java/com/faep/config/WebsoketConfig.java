package com.faep.config;

import javax.servlet.ServletException;

import org.atmosphere.cpr.AtmosphereServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述： WebSocket的配置类，这个配置类检测带注解@ServerEndpoint的bean并注册它们
 * 作者： Faep
 * 创建时间： 2020/7/23 9:18
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
@Configuration
public class WebsoketConfig
{
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        // 第一个参数是我们自己的Servlet对象
        // 第二个参数是是对应的路径，可以写多个
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new AtmosphereServlet(), "/websocket");
        servletRegistrationBean.addInitParameter("org.atmosphere.cpr.packages","com.faep.websocket.WebSocketServer");
        servletRegistrationBean.addInitParameter("org.atmosphere.interceptor.HeartbeatInterceptor.clientHeartbeatFrequencyInSeconds", "5");
        servletRegistrationBean.setLoadOnStartup(0);
        servletRegistrationBean.setAsyncSupported(true);
        return servletRegistrationBean;
    }

}
