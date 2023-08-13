package com.example.springsecurity;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.respository.RoleRepository;
import com.example.springsecurity.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

@SpringBootTest
class SpringSecurityWithAngularApplicationTests {
    @Autowired
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private RoleRepository roleRepository;

    @Test
    void contextLoads() {
    }

@Test
    void save_role(){
        Role role = Role.builder()
                .name("USER")
                .build();
        Role role1 = Role.builder()
                .name("ADMIN")
                .build();
        roleRepository.save(role);
        roleRepository.save(role1);
    }

        @Test
    void save_users() {
        Role roleUser = roleRepository.findByName("USER").orElse(null);
        Role roleAdmin = roleRepository.findByName("ADMIN").orElse(null);
        User user1 = new User(1, "ducthang",  passwordEncoder.encode("111"),"111", List.of(roleAdmin));
        User user2 = new User(2, "nguyenthang", passwordEncoder.encode("111"),"111", List.of(roleUser));
        userRepository.save(user1);
        userRepository.save(user2);

    }

}
