package com.example.springboot.model.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotNull
    private String name;
    private String dataOfBirth;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
}
