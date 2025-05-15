package com.ru.klimashd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bakery")
public class Bakery {
    @PrimaryKeyJoinColumn(name = "id_product")

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_product")
    private int id;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private int price;

    protected Bakery() {
    }

    public Bakery(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
