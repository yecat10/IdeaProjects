package com.doubleriver.springbootgeneral.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ronye
 * @Created 2018/12/31 - 10:06 PM
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req, resp );
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter ().write ( "Hello , Servlet in Spring Boot" );
    }
}
