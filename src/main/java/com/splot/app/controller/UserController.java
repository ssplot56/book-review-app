package com.splot.app.controller;

import com.splot.app.dto.response.UserResponseDto;
import com.splot.app.model.User;
import com.splot.app.service.UserService;
import com.splot.app.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> responseDtoMapper) {
        this.userService = userService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return responseDtoMapper.mapToDto(userService.findById(id));
    }

    @GetMapping("/by-email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        return responseDtoMapper.mapToDto(userService.findByEmail(email));
    }

    @GetMapping("/by-nickname")
    public UserResponseDto findByNickname(@RequestParam String nickname) {
        return responseDtoMapper.mapToDto(userService.findByNickname(nickname));
    }
}
