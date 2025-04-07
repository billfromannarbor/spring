package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileupload")
public class FileuploadController {

    @PostMapping
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        return ResponseEntity.ok().body("File uploaded successfully: "+multipartFile.getOriginalFilename());
    }
}
