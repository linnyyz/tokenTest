package com.example.springbootmybatise.Fliter;


import com.example.springbootmybatise.utils.TokenUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = "/tokenTest")
public class LoginVerifyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------已进入验证过滤器------");
//        if(servletRequest.getAttribute("userName")==null||servletRequest.getAttribute("password")==null) {
////            servletRequest.getRequestDispatcher("loginError.html").forward(servletRequest, servletResponse);
////            HttpServletRequest request = (HttpServletRequest) servletRequest;
//         HttpServletResponse response = (HttpServletResponse) servletResponse;
////            response.sendRedirect("loginError.html");
//
//        }

        if (TokenUtil.verify(servletRequest.getParameter("token"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("用户未登录");
//                response.sendRedirect("loginError.html");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
