package com.store.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = "account")
@EqualsAndHashCode(exclude = "account")
@Entity(name = "security")
public class Security {
    @Id
    @SequenceGenerator(name = "securitySeqGen", sequenceName = "security_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "securitySeqGen")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_accounts")
    private Account account;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
