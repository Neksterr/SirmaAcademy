package com.softuni.resellerApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Length(min = 3, max = 20)
    @Column(nullable = false, unique = true )
    private String  username;


    @Column(nullable = false )
    private String password;

    @Email
    @Column(nullable = false, unique = true )
    private String email;

    @OneToMany(mappedBy = "createdBy")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "boughtBy")
    private Set<Offer> boughtOffers;

    public User() {
        this.offers = new HashSet<>();
        this.boughtOffers = new HashSet<>();
    }

    public @Length(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Length(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @Length(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@Length(min = 3, max = 20) String password) {
        this.password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(Set<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }
}
