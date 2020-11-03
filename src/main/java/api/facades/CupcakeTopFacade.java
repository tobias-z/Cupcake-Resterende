package api.facades;

import domain.CupcakeTop;
import infrastucture.Database.DBCupcakeTop;

import java.util.List;

public class CupcakeTopFacade {
    private static CupcakeTopFacade instance;
    private final DBCupcakeTop dbCupcakeTop;

    public CupcakeTopFacade(DBCupcakeTop dbCupcakeTop) {
        this.dbCupcakeTop = dbCupcakeTop;
    }

    public static CupcakeTopFacade getInstance() {
        if (instance == null){
            instance = new CupcakeTopFacade(new DBCupcakeTop());
        }

        return instance;
    }

    public List<CupcakeTop> findCupcakeTops() {
        return dbCupcakeTop.findCupcakeTops();
    }


    public CupcakeTop findCupcakeById(int cupcaketopId) {
        return dbCupcakeTop.findCupcakeTopById(cupcaketopId);

    }

    public void addTopping(String type, double newAmount) {
        dbCupcakeTop.addTopping(type, newAmount);
    }
}
