package com.college.sportik.feature.user.controller;

import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    void registerUser(@RequestBody UserDTOResponse userDTOResponse) {
        userService.registerUser(userDTOResponse);
    }
}
