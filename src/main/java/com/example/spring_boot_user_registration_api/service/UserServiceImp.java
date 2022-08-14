package com.example.spring_boot_user_registration_api.service;

import com.example.spring_boot_user_registration_api.model.User;
import com.example.spring_boot_user_registration_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail())==null){
            userRepository.save(user);
            return "success";
        }
        return "email already taken";
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
