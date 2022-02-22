package com.springfundamentals.pizzaorderservice.pizzaorder.service;

import static java.util.stream.Collectors.toList;

import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import com.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
import com.springfundamentals.pizzaorderservice.pizzaorder.infrastructure.PizzaInventoryClient;
import com.springfundamentals.pizzaorderservice.pizzaorder.infrastructure.PizzaOrderRepository;
import com.springfundamentals.pizzaorderservice.pizzaorder.api.CreatePizzaOrderDto;
import com.springfundamentals.pizzaorderservice.pizzaorder.api.PizzaOrderDto;
import com.springfundamentals.pizzaorderservice.pizzaorder.api.PizzaOrderItemDto;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

  private final PizzaOrderRepository pizzaOrderRepository;
  private final PizzaInventoryClient pizzaInventoryClient;

  public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository, PizzaInventoryClient pizzaInventoryClient) {
    this.pizzaOrderRepository = pizzaOrderRepository;
    this.pizzaInventoryClient = pizzaInventoryClient;
  }

  public PizzaOrderDto create(CreatePizzaOrderDto createPizzaOrderDto) {
    assertAllOrderedPizzasAreAvailable(createPizzaOrderDto);

    PizzaOrder newPizzaOrder = mapToPizzaOrder(createPizzaOrderDto);

    PizzaOrder createdPizzaOrder = pizzaOrderRepository.save(newPizzaOrder);

    return mapToPizzaOrderDto(createdPizzaOrder);
  }

  public List<PizzaOrderDto> findAll() {
    return pizzaOrderRepository.findAll().stream()
        .map(this::mapToPizzaOrderDto)
        .collect(toList());
  }

  public PizzaOrderDto findById(String id) {
    return pizzaOrderRepository.findById(UUID.fromString(id))
        .map(this::mapToPizzaOrderDto)
        .orElseThrow(IllegalArgumentException::new);
  }

  public List<PizzaOrderDto> findAllWithContainingPizza(String containingPizzaName) {
    return this.pizzaOrderRepository.findAll().stream()
        .filter(pizzaOrder -> pizzaOrder.getOrderItems().stream().anyMatch(item -> item.getName().toLowerCase().contains(containingPizzaName.toLowerCase())))
        .map(this::mapToPizzaOrderDto)
        .collect(toList());
  }

  private void assertAllOrderedPizzasAreAvailable(CreatePizzaOrderDto createPizzaOrderDto) {
    for (PizzaOrderItemDto orderItem : createPizzaOrderDto.getOrderItems()) {
      if (!pizzaInventoryClient.isAvailable(orderItem.getName())) {
        throw new IllegalStateException();
      }
    }
  }

  private PizzaOrderDto mapToPizzaOrderDto(PizzaOrder pizzaOrder) {
    List<PizzaOrderItemDto> orderItems = pizzaOrder.getOrderItems().stream()
        .map(orderItem -> new PizzaOrderItemDto(orderItem.getName(), orderItem.getQuantity()))
        .collect(toList());

    return new PizzaOrderDto(pizzaOrder.getId().toString(), orderItems);
  }

  private PizzaOrder mapToPizzaOrder(CreatePizzaOrderDto createPizzaOrderDto) {
    List<PizzaOrderItem> orderItems = createPizzaOrderDto.getOrderItems().stream()
        .map(orderItem -> new PizzaOrderItem(orderItem.getName(), orderItem.getQuantity()))
        .collect(toList());

    return new PizzaOrder(orderItems);
  }
}
