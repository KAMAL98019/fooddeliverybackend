package com.example.foodDelivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user") // Maps the entity to the "user" table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key values
    private Long id;

    @Column(name = "name", nullable = false, length = 100) // Maps to the "name" column
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 100) // Unique constraint for email
    private String email;

    @Column(name = "password", nullable = false) // Maps to the "password" column
    private String password;

    @Column(name = "phone_number", length = 15) // Optional: Phone number with a length limit
    private String phoneNumber;

    // Default constructor
    public User() {
    }
    

    // Parameterized constructor
    public User(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
