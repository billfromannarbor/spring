package com.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class CRUDTest {

    @Autowired
    MockMvc mockMvc;

    //Use MockMVC to Create a new record, then retrieve it, then Update it, then Delete it
    @Test
    public void fullCRUDTest() throws Exception {
        //Create
        String idAsString = mockMvc.perform(post("/crud")
                .content("Dog").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Long id = Long.parseLong(idAsString);

        //Retrieve
        mockMvc.perform(get("/crud?id=" + id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Dog"));

        //Update
        mockMvc.perform(put("/crud/"+id).content("Cat").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());

        //Retrieve
        mockMvc.perform(get("/crud?id=" + id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Cat"));

        //Delete
        mockMvc.perform(delete("/crud/" + id)).andExpect(status().isOk());


        //Retrieve the deleted one
        mockMvc.perform(get("/crud?id=" + id))
            .andExpect(status().is4xxClientError());

}

}

/*
# 🗃️ 4. In-Memory CRUD with a Map


**Description:**
Use a `Map<Long, Object>` to simulate a basic in-memory database with full CRUD operations.

**Skills Covered:**
- Basic service layer
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- Path variables and request bodies


 */