package com.quecode.springrecipes.hell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HellWorldController.class)
@ExtendWith(SpringExtension.class)
public class HellWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHellWorldController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hell World, from Spring Boot 2!"))
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }
}
