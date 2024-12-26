package com.learnspringsecurity.Spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnspringsecurity.Spring.models.User;

@Service
public class UserService {
    
    List<User> list  = new ArrayList<>();

    public UserService(){
        list.add(new User("bhargaw21" , "bhargaw123" , "bhargaw123@gmail.com" , "ADMIN"));
        list.add(new User("piyush22" , "piyush123" , "piyush123@gmail.com" , "USER"));
    }

    //get all user
    public List<User> getAllUsers(){
        return this.list;
    }

    //get single user
    public User getUser(String username){
        return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
