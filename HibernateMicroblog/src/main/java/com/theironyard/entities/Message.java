package com.theironyard.entities;


import javax.persistence.*;

@Entity
@Table
public class Message {

    @Id
    @GeneratedValue
    public Integer id;

    @Column (nullable = false)
    public String text;

    public Message () {

    }

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message(String text) {
        this.text = text;
    }
}
