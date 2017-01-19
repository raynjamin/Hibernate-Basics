package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 1/18/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
