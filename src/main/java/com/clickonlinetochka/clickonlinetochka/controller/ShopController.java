package com.clickonlinetochka.clickonlinetochka.controller;


import com.clickonlinetochka.clickonlinetochka.model.*;
import com.clickonlinetochka.clickonlinetochka.repository.OrderRepository;
import com.clickonlinetochka.clickonlinetochka.repository.ProductRepository;
import com.clickonlinetochka.clickonlinetochka.repository.UserRepository;
import com.clickonlinetochka.clickonlinetochka.service.CustomerService;
import com.clickonlinetochka.clickonlinetochka.service.MongoUserDetailsService;
import com.clickonlinetochka.clickonlinetochka.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ShopController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private MongoUserDetailsService userDetailsService;
    @Autowired
    private OrderRepository orderRepository;
    private Basked basked = new Basked();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/basket/add")
    public String addItemInBasket(@RequestParam String productId, @RequestParam Long count) throws Exception {
        Product product = productRepository.findById(productId);
        if (product != null) {
            basked.addProductInbasked(product, count);
        } else throw new Exception("Product with id " + productId + " not found");
        return productId;
    }

    @PostMapping("/basket/edit")
    public String editCountItemInBasket(String productId, Long count) throws Exception {
        Product product = productRepository.findAll().stream().filter(product1 -> product1.getId().equals(product1)).findFirst().get();
        if (product != null) {
            basked.addProductInbasked(product, count);
        } else throw new Exception("Product with id " + productId + " not found");
        basked.getProductInBasked().replace(product, count);
        return product.getId();
    }

    @PostMapping("/order/confirmation")
    public String addOrder(@RequestParam(required = true) String username) throws Exception {
        if (basked.getProductInBasked().isEmpty()) {
            throw new Exception("basked is empty");
        }
        Order order = new Order();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Not found user with username " + username);
        }
        User user = userRepository.findByUsername(userDetails.getUsername());
        Customer customer = customerService.findCustomerByUser(user);
        order.setCustomer(customer);
        double totalSum = basked.getProductInBasked().keySet().stream().mapToDouble(Product::getPrice).sum();
        order.setTotalPrice(totalSum);
        order.setProductsInOrder(basked.getProductInBasked());
        UUID uuid = UUID.randomUUID();
        order.setId(uuid.toString());
        orderRepository.save(order);
        return uuid.toString();
    }

}
