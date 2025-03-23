package com.om1cael.simplified.picpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private Double balance;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    private String password;
}