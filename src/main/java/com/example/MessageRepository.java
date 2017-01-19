package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kelseynewman on 1/18/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
