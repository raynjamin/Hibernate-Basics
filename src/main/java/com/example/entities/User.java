package com.example.entities;

import com.example.Message;

import javax.persistence.*;
import java.util.List;

/**
 * Created by emileenmarianayagam on 1/24/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;
    @Column(nullable = false)
    String name;

    @Column(nullable =false)
    String password;

    @OneToMany (mappedBy = "user")
    List<Message> messages;

    public User() {
    }

    public User(int id, String name, String password, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.messages = messages;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
