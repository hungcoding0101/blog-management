package com.example.blogmanagement.config;

import com.example.blogmanagement.model.User;
import com.example.blogmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final UserRepository userRepository;
    
    @Autowired
    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (userRepository.count() == 0) {
            initializeUsers();
        }
    }
    
    private void initializeUsers() {
        // Create sample users
        User user1 = new User("john_doe", "john.doe@example.com", "password123", "John", "Doe");
        User user2 = new User("jane_smith", "jane.smith@example.com", "password456", "Jane", "Smith");
        User user3 = new User("mike_wilson", "mike.wilson@example.com", "password789", "Mike", "Wilson");
        User user4 = new User("sarah_brown", "sarah.brown@example.com", "passwordabc", "Sarah", "Brown");
        User user5 = new User("alex_johnson", "alex.johnson@example.com", "passworddef", "Alex", "Johnson");
        
        // Make one user inactive for testing
        user5.setIsActive(false);
        
        // Save users
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        
        System.out.println("Sample user data initialized successfully!");
    }
}
