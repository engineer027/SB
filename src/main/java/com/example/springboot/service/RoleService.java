package com.example.springboot.service;

import com.example.springboot.model.Role;
import com.example.springboot.model.RoleType;

public interface RoleService {
    Role getByName(RoleType roleType);

    Role save(Role role);
}
