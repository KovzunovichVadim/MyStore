package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString(exclude = "products")
@EqualsAndHashCode(exclude = "products")
@Entity(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "categorySeqGen", sequenceName = "category_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "categorySeqGen")
    private Long id;

    @Column(name ="product_group")
    private String productGroup;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "link_products_category",
            joinColumns = @JoinColumn(name = "id_category"),
            inverseJoinColumns = @JoinColumn(name = "id_products"))
    private Collection<Product> products;
}
