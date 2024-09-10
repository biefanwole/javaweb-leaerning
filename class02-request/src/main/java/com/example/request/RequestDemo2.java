package com.example.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames=req.getHeaderNames();


        while (headerNames.hasMoreElements()){
            String name=headerNames.nextElement();
            String val=req.getHeader(name);
            System.out.println(name + ": " + val);

        }
    String header =req.getHeader("user-agent");
        if(header.contains("Edg")) {
            System.out.println("Edge 浏览器");
        }else if(header.contains("Chrome")) {
            System.out.println("Chrome");
        }

    }


}