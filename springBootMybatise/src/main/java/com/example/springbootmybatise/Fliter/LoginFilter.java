package com.example.springbootmybatise.Fliter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "loginInputFilter",urlPatterns = "/login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----已进入登录输入内容过滤器----");
        if(servletRequest.getAttribute("userName")==null||servletRequest.getAttribute("password")==null){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("loginError.html");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("----已退出登录输入内容过滤器----");
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
