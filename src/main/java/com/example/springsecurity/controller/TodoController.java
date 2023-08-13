package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("todoApp")
public class TodoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static final List<Todo> TODO_LIST = List.of(new Todo(1,"Learn Java",""), new Todo(2,"Learn ReactJs", ""),
            new Todo(3,"Learn Angular", ""));
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/todos")
    public List<Todo> getAll(){
        return TODO_LIST;
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/user/{user_name}/todos")
    public Todo retriveTodosForSpecificUser(@PathVariable String user_name){
        return TODO_LIST.get(0);
    }

    @PostMapping("/user/{user_name}/todos")
    public void createTodoForSpecificUser(@PathVariable String user_name,@RequestBody Todo resquest){
        logger.info("username is : "+user_name);
        logger.info("resquest is : "+resquest.getName());
    }







}
