package com.example;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        String message;

        @ManyToOne
        User user;

        public Message() {
        }

        public Message(int id, String message, User user) {
                this.id = id;
                this.message = message;
                this.user = user;
        }

        public Message(String message, User user) {
                this.message = message;
                this.user = user;
        }

        public Message(String message) {
                this.message = message;
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

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }
}