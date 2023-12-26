package org.example.usergql.service;

import org.example.usergql.dao.entities.User;
import org.example.usergql.dao.repositories.UserRepository;
import org.example.usergql.service.dtos.UserDTO;
import org.example.usergql.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserManagerAction  implements UserManager{
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public UserRepository userRepository;
    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.fromUserToUserDTO(userRepository.findUserByEmail(email));
    }
    @Override
    public List<UserDTO> getUserByDateNaissance(String dateNaissance) {
        List<User> users = userRepository.findUserByDateNaissance(dateNaissance);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users)
        {
            userDTOS.add(userMapper.fromUserToUserDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if(userRepository.findUserByEmail(userDTO.getEmail())!= null)
        {
            throw new RuntimeException("Utilisateur avec cette email existe deja");
        }
        return userMapper.fromUserToUserDTO(userRepository.save(userMapper.fromUserDTOToUser(userDTO)));
    }

    @Override
    public UserDTO deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            userRepository.delete(user1);
        }
        return userMapper.fromUserToUserDTO(user.get());
    }}
