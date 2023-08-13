package com.example.springsecurity.respone;

import com.example.springsecurity.entity.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    @JsonProperty("auth")
    private UserDTO userDTO;
    private String token;
    @JsonProperty("isAuthenticated")
    private boolean isAuthenticated;
}