package domain;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final int id;
    private final int userId;
    private final List<Cupcake> cupcakes;
    private final LocalDateTime paydate;
    private final boolean paid;
    private final boolean delivered;


    public Order(int id, int userId, List<Cupcake> cupcakes, LocalDateTime paydate, boolean paid, boolean delivered) {
        this.id = id;
        this.userId = userId;
        this.cupcakes = cupcakes;
        this.paydate = paydate;
        this.paid = paid;
        this.delivered = delivered;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public LocalDateTime getPaydate() {
        return paydate;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getPrice() {
        return cupcakes.stream().mapToDouble(Cupcake::getPris).sum();
    }

    public boolean isDelivered() {
        return delivered;
    }
}
