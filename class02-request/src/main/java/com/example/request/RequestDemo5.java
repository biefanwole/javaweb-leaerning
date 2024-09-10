package com.example.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/*
@author
@desc
@date

 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("访问 requestDemo5");
    req.getRequestDispatcher("/requestDemo6").forward(req, resp);
    }
    }
