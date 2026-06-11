package com.learnMybatisplus.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class FilterDemo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter过滤器工作了~~");
    }

    @Override
    public void destroy() {
        System.out.println("filter过滤器销毁了~~");
        Filter.super.destroy();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter过滤器初始化了~~");
        Filter.super.init(filterConfig);
    }
}
