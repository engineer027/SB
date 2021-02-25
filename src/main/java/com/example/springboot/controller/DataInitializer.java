package com.example.springboot.controller;

import com.example.springboot.model.Role;
import com.example.springboot.model.RoleType;
import com.example.springboot.service.RoleService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;

    public DataInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void addRole() {
        Role user = new Role();
        user.setRoleName(RoleType.USER);
        roleService.save(user);
        Role admin = new Role();
        admin.setRoleName(RoleType.ADMIN);
        roleService.save(admin);
    }
}
