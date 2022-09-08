package com.rickylee.springbootsticker.controller;

import com.rickylee.springbootsticker.dto.UserRequest;
import com.rickylee.springbootsticker.model.User;
import com.rickylee.springbootsticker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        User user = userService.getUser(userId);

        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createProduct(@RequestBody @Valid UserRequest userRequest) {
        Integer userId = userService.createUser(userRequest);

        User user = userService.getUser(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId,
                                           @RequestBody @Valid UserRequest userRequest) {

        User user = userService.getUser(userId);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        userService.updateUser(userId, userRequest);

        User updatedUser = userService.getUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {

        userService.deleteUser(userId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
