package com.learnspringsecurity.Spring.services;

import com.learnspringsecurity.Spring.models.CustomUserDetail;
import com.learnspringsecurity.Spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learnspringsecurity.Spring.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("No User is found");
        }

        return new CustomUserDetail(user);
    }

}
