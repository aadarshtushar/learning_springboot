package com.moshJava.stores.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;

    @Column(nullable = false, name = "street")
    private String street;

    @Column(nullable = false, name = "city")
    private String city;

    @Column(nullable = false, name = "state")
    private String state;

    @Column(nullable = false, name = "zip")
    private String zip;

    @Column(nullable = false, name = "users_id")
    private long user_id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @ToString.Exclude
    private User user;

}
