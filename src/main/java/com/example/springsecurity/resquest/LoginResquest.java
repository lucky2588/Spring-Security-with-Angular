package com.example.springsecurity.resquest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResquest {
    private String username;
    private String password;
}
