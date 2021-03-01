package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long idUser) {
        return userRepository.findById(idUser).get();
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.getUserByPhoneNumber(phoneNumber).get();
    }

    @Override
    public void remote(Long id) {
        userRepository.deleteById(id);
    }
}
