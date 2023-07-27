package com.springjms.javajms.service.serviceImpl;

import com.springjms.javajms.entity.User;
import com.springjms.javajms.repository.UserRepository;
import com.springjms.javajms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getEncodedPassword());
        user.setEncodedPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
