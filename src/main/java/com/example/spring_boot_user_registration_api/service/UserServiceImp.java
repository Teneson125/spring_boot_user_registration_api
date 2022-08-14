package com.example.spring_boot_user_registration_api.service;

import com.example.spring_boot_user_registration_api.model.User;
import com.example.spring_boot_user_registration_api.model.Data;
import com.example.spring_boot_user_registration_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(User user) {
        if(!checkEmailAvailable(user.getEmail())){
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

    @Override
    public HashMap<String, User> login(Data data){
        HashMap<String, User> details= new HashMap<>();
        if (checkEmailAvailable(data.getEmail())) {
            if(checkPassword(data)){
                details.put("login success", userRepository.findByEmail(data.getEmail()));
            }else {
                details.put("invalid password", null);
            }
        } else {
            details.put("invalid email id", null);
        }
        return details;
    }
    protected boolean checkEmailAvailable(String email){
        return userRepository.findByEmail(email) != null;
    }
    protected boolean checkPassword(Data data){
        User user = userRepository.findByEmail(data.getEmail());
        return user.getPassword().equals(data.getPassword());
    }

}
