package com.example.crudoperation.entity;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String productId;
    private String productName;
    private float productPrice;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public Product(String productId, String productName, float productPrice) {
        super();
        this.productId = productId;
        this.productName = productName;

        this.productPrice = productPrice;
    }

    public Product() {
        super();
    }
}
