package com.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EchoTest {
    //Post a Json Payload in the Request Body to the endpoint and expect the same Json payload back in the response body
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectmapper = new ObjectMapper();

    //TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testEcho() throws Exception {
        String requestBodyToEcho = objectmapper.writeValueAsString("My Dog has fleas");
        mockMvc.perform(post("/echo").contentType(MediaType.APPLICATION_JSON).content(requestBodyToEcho))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(requestBodyToEcho));
    }


}
