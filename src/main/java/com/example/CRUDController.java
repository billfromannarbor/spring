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
        if ( CRUDMap.containsKey(id) ) {
            return ResponseEntity.ok().body(CRUDMap.get(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteString(@PathVariable("id") Long id) {
        if (CRUDMap.containsKey(id)) {
            log.info("Delete Value: " + id);
            CRUDMap.remove(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateString(@PathVariable("id") Long id, @RequestBody String value) {
        if (CRUDMap.containsKey(id)) {
            log.info("Update Value: " + value);
            CRUDMap.put(id, value);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.notFound().build();
    }
}
