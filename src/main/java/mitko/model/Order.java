package mitko.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private long id;

    private LocalDate orderTime;

    @Enumerated
    private OrderStatus orderStatus;

    @ManyToMany
    private Set<Product> products;

    @OneToOne
    private RestaurantTable restaurantTable;

    public Order() {
    }

    public Order(long id, LocalDate orderTime, OrderStatus orderStatus, Set<Product> products, RestaurantTable restaurantTable) {
        this.id = id;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.products = products;
        this.restaurantTable = restaurantTable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }
}
