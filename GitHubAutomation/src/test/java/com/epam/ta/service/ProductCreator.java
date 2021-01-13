package com.epam.ta.service;

import com.epam.ta.model.Product;

public class ProductCreator {
    public static final String PRODUCT_NAME="testdata.product.%s.name";
    public static final String PRODUCT_COUNT="testdata.product.%s.count";

    public static Product withAllProperty(String productNumber){
        String productUrl=String.format(PRODUCT_NAME,productNumber);
        String productCount=String.format(PRODUCT_COUNT,productNumber);
        return new Product(TestDataReader.getTestData(productUrl),
                Integer.parseInt(TestDataReader.getTestData(productCount)));
    }

    public static Product withEmptyProductSize(String productNumber){
        String productUrl=String.format(PRODUCT_NAME,productNumber);
        return new Product(TestDataReader.getTestData(productUrl));
    }
}
