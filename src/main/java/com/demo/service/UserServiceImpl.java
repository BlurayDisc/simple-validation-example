package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private AtomicLong counter;

    private Cache<Long, User> userRepository;

    @PostConstruct
    public void init() {
        counter = new AtomicLong();
        userRepository = CacheBuilder.newBuilder()
                .recordStats()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build();
    }

    @Override
    public User findOne(long id) {
        return userRepository.getIfPresent(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.asMap()
                .values()
                .stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        log.info("{}", userRepository.stats());
        return new ArrayList<>(userRepository.asMap().values());
    }

    @Override
    public User save(User user) {
        long id = counter.incrementAndGet();
        user.setId(id);
        userRepository.put(id, user);
        return user;
    }
}