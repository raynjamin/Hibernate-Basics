package com.theironyard.interfaces;

import com.theironyard.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository< Message, Integer > {

}
