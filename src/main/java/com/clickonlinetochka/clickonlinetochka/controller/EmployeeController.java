package com.clickonlinetochka.clickonlinetochka.controller;

import com.clickonlinetochka.clickonlinetochka.model.EmloyeeDto;
import com.clickonlinetochka.clickonlinetochka.model.Employee;
import com.clickonlinetochka.clickonlinetochka.model.User;
import com.clickonlinetochka.clickonlinetochka.repository.EmployeeRepository;
import com.clickonlinetochka.clickonlinetochka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee/registration")
    public User registration(@RequestBody EmloyeeDto emloyeeDto){
        User user = new User();
        user.setUsername(emloyeeDto.getUsername());
        user.setPassword(passwordEncoder.encode(emloyeeDto.getPassword()));
        user.setEmail(emloyeeDto.getEmail());

        Employee newEmployee = new Employee();
        newEmployee.setFirstName(emloyeeDto.getFirstName());
        newEmployee.setLastName(emloyeeDto.getLastName());
        newEmployee.setSalary(emloyeeDto.getSalary());
        newEmployee.setUser(user);

        userRepository.save(user);
        employeeRepository.save(newEmployee);
        return user;

    }
}
