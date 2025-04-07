package com.example;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

/*
## 📦 1. File Upload Endpoint

**Description:**
Create an endpoint that accepts a file upload (multipart/form-data) and stores the file on disk.

**Skills Covered:**
- `@PostMapping`
- `MultipartFile`
- `application.properties` file storage config

 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class FileuploadTest {
    //MultipartFile multipartFile;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFileUpload() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, this is a test file.".getBytes()
        );

        mockMvc.perform(multipart("/fileupload")
                        .file(mockFile))
                .andExpect(status().isOk())
                .andExpect(content().string("File uploaded successfully: test.txt"));
        //MockMultipartFile;
        //var file = MockMultipartFile;//.createTempFile("Dog","Cat");
        //file.deleteOnExit();

        /*
        var file = new MockMultipartFile("TempFile", "Dog".getBytes());
        log.info(file.toString());
        //MockMultipartFile()
        mockMvc.perform(multipart("/fileupload")
                .file(file)
                        .param()
                .contentType(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(file.getName()));

         */
    }
}
