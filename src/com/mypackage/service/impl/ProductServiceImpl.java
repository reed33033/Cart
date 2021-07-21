package com.mypackage.service.impl;

import com.mypackage.dao.ProductDao;
import com.mypackage.dao.dao.impl.ProductDaoImpl;
import com.mypackage.pojo.Product;
import com.mypackage.service.ProductSercive;

import java.util.List;

public class ProductServiceImpl implements ProductSercive {
    private ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> queryAllProducts() {
        return productDao.queryAllProducts();
    }

    @Override
    public Product queryProductById(Integer id) {
        return productDao.queryProductById(id);
    }

    @Override
    public List<Product> queryProductsByName(String name) {
        return productDao.queryProductsByName(name);
    }
}
