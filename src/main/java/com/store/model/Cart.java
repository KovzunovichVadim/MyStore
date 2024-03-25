package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = {"account", "products"})
@EqualsAndHashCode(exclude = {"account", "products"})
@Entity(name = "cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cartSeqGen", sequenceName = "cart_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cartSeqGen")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_accounts")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_products_cart",
            joinColumns = @JoinColumn(name = "id_cart"),
            inverseJoinColumns = @JoinColumn(name = "id_products"))
    private Collection<Product> products;
}
