package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @ManyToOne
    User user;

    public Message() {
    }

    public Message(int id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Message(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
