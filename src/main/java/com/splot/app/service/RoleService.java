package com.splot.app.service;

import com.splot.app.model.Role;

public interface RoleService {
    Role findByName(Role.RoleName roleName);
}
