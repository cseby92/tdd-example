package com.example.tdddemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class GreetingsControllerTest {

    public static final String NAME_ARG = "name";
    public static final String GENDER_ARG = "gender";
    @Autowired
    MockMvc mockMvc;
    public static final String NAME = "Sebastian";

    @Test
    public void maleGreetingTest200OkMale() throws Exception {
        String name = "Sebastian";
        String gender = "male";

        mockMvc.perform(
                get("/api/greeting")
                .param(NAME_ARG, NAME)
                .param(GENDER_ARG, gender)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString(
                        String.format("Hello Mr. %s. How are you?", name)
                ))
        );
    }

    @Test
    public void maleGreetingTest200OkFemale() throws Exception {
        String gender = "female";

        mockMvc.perform(
                get("/api/greeting")
                        .param(NAME_ARG, NAME)
                        .param(GENDER_ARG, gender)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString(
                        String.format("Hello Mrs. %s. How are you?", NAME)
                ))
        );
    }

    @Test
    public void genderParamNotPResetnTest() throws Exception {
        mockMvc.perform(
                get("/api/greeting")
                        .param(NAME_ARG, NAME)
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void nameParamNotPResetnTest() throws Exception {
        String gender = "female";
        mockMvc.perform(
                get("/api/greeting")
                        .param(GENDER_ARG, gender)
        ).andExpect(status().isBadRequest());
    }


}
