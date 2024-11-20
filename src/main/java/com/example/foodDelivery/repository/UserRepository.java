package com.example.foodDelivery.repository;

import com.example.foodDelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find a user by email (optional)
    User findByEmail(String email);
}
