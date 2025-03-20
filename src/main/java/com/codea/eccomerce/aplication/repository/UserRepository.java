package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {
    public User createUser(User user);
    public User findByEmail(String email);
    public User findById(Integer id);
    List<User> findAll();
    User updateUser(User user);
    void deleteUser(Integer id);
}
