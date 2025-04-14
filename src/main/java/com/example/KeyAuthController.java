package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keyauth")
public class KeyAuthController {

    @GetMapping
    public String keyAuth() {
        return "You are Authorized";
    }
}
