package com.learnspringsecurity.Spring.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringsecurity.Spring.models.User;
import com.learnspringsecurity.Spring.services.UserService;

@RestController
@RequestMapping("/start")
public class UserController {

@Autowired
private UserService userService;

//all users
@GetMapping("/")
public List<User> getAllUsers(){
  return  this.userService.getAllUsers();
}
    
// return single user
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/{username}")
public User getSingleUser(@PathVariable("username") String username){
    return this.userService.getUser(username);
}

// add user
@PostMapping("/add")
public User addUser(@RequestBody User user){
    return this.userService.addUser(user);
}

}
