package com.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String created;
}
