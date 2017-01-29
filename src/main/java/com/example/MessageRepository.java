package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by stephenwilliamson on 1/19/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
