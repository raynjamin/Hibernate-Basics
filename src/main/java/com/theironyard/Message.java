package com.theironyard;

import javax.persistence.*;

/**
 * Created by graceconnelly on 1/18/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String userName;

    @Column(nullable = false)
    String userMessage;

    public Message() {
    }

    public Message(String userName, String userMessage) {
        this.userName = userName;
        this.userMessage = userMessage;
    }
}
