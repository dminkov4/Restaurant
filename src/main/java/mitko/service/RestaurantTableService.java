package mitko.service;

import mitko.dto.RestaurantTableDto;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTableDto> getRestaurantTable();
    RestaurantTableDto create (RestaurantTableDto restaurantTableDto);
    RestaurantTableDto update (long id, RestaurantTableDto restaurantTableDto);
    void delete(long id);
}
