package com.moshJava.stores.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "profiles")
public class Profile {

    @Column(nullable = false, name = "profile_id")
    private long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "loyalty_points")
    private int loyalty_points;

    @OneToOne
    @JoinColumn(name = "profile_id")
    @MapsId
    @ToString.Exclude
    private User user;

}
