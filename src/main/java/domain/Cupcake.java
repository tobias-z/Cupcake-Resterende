package domain;

public class Cupcake {
    private final int id;
    private final int orderid;
    private final int cupcakeBottomId;
    private final int cupcakeTopId;
    private final String cupcakeBottomType;
    private final String cupcakeTopType;
    private final double pris;
    private final int antal;

    public Cupcake(int id, int orderid, int cupcakeBottomId, int cupcakeTopId, String cupcakeBottomType, String cupcakeTopType, double pris, int antal) {
        this.id = id;
        this.orderid = orderid;
        this.cupcakeBottomId = cupcakeBottomId;
        this.cupcakeTopId = cupcakeTopId;
        this.cupcakeBottomType = cupcakeBottomType;
        this.cupcakeTopType = cupcakeTopType;
        this.pris = pris;
        this.antal = antal;
    }

    @Override
    public String toString() {
        return  "Bottom: " + cupcakeBottomType +
                " - Topping: " + cupcakeTopType +
                "\nAntal: " + antal +
                " - Pris: " + pris;
    }

    public int getId() {
        return id;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public String getCupcakeBottomType() {
        return cupcakeBottomType;
    }

    public String getCupcakeTopType() {
        return cupcakeTopType;
    }

    public double getPris() {
        return pris;
    }

    public int getAntal() {
        return antal;
    }
}
