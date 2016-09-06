package com.theironyard;

import javax.persistence.*;

/**
 * Created by mfahrner on 9/6/16.
 */

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }
}
