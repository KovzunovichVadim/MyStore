package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = {"categories", "ordersDetails", "carts"})
@EqualsAndHashCode(exclude = {"categories", "ordersDetails", "carts"})
@Entity(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name = "productSeqGen", sequenceName = "products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "productSeqGen")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_products_category",
            joinColumns = @JoinColumn(name = "id_products"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Collection<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_product_orders_detail",
            joinColumns = @JoinColumn(name = "id_products"),
            inverseJoinColumns = @JoinColumn(name = "id_orders_detail"))
    private Collection<OrdersDetail> ordersDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_products_cart",
            joinColumns = @JoinColumn(name = "id_products"),
            inverseJoinColumns = @JoinColumn(name = "id_cart"))
    private Collection<Cart> carts;
}
