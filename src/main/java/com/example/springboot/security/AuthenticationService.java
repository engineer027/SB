package com.example.springboot.security;

import com.example.springboot.model.User;

public interface AuthenticationService {
    User register(User user);
}
