package com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.api;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zuhelke.springfundamentals.pizzaorderservice.pizzaorder.service.PizzaOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PizzaOrderController.class)
public class PizzaOrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PizzaOrderService pizzaOrderService;

  @Test
  public void pizzaOrderWithId_getPizzaOrderById_foundPizzaOrderAndStatusOk() throws Exception {
    doReturn(new PizzaOrderDto("1", emptyList())).when(pizzaOrderService).findById("1");

    mockMvc.perform(get("/pizza-orders/1"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\n"
            + "  \"orderId\": \"1\",\n"
            + "  \"orderItems\": []\n"
            + "}"));
  }

  @Test
  public void validInput_createPizzaOrder_returnStatusIs201Created() throws Exception {
    mockMvc.perform(post("/pizza-orders")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n"
            + "  \"orderItems\": [\n"
            + "    {\n"
            + "      \"name\": \"Test Pizza\",\n"
            + "      \"quantity\": 1\n"
            + "    }\n"
            + "  ]\n"
            + "}"))
    .andExpect(status().isCreated());
  }
}