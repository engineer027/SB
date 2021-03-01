package com.example.springboot.repository;

import com.example.springboot.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User AS u JOIN FETCH u.roles WHERE u.phoneNumber = ?1")
    Optional<User> getUserByPhoneNumber(String phoneNumber);

    @Override
    @Query("SELECT u FROM User AS u JOIN FETCH u.roles where u.id = ?1")
    Optional<User> findById(Long id);
}
