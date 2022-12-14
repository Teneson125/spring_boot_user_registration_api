package com.example.spring_boot_user_registration_api.controller;

import com.example.spring_boot_user_registration_api.model.Data;
import com.example.spring_boot_user_registration_api.model.User;
import com.example.spring_boot_user_registration_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user/save")
    public String userRegister(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("users")
    public List<User> displayUsers(){
        return userService.getUsers();
    }

    @GetMapping("user")
    public User findUser(@RequestParam String email){
        return userService.getUser(email);
    }
    @PostMapping("login")
    public HashMap<String, User> login(@RequestBody Data data){
        return userService.login(data);
    }
}
