package ch.mare.springtraining.pizzaorderservice.pizzaorder.service;

import static java.util.stream.Collectors.toList;

import ch.mare.springtraining.pizzaorderservice.common.exceptionhandling.ApplicationException;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.controller.CreatePizzaOrderDto;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.controller.PizzaOrderDto;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.controller.PizzaOrderItemDto;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess.PizzaInventoryService;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.dataaccess.PizzaOrderRepository;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.domain.PizzaOrder;
import ch.mare.springtraining.pizzaorderservice.pizzaorder.domain.PizzaOrderItem;
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

    private PizzaOrderDto mapToPizzaOrderDto(PizzaOrder pizzaOrder) {
        return new PizzaOrderDto(pizzaOrder.getId().toString(),
            pizzaOrder.getOrderItems().stream().map(orderItem -> new PizzaOrderItemDto(orderItem.getName(), orderItem.getQuantity())).collect(toList()));
    }

    private PizzaOrder mapPizzaOrderFromDto(CreatePizzaOrderDto createPizzaOrderDto) {
        return new PizzaOrder(createPizzaOrderDto.getOrderItems().stream().map(orderItem -> new PizzaOrderItem(orderItem.getName(), orderItem.getQuantity())).collect(toList()));
    }
}
