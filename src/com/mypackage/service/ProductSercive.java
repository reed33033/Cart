package com.mypackage.service;

import com.mypackage.pojo.Product;

import java.util.List;

public interface ProductSercive {
    public List<Product> queryAllProducts();
    public Product queryProductById(Integer id);
    public List<Product> queryProductsByName(String name);
}
