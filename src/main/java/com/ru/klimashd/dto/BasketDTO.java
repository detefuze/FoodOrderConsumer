package com.ru.klimashd.dto;

public class BasketDTO {

    private int id;
    private String name;
    private int amount;
    private int price;
    private String product_type;
    private int id_product;

    public BasketDTO() {}

    public BasketDTO(int id, String name, int amount, int price, String product_type) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.product_type = product_type;
        this.id_product = id_product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    @Override
    public String toString() {
        return "BasketDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", product_type='" + product_type + '\'' +
                ", id_product=" + id_product +
                '}';
    }
}