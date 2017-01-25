package com.example;

import com.example.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by emileenmarianayagam on 1/24/17.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findFirstByName(String name);
}
