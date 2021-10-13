package com.clickonlinetochka.clickonlinetochka.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDto {

    @Email
    private String email;
    @Size(min = 5,max = 12)
    private String username;
    @Size(min = 8)
    private String password;


    public UserDto(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
