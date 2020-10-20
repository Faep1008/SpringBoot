package com.faep.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.faep.filter.WebFilter;
import com.faep.vo.DruidConfigVo;
import org.atmosphere.cpr.AtmosphereServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述： 系统配置，相当于web.xml
 * 作者： Faep
 * 创建时间： 2020/7/24 13:49
 * 版本： [1.0, 2020/7/24]
 * 版权： Faep
 */
@Configuration
public class WebConfig {

    @Autowired
    private DruidConfigVo druidConfigVo;

    @Autowired
    @Qualifier("webFilter")
    private Filter webFilter;

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean(webFilter);
        registration.addUrlPatterns("/*");
        registration.setName("WebFilter");
        registration.setAsyncSupported(true);
        return registration;
    }

    /**
     * 注册WebSocket拦截器
     * @return
     */
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

    /**
     * Druid配置
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings(druidConfigVo.getUrlmappings());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("resetEnable", druidConfigVo.getResetenable()); //禁用HTML页面上的“Rest All”功能
        initParameters.put("allow", druidConfigVo.getAllow());  //ip白名单（没有配置或者为空，则允许所有访问）
        initParameters.put("loginUsername", druidConfigVo.getLoginusername());  //++监控页面登录用户名
        initParameters.put("loginPassword", druidConfigVo.getLoginpassword());  //++监控页面登录用户密码
        initParameters.put("deny", druidConfigVo.getDeny()); //ip黑名单，如果某个ip同时存在，deny优先于allow
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

}
