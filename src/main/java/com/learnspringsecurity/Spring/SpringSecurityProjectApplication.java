package com.learnspringsecurity.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learnspringsecurity.Spring.models.User;
import com.learnspringsecurity.Spring.repository.UserRepo;

@SpringBootApplication
public class SpringSecurityProjectApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin")); 
		user.setEmail("admin123@gmail.com");
		user.setRole("ROLE_ADMIN");
		this.userRepo.save(user);

			User user1 = new User();
			user1.setUsername("rahul");
			user1.setPassword(this.bCryptPasswordEncoder.encode("rahul123")); 
			user1.setEmail("rahul123@gmail.com");
			user1.setRole("ROLE_USER");
			this.userRepo.save(user1);
	}

}
