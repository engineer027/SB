package com.example.springboot.security;

import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import com.example.springboot.service.RoleService;
import com.example.springboot.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final UserService userService;

    public AuthenticationServiceImpl(RoleService roleService,
                                     UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public User register(User user) {
        Role role = roleService.getByName("USER");
        user.setRoles(Set.of(role));
        return userService.create(user);
    }
}
