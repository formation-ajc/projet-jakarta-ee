//package com.projet.projetjakartaee.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/*"})
//public class AuthFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("init AuthFilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String loginURI = request.getContextPath() + "/login";
//        boolean loginRequest = request.getRequestURI().equals(loginURI);
//        String registerURI = request.getContextPath() + "/register";
//        boolean registerRequest = request.getRequestURI().equals(registerURI);
//
//
//        String path= request.getRequestURI();
//        if(path.endsWith(".css")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//
//        if (request.getSession().getAttribute("user") != null || loginRequest || registerRequest) {
//            filterChain.doFilter(request, response);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/login");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//        System.out.println("destroy AuthFilter");
//    }
//}
