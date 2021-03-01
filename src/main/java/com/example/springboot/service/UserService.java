package com.example.springboot.service;

import com.example.springboot.model.User;

public interface UserService {
    User save(User user);

    User findById(Long idUser);

    User findByPhoneNumber(String phoneNumber);

    void remote(Long idUser);
}
