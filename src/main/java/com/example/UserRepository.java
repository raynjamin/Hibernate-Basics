package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by temp on 1/18/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
