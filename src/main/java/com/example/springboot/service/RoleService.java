package com.example.springboot.service;

import com.example.springboot.model.Role;

public interface RoleService {
    Role getByName(String roleType);

    Role save(Role role);
}
