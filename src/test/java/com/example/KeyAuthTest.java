package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class KeyAuthTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void keyAuthTest() throws Exception {
        mockMvc.perform(get("/keyauth").header(FilterOnAuthHeader.headerName,FilterOnAuthHeader.expectedApiKey))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("You are Authorized"));
    }
}

/*
## 🔐 6. API Key Auth Filter

**Description:**
Implement a filter that requires a static API key in the `Authorization` header.

**Skills Covered:**
- Custom filters
- Spring Security basics
- Working with headers

---
 */
