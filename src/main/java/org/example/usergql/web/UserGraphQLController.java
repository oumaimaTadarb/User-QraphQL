package org.example.usergql.web;

import org.example.usergql.service.UserManager;
import org.example.usergql.service.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphQLController {
    @Autowired
    public UserManager userManager;

    //    getUserByEmail(email:String):UserDTO
    @QueryMapping
    public UserDTO getUserByEmail(@Argument String email){
        return userManager.getUserByEmail(email);
    }

    //    getUserByDateNaissance(date:String):UserDTO
    @QueryMapping
    public List<UserDTO> getUserByDateNaissance(@Argument String dateNaissance){
        return  userManager.getUserByDateNaissance(dateNaissance);
    }

    //    saveUser(userDTO:UserDTOInput): UserDTO
    @MutationMapping
    public UserDTO saveUser(@Argument UserDTO userDTO){
        return  userManager.saveUser(userDTO);
    }

    //    deleteUser(id:ID):UserDTO
    @MutationMapping
    public UserDTO deleteUser(@Argument Long id){
        return userManager.deleteUser(id);
    }
}
