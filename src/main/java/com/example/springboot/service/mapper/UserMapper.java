package com.example.springboot.service.mapper;

import com.example.springboot.model.User;
import com.example.springboot.model.dto.UserRequestDto;
import com.example.springboot.model.dto.UserResponseDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setDateOfBirth(user.getDateOfBirth());
        userResponseDto.setPhoneNumber(user.getPhoneNumber());
        return userResponseDto;
    }

    public User mapDtoToUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setPassword(userRequestDto.getPassword());
        user.setDateOfBirth(LocalDate.parse(userRequestDto.getDataOfBirth(),
                DateTimeFormatter.ISO_LOCAL_DATE));
        return user;
    }
}
