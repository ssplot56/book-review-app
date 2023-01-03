package com.splot.app.service;

import com.splot.app.model.Role;

public interface RoleService {
    Role save(Role role);
    Role findByName(Role.RoleName roleName);
}
