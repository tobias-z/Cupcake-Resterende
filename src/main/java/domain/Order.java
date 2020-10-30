package domain;

import java.time.LocalDateTime;

public class Order {
    private final int id;
    private final int userId;
    private final String cupcakeId;
    private final double price;
    private final LocalDateTime paydate;
    private final boolean paid;


    public Order(int id, int userId, String cupcakeId, double price, LocalDateTime paydate, boolean paid) {
        this.id = id;
        this.userId = userId;
        this.cupcakeId = cupcakeId;
        this.price = price;
        this.paydate = paydate;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getCupcakeId() {
        return cupcakeId;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getPaydate() {
        return paydate;
    }

    public boolean isPaid() {
        return paid;
    }
}
