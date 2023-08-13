package com.example.springsecurity.controller;

import com.example.springsecurity.respone.AuthResponse;
import com.example.springsecurity.resquest.LoginResquest;
import com.example.springsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public AuthResponse login(@RequestBody LoginResquest loginResquest){
        AuthResponse authResponse = authService.login(loginResquest);
        return authResponse;
    };


}
