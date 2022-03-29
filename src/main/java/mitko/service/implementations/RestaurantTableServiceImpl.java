package mitko.service.implementations;

import mitko.dto.RestaurantTableDto;
import mitko.model.RestaurantTable;
import mitko.repository.RestaurantTableRepository;
import mitko.service.RestaurantTableService;
import mitko.util.RestaurantTableConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableServiceImpl(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    public List<RestaurantTableDto> getRestaurantTable() {
        List<RestaurantTable> restaurantTables = restaurantTableRepository.findAll();
        List<RestaurantTableDto> restaurantTableDtos = new ArrayList<>();
        for (RestaurantTable restaurantTable : restaurantTables) {
            restaurantTableDtos.add(RestaurantTableConverter.toRestaurantTableDto(restaurantTable));
        }
        return restaurantTableDtos;
    }

    @Override
    public RestaurantTableDto create(RestaurantTableDto restaurantTableDto) {
        RestaurantTable restaurantTable = RestaurantTableConverter.toRestaurantTableEntity(restaurantTableDto);
        restaurantTableRepository.save(restaurantTable);
        return RestaurantTableConverter.toRestaurantTableDto(restaurantTable);
    }

    @Override
    public RestaurantTableDto update(long id, RestaurantTableDto restaurantTableDto) {
        RestaurantTable restaurantTable = RestaurantTableConverter.toRestaurantTableEntity(restaurantTableDto);
        restaurantTable.setId(id);
        return RestaurantTableConverter.toRestaurantTableDto(restaurantTableRepository.save(restaurantTable));
    }

    @Override
    public void delete(long id) {
        restaurantTableRepository.deleteById(id);
    }
}
