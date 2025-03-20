package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.aplication.repository.UserRepository;
import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.entity.UserEntity;
import com.codea.eccomerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }

    @Override
    public List<User> findAll() {
        Iterable<UserEntity> userEntities = userCrudRepository.findAll();
        return StreamSupport.stream(userEntities.spliterator(), false)
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }


    @Override
    public User updateUser(User user) {
        return userCrudRepository.findById(user.getId()).map(existingUser -> {
            // Solo actualiza los campos que se enviaron en el formulario
            existingUser.setUsername(user.getUsername() != null ? user.getUsername() : existingUser.getUsername());
            existingUser.setFirstName(user.getFirstName() != null ? user.getFirstName() : existingUser.getFirstName());
            existingUser.setLastName(user.getLastName() != null ? user.getLastName() : existingUser.getLastName());
            existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
            existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
            existingUser.setCellphone(user.getCellphone() != null ? user.getCellphone() : existingUser.getCellphone());
            existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
            existingUser.setUserType(user.getUserType() != null ? user.getUserType() : existingUser.getUserType());

            // Guarda la entidad actualizada
            UserEntity updatedEntity = userCrudRepository.save(existingUser);
            return userMapper.toUser(updatedEntity);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void deleteUser(Integer id) {
        userCrudRepository.findById(id).ifPresent(userCrudRepository::delete);
    }

}
