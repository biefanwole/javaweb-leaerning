package com.example.class06filterlistener.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignServlet extends HttpServlet {

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

    String username = req.getParameter("username");
    res.setContentType("text/html;charset=UTF-8");
    req.getSession().setAttribute("username",username);
    res.sendRedirect("detail.jsp");


}
}
