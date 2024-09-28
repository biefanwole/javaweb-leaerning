package com.example.bookonline.servlet;

import com.example.bookonline.entity.User;
import com.example.bookonline.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/login" )
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException{
        userService = new UserServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //      获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        //      调用登录功能
        User user = userService.signIn(account, password);
        if (user != null) {
            //      登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //      重定向回到 /index，进入 IndexServlet
            resp.sendRedirect("/index");
        } else {
            //      登录失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert（'账号或密码错误'）;location.href='/';</script>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}