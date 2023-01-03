package com.splot.app.service;

import com.splot.app.model.User;

public interface AuthenticationService {
    User register (String email, String username, String password);
}
