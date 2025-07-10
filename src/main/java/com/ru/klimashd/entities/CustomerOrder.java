package com.ru.klimashd.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@PersistenceUnit(unitName = "customersEntityManagerFactory")
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", allocationSize = 1)
    @Column(name = "order_id", insertable = false, updatable = false)
    private int orderId;

    @Column(columnDefinition = "text")
    private String order_info;

    @CreationTimestamp
    @Column
    private LocalDateTime created_at;
}
