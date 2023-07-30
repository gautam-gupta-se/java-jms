package com.springjms.javajms.controller;

import com.springjms.javajms.entity.CustomerEntity;
import com.springjms.javajms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<CustomerEntity> registerCustomerByForm(@RequestBody CustomerEntity customerEntity){
        CustomerEntity registerCustomer =registrationService.registerCustomer(customerEntity);
        return new ResponseEntity<>(registerCustomer, HttpStatus.CREATED);
    }
}
