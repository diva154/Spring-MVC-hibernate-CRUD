package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")

public class UserController {

    private final UserService userService;
    //constructor
    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/new")
    public String showCreateform(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

        @PostMapping("/save")
                public String saveUser(@ModelAttribute("user") User user){
            if (user.getId() == null) {
                userService.saveUser(user);
            }else {
                userService.updateUser(user);
            }
            return  "redirect:/users";
        }
        @GetMapping("/edit/{id}")
    public  String showEditForm(@PathVariable("id") Long id, Model model){
       User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return  "redirect:/users";
    }
}
