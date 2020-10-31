package api.factories;

import domain.Order;
import exeptions.ValidationError;

import java.time.LocalDateTime;

public class OrderFactory {
    private int userId;
    private String cupcakeId;
    private double price;


    public boolean isValid () {
        if (this.userId < 0) return false;
        if(this.cupcakeId == null || this.cupcakeId.isBlank()) return false;
        if(this.price < 0) return false;
        return true;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) throws ValidationError {
        if (userId < 0) throw new ValidationError("User id can't be under 0");
        this.userId = userId;
    }
    public void setUserId(String number) throws ValidationError {
        try {
            setUserId(Integer.parseInt(number));
        } catch(NumberFormatException e) {
            throw new ValidationError(e.getMessage());
        }

    }

    public String getCupcakeId() {
        return cupcakeId;
    }

    public void setCupcakeId(String cupcakeId, String oldCupcakes) {
        cupcakeId = oldCupcakes + cupcakeId + ",";
        this.cupcakeId = cupcakeId;
    }

    public void setCupcakeId(int cupcakeId, Order oldOrder) throws ValidationError {
        try {
            setCupcakeId(String.valueOf(cupcakeId), oldOrder.getCupcakeId());
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice(double price, double cupcakePrice) {
        setPrice(price+cupcakePrice);
    }
/*
    public void setPris(double topPris, double bottomPris, double oldPrice) throws ValidationError {
        double newPrice = topPris + bottomPris;
        double calculatePrice = newPrice + oldPrice;
        setPris(calculatePrice);
    */


}
