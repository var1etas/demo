package com.example.factory.adapter.web.controller;

import com.example.factory.adapter.web.dto.Request;
import com.example.factory.service.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    RegistrationService registrationService;

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody Request user) {
        registrationService.registrateUser(user);
    }
}
