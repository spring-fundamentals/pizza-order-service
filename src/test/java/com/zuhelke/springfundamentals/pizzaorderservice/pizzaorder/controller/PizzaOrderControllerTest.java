package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.controller;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.service.PizzaOrderService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PizzaOrderController.class)
public class PizzaOrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PizzaOrderService pizzaOrderService;

  private JacksonTester<List<PizzaOrderDto>> jacksonTester;

  @Before
  public void setUp() {
    ObjectMapper objectMapper = new ObjectMapper();
    JacksonTester.initFields(this, objectMapper);
  }

  @Test
  public void twoPizzaOrders_getAllOrders_twoOrders() throws Exception {
    doReturn(asList(new PizzaOrderDto("1", emptyList()), new PizzaOrderDto("2", emptyList()))).when(pizzaOrderService).findAll();

    mockMvc.perform(get("/pizza-orders"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\n"
            + "  \"orderId\": \"1\" ,\n"
            + "  \"orderItems\": []\n"
            + "},{\n"
            + "  \"orderId\": \"2\" ,\n"
            + "  \"orderItems\": []\n"
            + "}]"));

  }

  @Test
  public void twoPizzaOrders_getAllOrders_twoOrdersJacksonTester() throws Exception {
    doReturn(asList(new PizzaOrderDto("1", emptyList()), new PizzaOrderDto("2", emptyList()))).when(pizzaOrderService).findAll();

    mockMvc.perform(get("/pizza-orders"))
        .andExpect(status().isOk())
        .andExpect(content().json(jacksonTester.write(asList(new PizzaOrderDto("1", emptyList()), new PizzaOrderDto("2", emptyList()))).getJson()));
  }
}