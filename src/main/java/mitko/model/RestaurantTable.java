package mitko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RestaurantTable {

    @Id
    private long id;

    private int number;

    @OneToOne(mappedBy = "restaurantTable")
    private Order order;

    public RestaurantTable() {
    }

    public RestaurantTable(long id, int number, Order order) {
        this.id = id;
        this.number = number;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
