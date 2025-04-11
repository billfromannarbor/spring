package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
class AppWithRestController {
    @GetMapping("/simple")
    String simple() {
        return "Hello World";
    }
}
/*
@SpringBootApplication
@RestController
public class DemoApplication {

@GetMapping("/helloworld")
public String hello() {
return"Hello World!";
}
}
 */