package com.example.springboot.service;

import com.example.springboot.model.Role;
import com.example.springboot.model.RoleType;
import com.example.springboot.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByName(String roleType) {
        return roleRepository.getRoleByRoleName(RoleType.valueOf(roleType)).get();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
