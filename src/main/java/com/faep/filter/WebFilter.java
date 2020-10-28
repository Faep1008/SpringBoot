package com.faep.filter;


import com.faep.vo.config.FrameConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述： 个性化过滤器
 * 作者： Faep
 * 创建时间： 2020/7/24 13:51
 * 版本： [1.0, 2020/7/24]
 * 版权： Faep
 */
@Component("webFilter")
public class WebFilter implements Filter {

    @Autowired
    FrameConfigVo frameConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        // 无需登录就可访问的页面
        String[] noNeedAuthPages = frameConfig.getNoNeedAuthPages().split(";");
        for (String authPage : noNeedAuthPages) {
            if (uri.contains(authPage)){
                chain.doFilter(request, response);
                return;
            }
        }

        // 不需要登录就能访问的action方法
        String[] noNeedAuthActions = frameConfig.getNoNeedAuthActions().split(";");
        for (String authAction : noNeedAuthActions) {
            if (uri.contains(authAction)){
                chain.doFilter(request, response);
                return;
            }
        }

        // 无需判断登录就可访问的资源后缀
        String skipFilterSuffix = frameConfig.getSkipFilterSuffix();
        if(!StringUtils.isEmpty(skipFilterSuffix)){
            String[] skipFilterSuffixs = skipFilterSuffix.split(";");
            for (String suffix : skipFilterSuffixs) {
                if (uri.endsWith(suffix)){
                    chain.doFilter(request, response);
                    return;
                }
            }
        }

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            // 未登录直接跳回登录页面
            resp.sendRedirect("/pages/login/login.html");
        }
        else{
            // 登陆成功直接跳转
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
