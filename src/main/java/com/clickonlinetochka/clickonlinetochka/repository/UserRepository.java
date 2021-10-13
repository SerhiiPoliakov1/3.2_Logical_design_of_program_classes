package com.clickonlinetochka.clickonlinetochka.repository;

import com.clickonlinetochka.clickonlinetochka.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
}
