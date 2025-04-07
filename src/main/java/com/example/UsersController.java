package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

record User(int i, String name ){}

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/list")
    List<User> findUsers() {
        return List.of(new User(1, "Bill"), new User(2, "Doug"));
    }
}
