package com.example;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> { //Establishes interface with JPA
    Message findMessagesByUser(String userName);
}
