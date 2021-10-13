package com.clickonlinetochka.clickonlinetochka.repository;

import com.clickonlinetochka.clickonlinetochka.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Long> {
}
