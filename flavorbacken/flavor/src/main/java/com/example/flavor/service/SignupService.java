package com.example.flavor.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flavor.model.Signup;


@Service
public class SignupService {
    
    @Autowired
    private com.example.flavor.repository.SignupRepo signupRepo;

    public Signup registerUser(String name, String email, String password) throws Exception {
        Optional<Signup> existingUser = signupRepo.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new Exception("Email already registered");
        }
        Signup user = new Signup();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return signupRepo.save(user);
    }

    public Signup loginUser(String email, String password) throws Exception {
        Signup user = signupRepo.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid credentials");
        }

        return user;
    }

        
}
