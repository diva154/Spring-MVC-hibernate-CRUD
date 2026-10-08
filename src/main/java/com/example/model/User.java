package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

//use @Pattern for requirement is specifically
// firstName and lastName cannot contain numbers
// Also add Pattern dependency in pom.xml
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "First name must contain only letters" )
    @Column(name = "first_name", nullable = false)
    private String firstName;

 @Pattern(
         regexp = "^[a-zA-Z]+$",
         message = "Last name must contain only letters" )

//But this alone won't display the message to the user. You also need @Valid + BindingResult
// in your controller and th:errors in your Thymeleaf form.
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    public User() {
    }

    //generate constructor
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //generate getter and setter for ID for entry by user

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

//generate getter and setter for firstname, lastname and email for entry by user

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

