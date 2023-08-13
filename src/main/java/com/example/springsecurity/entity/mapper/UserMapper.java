package com.example.springsecurity.entity.mapper;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.entity.dto.UserDTO;


public class UserMapper {
    public static UserDTO toUserDto(User user) {
        UserDTO userDto = new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getNumberPhone(),
                user.getRoles()
        );
        return userDto;
    }
}
