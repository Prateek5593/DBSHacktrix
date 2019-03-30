package com.dbs.hacktrix.pqrchits.service;

import com.dbs.hacktrix.pqrchits.domain.User;
import com.dbs.hacktrix.pqrchits.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user){
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
