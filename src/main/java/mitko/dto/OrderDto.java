package mitko.dto;

import java.time.LocalDate;

public class OrderDto {

    private long id;
    private LocalDate localDate;

    public OrderDto() {
    }

    public OrderDto(long id, LocalDate localDate) {
        this.id = id;
        this.localDate = localDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
