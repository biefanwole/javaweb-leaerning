package com.example.class05ajaxaxios;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/axiosServlet")

public class AxiosServlet extends HttpServlet {

    protected void doGet(HttpServlet req, HttpServletResponse resp) throws IOException {

        String username = req.getInitParameter("username");
        System.out.println("username"+username);
        resp.getWriter().write("Hello"+username);
    }

    protected void doPost(HttpServlet req, HttpServletResponse resp) throws IOException {
String username = req.getInitParameter("username");
System.out.println("username"+username);
        this.doGet(req, resp);

    }
}