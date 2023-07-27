package com.springjms.javajms.service;

import com.springjms.javajms.entity.User;

import java.util.List;

public interface RegistrationService {
    public User registerUser(User user);
    public User getUserByUsername(String username);
    public List<User> getAllUser();
}
