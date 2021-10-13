package com.clickonlinetochka.clickonlinetochka.repository;

import com.clickonlinetochka.clickonlinetochka.model.Customer;
import com.clickonlinetochka.clickonlinetochka.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Long> {
    Customer findByUser(User user);
}
