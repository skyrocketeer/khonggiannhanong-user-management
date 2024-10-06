package com.hydroworks.authorization.models.response;

import com.hydroworks.authorization.models.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RoleResponse {
    private Role data;
}
