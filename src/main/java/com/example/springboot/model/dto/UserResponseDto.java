package com.example.springboot.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
