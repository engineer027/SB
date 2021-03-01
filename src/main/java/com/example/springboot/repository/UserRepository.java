package com.example.springboot.repository;

import com.example.springboot.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUsersByPhoneNumber(String phoneNumber);
}
