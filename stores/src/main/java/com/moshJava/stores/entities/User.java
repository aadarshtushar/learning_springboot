package com.moshJava.stores.entities;

import jakarta.persistence.*;
import lombok.*;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "fk_wishlist_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_wishlist_product_id")
    )
    private Set<Product> products = new HashSet<Product>();

    public void addAddresses(Address address){
        addresses.add(address);
        address.setUser(this);
    }

    public void createTag(String tagName){

        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUser().add(this);

    }

    public void removeTag(){
        tags.forEach(tag -> {tag.getUser().clear();});
        tags.clear();
    }

}
