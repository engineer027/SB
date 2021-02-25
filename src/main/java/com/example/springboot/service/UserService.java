package com.example.springboot.service;

import com.example.springboot.model.User;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User update(User user);

    Optional<User> findById(Long idUser);

    Optional<User> findByPhoneNumber(String phoneNumber);

    void remote(Long idUser);
}
