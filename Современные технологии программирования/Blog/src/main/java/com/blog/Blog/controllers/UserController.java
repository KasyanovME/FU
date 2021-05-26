package com.blog.Blog.controllers;

import com.blog.Blog.entity.User;
import com.blog.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> readUser() {
        final List<User> userList = userService.findAll();

        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> readUser(@PathVariable(name = "id") Long id ) {
        final Optional<User> user = userService.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/users")
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(name = "id") Long id) {
        if (userService.findById(id).isPresent()) {
            userService.updateUser(user, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/users")
    public void deleteAll() {
        userService.deleteAll();
    }
}
