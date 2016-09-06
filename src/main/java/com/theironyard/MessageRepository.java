package com.theironyard;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
} // repository that does crud operations on Message and id type is integer
