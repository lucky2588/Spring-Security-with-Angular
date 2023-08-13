package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.entity.mapper.UserMapper;
import com.example.springsecurity.respone.AuthResponse;
import com.example.springsecurity.respository.RoleRepository;
import com.example.springsecurity.respository.UserRepository;
import com.example.springsecurity.resquest.LoginResquest;
import com.example.springsecurity.security.CustomUserDetailService;
import com.example.springsecurity.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService customUserDetailsService;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private RoleRepository roleRepository;

    public AuthResponse login(LoginResquest resquestLogin) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(resquestLogin.getUsername(), resquestLogin.getPassword());
        // tien hanh xac thuc
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            //  Luu vao database Context Horder
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Lấy ra thông tin UserDetails()
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());
            String jwtToken = jwtUtils.generateToken(userDetails);
            User user = userRepository.findByUsername(authentication.getName()).orElse(null);
            return
                    new AuthResponse(
                            UserMapper.toUserDto(user),
                            jwtToken, true
                    );
        } catch (Exception ex) {
            throw new BadCredentialsException(ex.getMessage());
        }
    }


}
