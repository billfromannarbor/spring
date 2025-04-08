package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CRUDConfiguration {

    @Bean
    Map<Long, String> CRUDMap() {
        return new HashMap<>();
    }
}
