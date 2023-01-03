package com.splot.app.service.impl;

import com.splot.app.model.Role;
import com.splot.app.model.User;
import com.splot.app.service.AuthenticationService;
import com.splot.app.service.RoleService;
import com.splot.app.service.UserService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String nickname, String password) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(Role.RoleName.USER));
        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setRoles(roles);
        return userService.save(user);
    }
}
