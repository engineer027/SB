package com.example.springboot.repository;

import com.example.springboot.model.Role;
import java.util.Optional;

import com.example.springboot.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(RoleType roleType);
}
