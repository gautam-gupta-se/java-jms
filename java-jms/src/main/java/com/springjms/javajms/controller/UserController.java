package com.springjms.javajms.controller;
import com.springjms.javajms.entity.User;
import com.springjms.javajms.repository.CustomerRepository;
import com.springjms.javajms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private final RegistrationService userService;
    @Autowired
    CustomerRepository repo;

    @Autowired
    public UserController(RegistrationService userService) {
        this.userService = userService;
    }

    @GetMapping("/msg")
    public String op(){
        System.out.println(repo.findAll());
        return "Hello public api";
    }
    @GetMapping("/demo")
    public String demoOp(){
        System.out.println(repo.findAll());
        return "Hello demo API un authenticated";
    }


}
