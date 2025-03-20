package com.codea.eccomerce.aplication.service;

import com.codea.eccomerce.aplication.repository.UserRepository;
import com.codea.eccomerce.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findById(Integer id) {
        return userRepository.findById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.updateUser(user);
        if (updatedUser == null) {
            throw new RuntimeException("Error: Usuario no encontrado o no se pudo actualizar.");
        }
        return updatedUser;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }
}
