package com.clickonlinetochka.clickonlinetochka.service;

import com.clickonlinetochka.clickonlinetochka.model.Customer;
import com.clickonlinetochka.clickonlinetochka.model.User;
import com.clickonlinetochka.clickonlinetochka.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByEmail(String email) throws Exception {
        Customer customer = customerRepository.findAll().stream().filter(c -> c.getEmail().equals(email)).findFirst().get();
        if (customer != null) return customer;
        else
            throw new Exception("Customer not found!");

    }

    public Customer getCustomerByPhone(String phone) throws Exception {
        Customer customer = customerRepository.findAll().stream().filter(c -> c.getPhone().equals(phone)).findFirst().get();
        if (customer != null) return customer;
        else throw new Exception("Customer not found!");
    }
    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public Customer findCustomerByUser(User user){
        return customerRepository.findByUser(user);
    }

}
