package com.sparta.assginment04.controller;

import com.sparta.assginment04.dto.UserDto;
import com.sparta.assginment04.model.User;
import com.sparta.assginment04.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public User signupUser(@RequestBody UserDto.Signup signupDto) {
        return userService.signupUser(signupDto);
    }



}
