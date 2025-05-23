package com.ru.klimashd.dto;


public class BasketDTO {

    private String name;
    private Integer order_amount;
    private Integer price;
    private Integer product_id;
    private Integer customer_id;

    public BasketDTO(String name,
                     Integer order_amount,
                     Integer price,
                     Integer product_id,
                     Integer customer_id) {
        this.name = name;
        this.order_amount = order_amount;
        this.price = price;
        this.product_id = product_id;
        this.customer_id = customer_id;
    }

    public BasketDTO() {}

    public Integer getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Integer order_amount) {
        this.order_amount = order_amount;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
