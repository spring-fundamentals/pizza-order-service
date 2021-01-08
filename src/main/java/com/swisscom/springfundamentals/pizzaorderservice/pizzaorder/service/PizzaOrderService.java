package com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.service;

import static java.util.stream.Collectors.toList;

import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.controller.CreatePizzaOrderDto;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.controller.PizzaOrderDto;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.controller.PizzaOrderItemDto;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.dataaccess.PizzaInventoryService;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.dataaccess.PizzaOrderRepository;
import com.swisscom.springfundamentals.pizzaorderservice.common.exceptionhandling.ResourceNotFoundException;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
import com.swisscom.springfundamentals.pizzaorderservice.common.exceptionhandling.ApplicationException;
import com.swisscom.springfundamentals.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

  private final PizzaInventoryService pizzaInventoryService;
  private final PizzaOrderRepository pizzaOrderRepository;

  public PizzaOrderService(PizzaInventoryService pizzaInventoryService,
      PizzaOrderRepository pizzaOrderRepository) {
    this.pizzaInventoryService = pizzaInventoryService;
    this.pizzaOrderRepository = pizzaOrderRepository;
  }

  public PizzaOrderDto create(CreatePizzaOrderDto createPizzaOrderDto) {
    for (PizzaOrderItemDto orderItem : createPizzaOrderDto.getOrderItems()) {
      boolean isPizzaAvailable = pizzaInventoryService.isPizzaAvailable(orderItem.getName());
      if (!isPizzaAvailable) {
        throw new ApplicationException(orderItem.getName() + " is no longer available. Please choose another dish and place your order again.");
      }
    }

    PizzaOrder newPizzaOrder = pizzaOrderRepository.save(mapPizzaOrderFromDto(createPizzaOrderDto));

    return mapToPizzaOrderDto(newPizzaOrder);
  }

  public List<PizzaOrderDto> findAll() {
    return pizzaOrderRepository.findAll().stream()
        .map(this::mapToPizzaOrderDto)
        .collect(toList());
  }

  public PizzaOrderDto findById(String id) {
    return pizzaOrderRepository.findById(id)
        .map(this::mapToPizzaOrderDto)
        .orElseThrow(ResourceNotFoundException::new);
  }

  public List<PizzaOrderDto> findAllWithContainingPizza(String containingPizzaName) {
    return this.pizzaOrderRepository.findAll().stream()
        .filter(pizzaOrder -> pizzaOrder.getOrderItems().stream()
            .anyMatch(item -> item.getName().toLowerCase().contains(containingPizzaName.toLowerCase()))
        )
        .map(this::mapToPizzaOrderDto)
        .collect(toList());
  }

  private PizzaOrderDto mapToPizzaOrderDto(PizzaOrder pizzaOrder) {
    return new PizzaOrderDto(pizzaOrder.getId().toString(),
        pizzaOrder.getOrderItems().stream().map(orderItem -> new PizzaOrderItemDto(orderItem.getName(), orderItem.getQuantity())).collect(toList()));
  }

  private PizzaOrder mapPizzaOrderFromDto(CreatePizzaOrderDto createPizzaOrderDto) {
    return new PizzaOrder(
        createPizzaOrderDto.getOrderItems().stream().map(orderItem -> new PizzaOrderItem(orderItem.getName(), orderItem.getQuantity())).collect(toList()));
  }
}
