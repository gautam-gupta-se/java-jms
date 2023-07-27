package com.springjms.javajms.controller;
import com.springjms.javajms.entity.User;
import com.springjms.javajms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final RegistrationService userService;

    @Autowired
    public UserController(RegistrationService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Username already exists
        }
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    @GetMapping("/msg")
    public String op(){
        return "Hello public api";
    }
    @GetMapping("/demo")
    public String demoOp(){
        return "Hello demo API un authenticated";
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        System.out.println(username);
        User existingUser = userService.getUserByUsername(username);
        System.out.println(existingUser);
        System.out.println(userService.getAllUser());

        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}
