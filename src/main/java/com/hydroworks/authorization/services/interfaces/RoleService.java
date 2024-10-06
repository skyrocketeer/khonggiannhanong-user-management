package com.hydroworks.authorization.services.interfaces;

import com.hydroworks.authorization.exceptions.ResourceNotFoundException;
import com.hydroworks.authorization.models.dtos.CreateRoleDto;
import com.hydroworks.authorization.models.entities.Role;

import java.util.List;

public interface RoleService {
    Role save(CreateRoleDto role);

    List<Role> findAll();

    void delete(String id);

    Role findByName(String name) throws ResourceNotFoundException;

    Role findById(String id) throws ResourceNotFoundException;

    Role update(String id, CreateRoleDto createRoleDto) throws ResourceNotFoundException;
    Role update(Role role);
}
