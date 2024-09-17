package com.example.factory.adapter.web.controller;

import com.example.factory.adapter.web.dto.Response;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping(value = "/info")
    public Response getDetails(@AuthenticationPrincipal UserDetails user) {
        return new Response(user.getUsername(), user.getAuthorities());
    }
}
