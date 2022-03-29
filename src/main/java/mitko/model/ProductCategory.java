package mitko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class ProductCategory {

    @Id
    private long id;

    @NotNull
    @Size(max = 100, message="Max 100 Characters")
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;

    public ProductCategory() {
    }

    public ProductCategory(long id, String name) {
        this.id = id;
        this.name = name;
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

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}
