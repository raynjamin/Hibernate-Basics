package com.example;

import javax.persistence.*;

/**
 * Created by emileenmarianayagam on 1/18/17.
 */
@Entity
@Table (name ="messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
