package com.example._223.mapper;

import com.example._223.model.dto.UserDTO;
import com.example._223.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        return user;
    }
}
