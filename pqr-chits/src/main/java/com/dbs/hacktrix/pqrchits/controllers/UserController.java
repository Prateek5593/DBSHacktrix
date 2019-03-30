package com.dbs.hacktrix.pqrchits.controllers;

import com.dbs.hacktrix.pqrchits.domain.User;
import com.dbs.hacktrix.pqrchits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
