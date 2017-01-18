package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by emileenmarianayagam on 1/18/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
