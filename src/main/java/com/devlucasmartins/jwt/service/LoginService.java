package com.devlucasmartins.jwt.service;

import com.devlucasmartins.jwt.dto.Login;
import com.devlucasmartins.jwt.dto.Sessao;
import com.devlucasmartins.jwt.model.User;
import com.devlucasmartins.jwt.repository.UserRepository;
import com.devlucasmartins.jwt.security.JWTCreator;
import com.devlucasmartins.jwt.security.JWTObject;
import com.devlucasmartins.jwt.security.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PasswordEncoder encoder;
    private final SecurityConfig securityConfig;
    private final UserRepository repository;

    public Sessao logar(Login login) {
        User user = repository.findByUsername(login.getUsername());
        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
