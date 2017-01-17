package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.User;

public interface UserService {

    User findOne(long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    User save(User user);

}