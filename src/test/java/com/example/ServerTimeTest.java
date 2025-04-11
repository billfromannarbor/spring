package com.example;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ServerTimeTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetServerTime() throws Exception {
        String returnValue = mockMvc.perform(get("/time")).andExpect(status().isOk()).andReturn().toString();

        log.info("Time Returned: " + returnValue);
    }
}
