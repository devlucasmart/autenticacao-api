package com.devlucasmartins.jwt.service;

import com.devlucasmartins.jwt.model.User;
import com.devlucasmartins.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void createUser(User user) {
        var pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
