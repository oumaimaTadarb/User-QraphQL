package org.example.usergql.service;

import org.example.usergql.service.dtos.UserDTO;

import java.util.List;

public interface UserManager {

    public UserDTO getUserByEmail(String email);
    public List<UserDTO> getUserByDateNaissance(String dateNaissance);

    public UserDTO saveUser(UserDTO userDTO);

    public UserDTO deleteUser(Long id);
}
