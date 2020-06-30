package com.faep.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.faep.vo.DruidConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述： Druid配置
 * 作者： Faep
 * 创建时间： 2020/6/30 9:01
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Configuration
public class DruidConfig {

    @Autowired
    private DruidConfigVo druidConfigVo;

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
