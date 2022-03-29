package mitko.util;

import mitko.dto.OrderDto;
import mitko.model.Order;

public class OrderConverter {

    private OrderConverter() {
    }

    public static OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setLocalDate(order.getOrderTime());
        return orderDto;
    }

    public static Order toOrderEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderTime(orderDto.getLocalDate());
        return order;
    }
}
