package com.example.dao;

import com.example.model.User;

import java.util.List;
import java.util.Locale;


public interface UserDao {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void  deleteUser(Long id);
}
