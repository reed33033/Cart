package com.mypackage.servlet;

import com.mypackage.pojo.Product;
import com.mypackage.service.ProductSercive;
import com.mypackage.service.impl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
//初始化Servlet
@WebServlet(name="InitServlet",urlPatterns={"/initServlet"},loadOnStartup=0)
public class InitServlet extends HttpServlet {
    public InitServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) {
		ProductSercive productSercive=new ProductServiceImpl();
		List<Product> list=new ArrayList<>();
		list=productSercive.queryAllProducts();
		config.getServletContext().setAttribute("list", list);
		config.getServletContext().setAttribute("cart",null);
		System.out.println("InitServlet初始化完毕！");
	}

    

}
