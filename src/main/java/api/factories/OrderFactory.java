package api.factories;

import exeptions.ValidationError;

import java.time.LocalDateTime;

public class OrderFactory {
    private int userId;
    private String cupcakeId;
    private double price;

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

    public void setCupcakeId(String cupcakeId) {
        this.cupcakeId = cupcakeId;
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
