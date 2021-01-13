package com.epam.ta.model;

public class Product {
    private String name;
    private int count;

    public Product(String productName, int count) {
        this.name = productName;
        this.count = count;
    }

    public Product(String productName) {
        this.name = productName;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String productName) {
        this.name = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
