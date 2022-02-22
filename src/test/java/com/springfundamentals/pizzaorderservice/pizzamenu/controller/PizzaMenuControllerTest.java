package com.springfundamentals.pizzaorderservice.pizzamenu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PizzaMenuControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<PizzaMenuItemDto> json;

    @BeforeEach
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void unknownId_getById_notFoundStatus() throws Exception {
        String unknownId = "unknownId";

        mockMvc.perform(get("/pizzas/" + unknownId))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"title\":\"Not Found\",\"status\":404,\"detail\":\"The requested resource is not available\"}"));
    }

    @Test
    public void knownId_getById_okStatus() throws Exception {
        String knownId = "2";

        mockMvc.perform(get("/pizzas/{id}", knownId))

                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": \"2\",  \"name\": \"Pizza Salami\", \"price\": 18.0}", true));
    }

    @Test
    public void knownId_getById_correctObject() throws Exception {
        String knownId = "2";

        mockMvc.perform(get("/pizzas/{id}", knownId))

                .andExpect(status().isOk())
                .andExpect(content().json(json.write(new PizzaMenuItemDto(knownId, "Pizza Salami", 18)).getJson()));
    }
}
