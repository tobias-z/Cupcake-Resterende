package domain;

public class Cupcake {
    private final int id;
    private final int cupcakeBottomId;
    private final int cupcakeTopId;
    private final int pris;

    public Cupcake(int id, int cupcakeBottomId, int cupcakeTopId, int pris) {
        this.id = id;
        this.cupcakeBottomId = cupcakeBottomId;
        this.cupcakeTopId = cupcakeTopId;
        this.pris = pris;
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

    public int getPris() {
        return pris;
    }
}
