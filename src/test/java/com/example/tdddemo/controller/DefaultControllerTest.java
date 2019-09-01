package com.example.tdddemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class DefaultControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void handel404() throws Exception {
        mockMvc.perform(get("/api/asd"))
                .andExpect(status().isNotFound());

        mockMvc.perform(post("/api/asd"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/asd"))
                .andExpect(status().isNotFound());
    }
}
