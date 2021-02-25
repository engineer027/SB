package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.model.dto.UserRequestDto;
import com.example.springboot.model.dto.UserResponseDto;
import com.example.springboot.security.AuthenticationService;
import com.example.springboot.service.UserService;
import com.example.springboot.service.mapper.UserMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService,
                          UserMapper userMapper,
                          AuthenticationService authenticationService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@PathVariable Long userId) {
        User user = userService.findById(userId).get();
        return userMapper.mapUserToDto(user);
    }

    @GetMapping("/by-phone")
    public UserResponseDto getUserByPhoneNumber(@RequestParam String phoneNumber) {
        User user = userService.findByPhoneNumber(phoneNumber).get();
        return userMapper.mapUserToDto(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.remote(userId);
    }

    @PutMapping("/{userId}")
    public void update(@PathVariable Long userId,
                       @RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMapper.mapDtoToUser(userRequestDto);
        user.setId(userId);
        userService.update(user);
    }

    @PostMapping
    public void create(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.mapDtoToUser(userRequestDto);
        authenticationService.register(user);
    }
}
