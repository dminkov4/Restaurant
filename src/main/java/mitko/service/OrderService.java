package mitko.service;

import mitko.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrder();
    OrderDto create(OrderDto orderDto);
    OrderDto update(long id, OrderDto orderDto);
    void delete(long id);
}
