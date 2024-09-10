package com.example.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method =req.getMethod();
        System.out.println("请求方式"+method);

        String servletPath =req.getServletPath();
        System.out.println("获取Servlet"+servletPath);

        String queryString =req.getQueryString();
        System.out.println("Get请求参数"+queryString);

        String requestURI =req.getRequestURI();
        System.out.println("请求URI"+requestURI);
        StringBuffer requestURL =req.getRequestURL();
        System.out.println("请求URL"+requestURL);

        String contextPath=req.getProtocol();
        System.out.println("虚拟目录"+contextPath);
    }
}
