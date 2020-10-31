package api.facades;

import api.factories.CupcakeFactory;
import domain.Cupcake;
import infrastucture.Database.DBCupcake;
import infrastucture.Database.DBCupcakeTop;

public class CupcakeFacade {

    private static CupcakeFacade instance;
    private final DBCupcake dbCupcake;

    public CupcakeFacade(DBCupcake dbCupcake) {
        this.dbCupcake = dbCupcake;
    }

    public static CupcakeFacade getInstance() {
        if (instance == null){
            instance = new CupcakeFacade(new DBCupcake());
        }

        return instance;
    }


    public Cupcake createCupcake(CupcakeFactory cupcakeFactory) {
        Cupcake cupcake = dbCupcake.createCupcake(cupcakeFactory);
        return cupcake;
    }
}
