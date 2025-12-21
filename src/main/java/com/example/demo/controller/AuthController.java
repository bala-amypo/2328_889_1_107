package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping
    public User createUser(@RequestBody User user) { return userService.createUser(user); }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { return userService.getUser(id); }

    @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @PutMapping
    public User updateUser(@RequestBody User user) { return userService.updateUser(user); }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id); }
}
