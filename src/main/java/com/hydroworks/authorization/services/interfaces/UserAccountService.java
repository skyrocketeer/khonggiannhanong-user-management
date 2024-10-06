package com.hydroworks.authorization.services.interfaces;

import com.hydroworks.authorization.exceptions.ResourceNotFoundException;
import com.hydroworks.authorization.models.entities.UserAccount;
import com.hydroworks.authorization.models.entities.User;

import java.util.List;

public interface UserAccountService {
    UserAccount save(User user, String token);

    List<UserAccount> findAll();

    void delete(String id);

    UserAccount findByToken(String token) throws ResourceNotFoundException;

    UserAccount findById(String id) throws ResourceNotFoundException;
}
