package com.example;

import com.example.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emileenmarianayagam on 1/18/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message>  findByUser (User user);

}
