package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class CRUDConfiguration {

    @Bean
    Map<Long, String> CRUDMap() {
        return new ConcurrentHashMap<>();
    }
}
