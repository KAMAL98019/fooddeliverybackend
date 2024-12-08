package com.example.foodDelivery.service;

import com.example.foodDelivery.entity.User;
import com.example.foodDelivery.repository.UserRepository;
import com.example.foodDelivery.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse registerUser(User user) {
        // Validate mandatory fields
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return new ApiResponse(false, "Name is mandatory", null);
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return new ApiResponse(false, "Email is mandatory", null);
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return new ApiResponse(false, "Password is mandatory", null);
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().trim().isEmpty()) {
            return new ApiResponse(false, "Phone number is mandatory", null);
        }
    
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return new ApiResponse(false, "Email is already in use", null);
        }
    
        // Save the user
        User savedUser = userRepository.save(user);
        return new ApiResponse(true, "User registered successfully", savedUser);
    }
    

    // User login method
    public ApiResponse loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            return new ApiResponse(false, "User not found with the provided email", null);
        }

        if (!user.getPassword().equals(password)) {
            return new ApiResponse(false, "Invalid password", null);
        }

        return new ApiResponse(true, "Login successful", user);
    }

    // Get all users
    public ApiResponse getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ApiResponse(true, "Users retrieved successfully", users);
    }

    // Find a user by ID
    public ApiResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return new ApiResponse(true, "User retrieved successfully", user);
    }

    // Delete a user by ID
    public ApiResponse deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            return new ApiResponse(false, "User not found with id: " + id, null);
        }
        userRepository.deleteById(id);
        return new ApiResponse(true, "User deleted successfully", null);
    }
}
