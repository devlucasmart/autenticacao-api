package com.devlucasmartins.jwt.controller;

import com.devlucasmartins.jwt.model.User;
import com.devlucasmartins.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }
}
