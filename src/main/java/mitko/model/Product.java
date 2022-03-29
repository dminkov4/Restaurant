package mitko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Product {

    @Id
    private long id;

    @NotNull
    @Size(max = 100, message="Max 100 Characters")
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 500, message="Max 500 Characters")
    private String description;

    private double price;

    private boolean isDeleted = false;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public Product() {
    }

    public Product(long id, @NotNull @Size(max = 100, message = "Max 100 Characters") String name, @NotNull @NotBlank @Size(max = 500, message = "Max 500 Characters") String description, double price, boolean isDeleted, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isDeleted = isDeleted;
        this.productCategory = productCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
