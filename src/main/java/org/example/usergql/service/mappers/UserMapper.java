package org.example.usergql.service.mappers;

import org.example.usergql.dao.entities.User;
import org.example.usergql.service.dtos.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO fromUserToUserDTO(User user){
        return this.modelMapper.map(user,UserDTO.class);
    }

    public User fromUserDTOToUser(UserDTO userDTO){
        return this.modelMapper.map(userDTO,User.class);
    }
}
