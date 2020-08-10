package com.faep.filter;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述： 个性化过滤器
 * 作者： Faep
 * 创建时间： 2020/7/24 13:51
 * 版本： [1.0, 2020/7/24]
 * 版权： Faep
 */
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if (!uri.startsWith("/pages")){
            chain.doFilter(request, response);
            return;
        }
        //System.out.println("Filter URI=====111======" + uri);
        if (!uri.endsWith(".html")){
            uri = uri + ".html";
            //System.out.println("Filter URI=====222======" + uri);
            req.getRequestDispatcher(uri).forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
