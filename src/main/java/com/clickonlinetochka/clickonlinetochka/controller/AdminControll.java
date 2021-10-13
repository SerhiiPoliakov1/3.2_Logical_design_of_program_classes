package com.clickonlinetochka.clickonlinetochka.controller;

import com.clickonlinetochka.clickonlinetochka.model.User;
import com.clickonlinetochka.clickonlinetochka.model.UserDto;
import com.clickonlinetochka.clickonlinetochka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AdminControll {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registration")
    public User addUser(@RequestBody UserDto user){
        UUID uuid =  UUID.randomUUID();
        User userForAdding = new User();
        userForAdding.setId(uuid.toString());
        userForAdding.setPassword(passwordEncoder.encode(user.getPassword()));
        userForAdding.setUsername(user.getUsername());
        userForAdding.setEmail(user.getEmail());
        userRepository.save(userForAdding);
        return  userForAdding;
    }

    @GetMapping("/check")
    public String check(){
        return "Success auth";
    }

}
