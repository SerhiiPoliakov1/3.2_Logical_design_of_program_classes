package com.clickonlinetochka.clickonlinetochka.repository;

import com.clickonlinetochka.clickonlinetochka.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Long> {
}
