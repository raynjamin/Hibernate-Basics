package com.example;


import javax.persistence.*;

/**
 * Created by stephenwilliamson on 1/19/17.
 */

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = true)
    String message;

    @ManyToOne
    User user;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
