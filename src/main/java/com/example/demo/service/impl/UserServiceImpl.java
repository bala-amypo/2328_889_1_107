package com.example.demo.service.impl;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    public UserServiceImpl(UserRepository ur) { this.userRepo = ur; }
    public User register(User u) {
        if (userRepo.existsByEmail(u.getEmail())) throw new RuntimeException("exists");
        return userRepo.save(u);
    }
    public User findByEmail(String e) {
        return userRepo.findByEmail(e).orElseThrow(() -> new RuntimeException("not found"));
    }
}