package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = {"order", "products"})
@EqualsAndHashCode(exclude = {"order", "products"})
@Entity(name = "orders_detail")
public class OrdersDetail {
    @Id
    @SequenceGenerator(name = "orderDetailSeqGen", sequenceName = "orders_detail_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "orderDetailSeqGen")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orders")
    private Order order;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_product_orders_detail",
            joinColumns = @JoinColumn(name = "id_orders_detail"),
            inverseJoinColumns = @JoinColumn(name = "id_products"))
    private Collection<Product> products;
}
