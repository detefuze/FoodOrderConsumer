package com.ru.klimashd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int id;

    @Column(name="product_type")
    private String productType;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private int price;

    @Column
    private int id_product;

    public Basket(String productType, String name, int amount, int price, int id_product) {
        this.productType = productType;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.id_product = id_product;
    }

    public Basket(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_product() {
        return id_product;
    }
}
