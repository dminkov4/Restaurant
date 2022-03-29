package mitko.controller;

import mitko.dto.RestaurantTableDto;
import mitko.model.RestaurantTable;
import mitko.service.RestaurantTableService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/restaurant-table")
public class RestaurantTableController {

    private RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @GetMapping
    public List<RestaurantTableDto> getRestaurantTable()  {
        return restaurantTableService.getRestaurantTable();
    }

    @PostMapping
    public RestaurantTableDto createRestaurantTable(@RequestBody RestaurantTableDto restaurantTableDto) throws SQLException {
        return restaurantTableService.create(restaurantTableDto);
    }

    @RequestMapping("/{id}")
    public RestaurantTable restaurantTable(@PathVariable("id") int id) {
        return (RestaurantTable) restaurantTableService.getRestaurantTable();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public RestaurantTableDto updateRestaurantTable(@PathVariable("id") long id, @RequestBody RestaurantTableDto restaurantTableDto) {
        return restaurantTableService.update(id, restaurantTableDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        restaurantTableService.delete(id);
    }
}
