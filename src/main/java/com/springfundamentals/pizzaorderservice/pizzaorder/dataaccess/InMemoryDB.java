package com.springfundamentals.pizzaorderservice.pizzaorder.dataaccess;

import static java.util.Arrays.asList;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;

import java.util.ArrayList;
import java.util.List;

class InMemoryDB {

    static List<PizzaOrder> PIZZA_ORDERS = new ArrayList<>(asList(
        new PizzaOrder(
            asList(
                new PizzaOrderItem("Pizza Salami", 2),
                new PizzaOrderItem("Pizza Margherita", 1)
            )
        ),
        new PizzaOrder(
            asList(
                new PizzaOrderItem("Pizza Funghi", 3)
            )
        ),
        new PizzaOrder(
            asList(
                new PizzaOrderItem("Pizza Prosciutto", 3),
                new PizzaOrderItem("Pizza Calzone", 4)
            )
        ),
        new PizzaOrder(
            asList(
                new PizzaOrderItem("Pizza Salami", 1),
                new PizzaOrderItem("Pizza Capricciosa", 1)
            )
        )
    ));
}
