package com.mypackage.dao;

import com.mypackage.pojo.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> queryAllProducts();
    public Product queryProductById(Integer id);
    public List<Product> queryProductsByName(String name);
}
