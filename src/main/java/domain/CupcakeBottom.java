package domain;

public class CupcakeBottom {
    private final int id;
    private final double pris;
    private final String type;

    public CupcakeBottom(int id, double pris, String type) {
        this.id = id;
        this.pris = pris;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public double getPris() {
        return pris;
    }

    public String getType() {
        return type;
    }
}
