package com.example.user_api.controller;

import com.example.user_api.model.User;
import com.example.user_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user-api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/user-api/v1/users";
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/additional-info")
    public List<User> getUsersByCountryExclusion(@RequestParam String country) {
        return userService.getUsersByCountryExclusion(country);
    }
}
