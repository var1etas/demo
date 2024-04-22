package com.example.factory.service;

import com.example.factory.adapter.web.dto.Request;
import com.example.factory.domain.user.UserEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegistrationService {
    InMemoryUserDetailsManager manager;

    PasswordEncoder passwordEncoder;

    public void registrateUser(Request request) {
        UserEntity.Context context = new UserEntity.Context(
                request.login(),
                passwordEncoder.encode(request.password()),
                request.roles()
        );
        UserEntity newUser = UserEntity.create(context);
        manager.createUser(newUser);
    }
}
