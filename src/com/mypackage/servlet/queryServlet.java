package com.mypackage.servlet;

import com.mypackage.pojo.Product;
import com.mypackage.service.ProductSercive;
import com.mypackage.service.impl.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryServlet",urlPatterns = "/queryServlet")
public class queryServlet extends HttpServlet {
    private ProductSercive productSercive=new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求和响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name=req.getParameter("queryname");
        if(name==null){name="";}

        List<Product> list=productSercive.queryProductsByName(name);
        ServletContext application = this.getServletContext();
        application.setAttribute("list",list);

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
