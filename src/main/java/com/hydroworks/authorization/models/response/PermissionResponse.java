package com.hydroworks.authorization.models.response;

import com.hydroworks.authorization.models.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PermissionResponse {
    private Permission data;
}
