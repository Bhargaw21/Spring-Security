package com.learnspringsecurity.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringsecurity.Spring.models.User;

public interface UserRepo extends JpaRepository<User, String> {

    Object findByUsername(String username);

}
