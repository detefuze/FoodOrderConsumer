package com.ru.klimashd.classes;

import com.ru.klimashd.enums.ProductType;

public abstract class Product {
    protected Integer id;

    protected String name;

    protected Integer amount;

    protected Integer price;

    protected ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public Product() {
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public ProductType getProductType() { return productType; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}

