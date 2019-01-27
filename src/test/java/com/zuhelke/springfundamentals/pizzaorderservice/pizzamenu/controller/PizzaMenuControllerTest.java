package com.zuhelke.springfundamentals.pizzaorderservice.pizzamenu.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zuhelke.springfundamentals.pizzaorderservice.pizzamenu.service.PizzaMenuService;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PizzaMenuController.class)
public class PizzaMenuControllerTest {

  @MockBean
  private PizzaMenuService pizzaMenuService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void unknownId_getById_notFoundStatus() throws Exception {
    String unknownId = "unknownId";

    mockMvc.perform(get("/pizzas/" + unknownId))

        .andExpect(status().isNotFound())
        .andExpect(content().json("{\"title\":\"Not Found\",\"status\":404,\"detail\":\"The requested resource is not available\"}"));
  }

  @Test
  public void knownId_getById_okStatus() throws Exception {
    String knownId = "100";
    doReturn(Optional.of(new PizzaMenuItemDto(knownId, "Pizza Funghi", 13))).when(pizzaMenuService).findById(knownId);

    mockMvc.perform(get("/pizzas/" + knownId))

        .andExpect(status().isOk())
        .andExpect(content().json("{\"name\":\"Pizza Funghi\",\"price\":13.0}"));
  }
}