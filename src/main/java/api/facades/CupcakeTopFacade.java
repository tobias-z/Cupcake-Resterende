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
        List<CupcakeTop> cupcakeTop= dbCupcakeTop.findCupcakeTops();
        return cupcakeTop;
    }


    public CupcakeTop findCupcakeById(int cupcaketopId) {
        CupcakeTop cupcakeTop = dbCupcakeTop.findCupcakeTopById(cupcaketopId);
        return cupcakeTop;

    }
}
