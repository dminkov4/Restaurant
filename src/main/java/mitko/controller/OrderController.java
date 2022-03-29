package mitko.controller;

import mitko.dto.OrderDto;
import mitko.model.Order;
import mitko.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getOrder(){
        return orderService.getOrder();
    }

    @PostMapping
    public OrderDto createProduct(@RequestBody OrderDto orderDto) throws SQLException {
        return orderService.create(orderDto);
    }

    @RequestMapping("/{id}")
    public Order order (@PathVariable("id") int id) {
        return (Order) orderService.getOrder();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public OrderDto updateOrder(@PathVariable("id") long id, @RequestBody OrderDto orderDto) {
        return orderService.update(id, orderDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        orderService.delete(id);
    }
}
