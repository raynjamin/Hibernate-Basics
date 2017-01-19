package com.example;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}