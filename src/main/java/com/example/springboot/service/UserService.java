package com.example.springboot.service;

import com.example.springboot.model.User;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User getUserByPhoneNumber(String phoneNumber);

    void remove(Long id);
}
