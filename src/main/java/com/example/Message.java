package com.example;

import javax.persistence.*;

/**
 * Created by kelseynewman on 1/18/17.
 */
@Entity
@Table(name = "messages")
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
}
