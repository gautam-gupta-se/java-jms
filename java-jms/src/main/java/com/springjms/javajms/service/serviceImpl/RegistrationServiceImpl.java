package com.springjms.javajms.service.serviceImpl;

import com.springjms.javajms.entity.CustomerEntity;
import com.springjms.javajms.entity.User;
import com.springjms.javajms.repository.CustomerRepository;
import com.springjms.javajms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder passwordEncoder;
    CustomerRepository customerRepository;

    @Autowired
    public RegistrationServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity entity) {
        String plainPwd = entity.getPassword();
        String hashedPwd = passwordEncoder.encode(plainPwd);
        entity.setPassword(hashedPwd);
        return customerRepository.save(entity);
    }
}
