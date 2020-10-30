package domain;

import java.time.LocalDateTime;

public class Ordre {
    private final int id;
    private final int userId;
    private final String cupcakeId;
    private final double price;
    private final LocalDateTime paydate;


    public Ordre(int id, int userId, String cupcakeId, double price, LocalDateTime paydate) {
        this.id = id;
        this.userId = userId;
        this.cupcakeId = cupcakeId;
        this.price = price;
        this.paydate = paydate;
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
}
