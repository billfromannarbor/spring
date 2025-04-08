package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/crud")
public class CRUDController {

    @Autowired
    Map<Long,String> CRUDMap;

    @PostMapping()
    ResponseEntity<Long> createString(@RequestBody String value) {
        log.info("Create Value: " + value);
        CRUDMap.put((long) value.hashCode(), value);
        return ResponseEntity.ok().body((long) value.hashCode());

    }

    @GetMapping
    ResponseEntity<String> getString(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(CRUDMap.get(id));
    }
}
