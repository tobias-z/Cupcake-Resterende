package domain;

public class Cupcake {
    private final int id;
    private final int cupcakeBottomId;
    private final int cupcakeTopId;
    private final String cupcakeBottomType;
    private final String cupcakeTopType;
    private final double pris;
    private final int antal;

    public Cupcake(int id, int cupcakeBottomId, int cupcakeTopId, String cupcakeBottomType, String cupcakeTopType, double pris, int antal) {
        this.id = id;
        this.cupcakeBottomId = cupcakeBottomId;
        this.cupcakeTopId = cupcakeTopId;
        this.cupcakeBottomType = cupcakeBottomType;
        this.cupcakeTopType = cupcakeTopType;
        this.pris = pris;
        this.antal = antal;
    }

    public int getId() {
        return id;
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
