package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = {"account", "ordersDetails"})
@EqualsAndHashCode(exclude = {"account", "ordersDetails"})
@Entity(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "orderSeqGen", sequenceName = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "orderSeqGen")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_accounts")
    private Account account;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String orderDate;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<OrdersDetail> ordersDetails;
}
