package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
