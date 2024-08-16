package com.example.flavor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flavor.model.Signup;


public interface SignupRepo extends JpaRepository<Signup, Long> {
    Optional<Signup> findByEmail(String email);
}