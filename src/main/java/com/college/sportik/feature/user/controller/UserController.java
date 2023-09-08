package com.college.sportik.feature.user.controller;

import com.college.sportik.feature.user.dto.UserDTOReceive;
import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    UserDTOResponse authUser(@RequestBody UserDTOReceive userDTOReceive) {
        return (UserDTOResponse) userService.authUser(userDTOReceive);
    }

    @PostMapping
    void registerUser(@RequestBody UserDTOResponse userDTOResponse) {
        userService.registerUser(userDTOResponse);
    }
}
