package com.example.flavor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flavor.model.Login;
import com.example.flavor.model.Signup;
import com.example.flavor.service.SignupService;




@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class SignupController {


    @Autowired
    private SignupService loginService;

      @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Signup user) {
        try {
            Signup newUser = loginService.registerUser(user.getName(), user.getEmail(), user.getPassword());
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Login loginRequest) {
        try {
            Signup user = loginService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok("Login successful.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
