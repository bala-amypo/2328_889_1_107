package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class DemoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().write("DemoServlet");
    }
}
