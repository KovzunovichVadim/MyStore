package com.store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@ToString(exclude = {"security", "orders", "carts"})
@EqualsAndHashCode(exclude = {"security", "orders", "carts"})
@Entity(name = "accounts")
public class Account {
    @Id
    @SequenceGenerator(name = "accountSeqGen", sequenceName = "accounts_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "accountSeqGen")
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private String created;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Security security;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Order> orders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Cart> carts;

    public Account(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
