package com.example.brandlist.servlet;

import com.example.brandlist.entity.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);

        String idStr = req.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");
            if (brands == null) {
                brands = new ArrayList<>();
                req.getServletContext().setAttribute("brands", brands);
            }
            boolean removed = brands.removeIf(brand -> brand.getId().equals(id));
            if (removed) {
                resp.getWriter().write("Brand deleted successfully");
            } else {
                resp.getWriter().write("Brand not found");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid ID format");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            resp.getWriter().write("An error occurred");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}