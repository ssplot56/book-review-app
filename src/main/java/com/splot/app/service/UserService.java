package com.splot.app.service;

import com.splot.app.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    User findByNickname(String nickname);
}
