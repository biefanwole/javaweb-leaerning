package com.example.bookonline.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.bookonline.entity.Book;
import com.example.bookonline.service.BookService;
import com.example.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {

    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的URI，并去除空格
        String requestPath = req.getRequestURI().trim();
        //    获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");
        //从该位置到最后取子串，也就是/detail/3中的3，有了这个id，就可以找到集合中耐应的图书矿象
        String id = requestPath.substring(position + 1);
        //    根据id 查找图书
        Book book = bookService.getBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }
}
