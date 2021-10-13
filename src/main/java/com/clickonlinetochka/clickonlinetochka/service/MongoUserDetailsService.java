package com.clickonlinetochka.clickonlinetochka.service;

import com.clickonlinetochka.clickonlinetochka.model.AuthenticationRequest;
import com.clickonlinetochka.clickonlinetochka.model.CustomerUserDetail;
import com.clickonlinetochka.clickonlinetochka.model.Role;
import com.clickonlinetochka.clickonlinetochka.model.User;
import com.clickonlinetochka.clickonlinetochka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepository.findByUsername(username);
        CustomerUserDetail customerUserDetail = null;

        if(byUsername != null){
           customerUserDetail =  new CustomerUserDetail();
            customerUserDetail.setUser(byUsername);

        }
        else {
        throw  new UsernameNotFoundException("User with username "+ username + "not found");
        }
        return customerUserDetail;
    }
}
