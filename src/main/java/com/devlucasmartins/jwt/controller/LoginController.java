package com.devlucasmartins.jwt.controller;

import com.devlucasmartins.jwt.dto.Login;
import com.devlucasmartins.jwt.dto.Sessao;
import com.devlucasmartins.jwt.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service;

    @PostMapping("/login")
    public Sessao login(@RequestBody Login login) {
        return service.logar(login);
    }
}