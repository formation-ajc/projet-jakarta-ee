//package com.projet.projetjakartaee.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/login", "/register"})
//public class ConnectedFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("init ConnectedFilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        if(request.getSession().getAttribute("user") != null) {
//            response.sendRedirect(request.getContextPath() + "/home");
//        }
//        else {
//            filterChain.doFilter(servletRequest, servletResponse) ;
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//        System.out.println("destroy ConnectedFilter");
//    }
//}
