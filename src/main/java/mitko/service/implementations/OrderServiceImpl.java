package mitko.service.implementations;

import mitko.dto.OrderDto;
import mitko.model.Order;
import mitko.repository.OrderRepository;
import mitko.service.OrderService;
import mitko.util.OrderConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> getOrder() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(OrderConverter.toOrderDto(order));
        }
        return orderDtos;
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        Order order = OrderConverter.toOrderEntity(orderDto);
        orderRepository.save(order);
        return OrderConverter.toOrderDto(order);
    }

    @Override
    public OrderDto update(long id, OrderDto orderDto) {
        Order order = OrderConverter.toOrderEntity(orderDto);
        order.setId(id);
        return OrderConverter.toOrderDto(orderRepository.save(order));
    }

    @Override
    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
