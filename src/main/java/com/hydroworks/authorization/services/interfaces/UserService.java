package com.hydroworks.authorization.services.interfaces;

import com.hydroworks.authorization.exceptions.ResourceNotFoundException;

import java.util.List;

import com.hydroworks.authorization.models.dtos.UpdatePasswordDto;
import com.hydroworks.authorization.models.dtos.UpdateUserDto;
import com.hydroworks.authorization.models.dtos.CreateUserDto;
import com.hydroworks.authorization.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(CreateUserDto createUserDto);

    List<User> findAll();

    void delete(String id);

    User findByEmail(String email) throws ResourceNotFoundException;

    User findById(String id) throws ResourceNotFoundException;

    User update(String id, UpdateUserDto updateUserDto) throws ResourceNotFoundException;

    void update(User user);

    User updatePassword(String id, UpdatePasswordDto updatePasswordDto)
        throws ResourceNotFoundException;

    void updatePassword(String id, String newPassword) throws ResourceNotFoundException;

    void confirm(String id) throws ResourceNotFoundException;
}
