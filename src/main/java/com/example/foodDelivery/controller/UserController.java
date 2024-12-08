package com.example.foodDelivery.controller;

import com.example.foodDelivery.entity.User;
import com.example.foodDelivery.response.ApiResponse;
import com.example.foodDelivery.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody User user) {
        System.out.println("register"+user);
        ApiResponse registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        ApiResponse response = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
        ApiResponse users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        ApiResponse user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Long id) {
        ApiResponse response = userService.deleteUserById(id);
        return ResponseEntity.ok(response);
    }
}
