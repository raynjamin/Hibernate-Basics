package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by mfahrner on 9/6/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
