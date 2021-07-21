package com.mypackage.pojo;

/**
 * 商品
 */
public class Product {
    private int id;
    private String name;
    private String brand;
    private String describe;
    private float price;
    private int sales;
    private float score;

    public Product() {
    }

    public Product(int id, String name, String brand, String describe, float price, int sales, float score) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.describe = describe;
        this.price = price;
        this.sales = sales;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", describe='" + describe + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", score=" + score +
                '}';
    }
}
