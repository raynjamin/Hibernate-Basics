package com.example;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        String name;

        @Column(nullable = false)
        String message;

        public Message() {
        }

        public Message(String name, String message) {
            this.name = name;
            this.message = message;
        }
}
