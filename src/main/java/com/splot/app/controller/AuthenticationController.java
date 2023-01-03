package com.splot.app.controller;

import com.splot.app.dto.request.UserRequestDto;
import com.splot.app.dto.response.UserResponseDto;
import com.splot.app.model.User;
import com.splot.app.service.AuthenticationService;
import com.splot.app.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;

    public AuthenticationController(AuthenticationService authService,
                                    ResponseDtoMapper<UserResponseDto, User> responseDtoMapper) {
        this.authService = authService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {
        User user = authService.register(dto.getEmail(), dto.getNickname(), dto.getPassword());
        return responseDtoMapper.mapToDto(user);
    }
}
