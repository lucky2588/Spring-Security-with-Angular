package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWordResouce {
    @GetMapping("hello-word")
    public String helloWord(){
        return "Hello Word";
    }
}
