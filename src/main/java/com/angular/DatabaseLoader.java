package com.angular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.angular.entity.User;
import com.angular.repo.UserRepo;
 
@Component
public class DatabaseLoader implements CommandLineRunner {
 
    private final UserRepo userRepository;
 
    @Autowired
    public DatabaseLoader(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
 
    @Override
    public void run(String... args) throws Exception {
        // Create and save user data
        User user1 = new User();
        user1.setUserName("Yashu");
        user1.setPassword("password@1");
        userRepository.save(user1);
 
    }

}
