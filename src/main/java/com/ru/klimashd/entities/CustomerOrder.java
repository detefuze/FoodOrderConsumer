package com.ru.klimashd.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", allocationSize = 1)
    @Column(name = "order_id", insertable = false, updatable = false)
    private int order_id;

    @Column(columnDefinition = "text")
    private String order_info;

    @CreationTimestamp
    @Column
    private LocalDateTime created_at;

    public int getId() {
        return order_id;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }
}
