package mitko.repository;

import mitko.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Product findByDescription (String description);
    Product findByPrice (double price);
}
