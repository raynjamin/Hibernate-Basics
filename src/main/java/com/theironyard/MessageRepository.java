package com.theironyard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by mfahrner on 9/6/16.
 */
public interface MessageRepository extends PagingAndSortingRepository<Message, Integer> {
}
