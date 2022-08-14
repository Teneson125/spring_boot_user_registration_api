package com.example.spring_boot_user_registration_api.service;

import com.example.spring_boot_user_registration_api.model.User;

import java.util.List;

public interface UserService {
    String saveUser(User user);
    User getUser(String email);
    List<User> getUsers();
}
