package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.validator.sequence.Sequence;

@RequestMapping("/demo")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@Validated(Sequence.class) @RequestBody User user) {
        return userService.save(user);
    }

}
