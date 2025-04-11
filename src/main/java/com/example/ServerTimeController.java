package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerTimeController {
    @GetMapping("/time")
    public String serverTime() {
        return java.time.LocalDateTime.now().toString();
    }
}
