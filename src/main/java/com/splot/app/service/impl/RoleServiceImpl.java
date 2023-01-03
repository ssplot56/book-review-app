package com.splot.app.service.impl;

import com.splot.app.model.Role;
import com.splot.app.repository.RoleRepository;
import com.splot.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role findByName(Role.RoleName roleName) {
        return repository.findRoleByRoleName(roleName);
    }
}
