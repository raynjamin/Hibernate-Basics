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

        @Column(nullable = false)
        int userId;

        public Message() {
        }

        public Message(String message) {
                this.message = message;
        }

        public Message(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public Message(String name, String message, int userId) {
                this.name = name;
                this.message = message;
                this.userId = userId;
        }
}
