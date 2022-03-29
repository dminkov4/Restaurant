package mitko.repository;

import mitko.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    RestaurantTable findById (long id);
    RestaurantTable findByNumber(int number);
}
