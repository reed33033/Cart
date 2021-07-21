package com.mypackage.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mypackage.pojo.Cart;
import com.mypackage.pojo.CartItem;
import com.mypackage.pojo.Product;
import com.mypackage.service.ProductSercive;
import com.mypackage.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    private ProductSercive productSercive=new ProductServiceImpl();
    private Cart cart=new Cart();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参数值
        req.setCharacterEncoding("utf-8");

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = resp.getWriter();

        String s=req.getParameter("info");


        //jsion字符串转换为java对象
        Product product=JSONObject.parseObject(s,Product.class);
        System.out.println("1... "+s+"11... "+product);
        //实现修改逻辑
        Product product1=productSercive.queryProductById(product.getId());
        if(product1!=null){
            CartItem cartItem=new CartItem(product1.getId(),product1.getName(),product1.getPrice());
            cart=(Cart) req.getSession().getAttribute("cart");
            if(cart==null){
                cart=new Cart();
                req.getSession().setAttribute("cart",cart);
                System.out.println("2... "+cart.getItems());
            }
            cart.AddItem(cartItem);

            System.out.println("3... "+cart+"4... "+cart.getItems());
            List list = new ArrayList(cart.getItems().values());
            req.getSession().setAttribute("clist",list);
            System.out.println(list);
            String data= JSON.toJSONString(product1);
            out.write(data);
        }else{
            String data= JSON.toJSONString(product1);
            out.write(data);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
