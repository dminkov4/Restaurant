package mitko.util;

import mitko.dto.RestaurantTableDto;
import mitko.model.RestaurantTable;

public class RestaurantTableConverter {

    private RestaurantTableConverter() {
    }

    public static RestaurantTableDto toRestaurantTableDto(RestaurantTable restaurantTable) {
        RestaurantTableDto restaurantTableDto = new RestaurantTableDto();
        restaurantTableDto.setId(restaurantTable.getId());
        restaurantTableDto.setNumber(restaurantTable.getNumber());
        return restaurantTableDto;
    }

    public static RestaurantTable toRestaurantTableEntity(RestaurantTableDto restaurantTableDto) {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setId(restaurantTableDto.getId());
        restaurantTable.setNumber(restaurantTableDto.getNumber());
        return restaurantTable;
    }
}
