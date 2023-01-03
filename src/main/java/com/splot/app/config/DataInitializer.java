package com.splot.app.config;

import com.splot.app.model.Role;
import com.splot.app.model.User;
import com.splot.app.service.RoleService;
import com.splot.app.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {

        //initialize main roles
        Role adminRole = roleService.findByName(Role.RoleName.ADMIN);
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setRoleName(Role.RoleName.ADMIN);
            roleService.save(adminRole);
        }
        Role userRole = roleService.findByName(Role.RoleName.USER);
        if (userRole == null) {
            userRole = new Role();
            userRole.setRoleName(Role.RoleName.USER);
            roleService.save(userRole);
        }

        //initialize basic admin & user
        if (userService.findByEmail("admin@mail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@mail.com");
            admin.setNickname("AdMiN");
            admin.setPassword("password");
            admin.setRoles(Set.of(adminRole));
            userService.save(admin);
        }
        if (userService.findByEmail("user@mail.com") == null) {
            User user = new User();
            user.setEmail("user@mail.com");
            user.setNickname("simpleUser");
            user.setPassword("password");
            user.setRoles(Set.of(userRole));
            userService.save(user);
        }
    }
}
