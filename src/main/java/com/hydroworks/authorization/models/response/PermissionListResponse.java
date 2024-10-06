package com.hydroworks.authorization.models.response;

import com.hydroworks.authorization.models.entities.Permission;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PermissionListResponse {
    private List<Permission> data;
}
