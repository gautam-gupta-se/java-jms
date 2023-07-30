package com.springjms.javajms.service;

import com.springjms.javajms.entity.CustomerEntity;
import com.springjms.javajms.entity.User;

import java.util.List;

public interface RegistrationService {

    public CustomerEntity registerCustomer(CustomerEntity entity);
}
