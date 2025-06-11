package com.example.demo.controller;

import com.example.demo.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    // GET API with query parameters
    @GetMapping("/greet")
    public String greetUser(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // // GET API with path variable
    // @GetMapping("/user/{id}")
    // public String getUserById(@PathVariable int id) {
    // return "User ID: " + id;
    // }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " not found");
        }
    }

    // // POST API with JSON body
    // @PostMapping("/postuser")
    // public String postUser(@RequestBody User user) {
    // return "Received user: " + user.getName() + ", age: " + user.getAge() + ",
    // id: " + user.getId();
    // }

    // POST API with JSON body - now saves user to DB
    @PostMapping("/postuser")
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
