package org.example.usergql.dao.repositories;

import org.example.usergql.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByEmail(String email);
    public List<User> findUserByDateNaissance(String dateNaissance);
}