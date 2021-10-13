package com.clickonlinetochka.clickonlinetochka.repository;

import com.clickonlinetochka.clickonlinetochka.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,Long> {
    Product findById(String id);
    Product deleteById(String id);
}
