package mitko.dto;

import mitko.model.Product;
import java.util.Set;

public class ProductDto {

    private long id;

    private String name;

    private Set<Product> products;

    public ProductDto() {
    }

    public ProductDto(long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
