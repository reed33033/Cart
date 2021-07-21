package com.mypackage.dao.dao.impl;

import com.mypackage.dao.ProductDao;
import com.mypackage.pojo.Product;
import com.mypackage.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> queryAllProducts() {
        String sql="select * from product";

        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Product> list=new ArrayList<>();
        //2. 获取连接
        Connection conn = DBUtil.getConnection();
        try {
            //3. 创建PreparedStatement
            pstmt = conn.prepareStatement(sql);

            //4. 执行sql
            rs = pstmt.executeQuery();
            //5. 处理结果集 查询会有结果集
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                String desc=rs.getString(4);
                float price = rs.getFloat(5);
                int sales = rs.getInt(6);
                float score=rs.getFloat(7);
                Product p=new Product(id,name,brand,desc,price,sales,score);
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //6. 关闭资源
            DBUtil.close(conn,pstmt,rs);
        }

        return list;
    }

    @Override
    public Product queryProductById(Integer id) {
        String sql="select * from product where id=?";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Product product=null;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs= pstmt.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                String desc=rs.getString(4);
                float price = rs.getFloat(5);
                int sales = rs.getInt(6);
                float score=rs.getFloat(7);
                product=new Product(id1,name,brand,desc,price,sales,score);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return product;
    }

    @Override
    public List<Product> queryProductsByName(String name) {
        String sql="select * from product where name like ?";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Product product=null;
        List<Product> list=new ArrayList<>();
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            rs= pstmt.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt(1);
                String name1 = rs.getString(2);
                String brand = rs.getString(3);
                String desc=rs.getString(4);
                float price = rs.getFloat(5);
                int sales = rs.getInt(6);
                float score=rs.getFloat(7);
                product=new Product(id1,name1,brand,desc,price,sales,score);
                list.add(product);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
