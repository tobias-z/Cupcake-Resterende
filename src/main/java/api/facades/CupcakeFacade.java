package api.facades;

import infrastucture.Database.DBCupcake;
import infrastucture.Database.DBUser;

public class CupcakeFacade {

    private static CupcakeFacade instance;
    private final DBCupcake dbCupcake;

    public CupcakeFacade(DBCupcake dbCupcake) {
        this.dbCupcake = dbCupcake;
    }

    public static CupcakeFacade getInstance() {
        if(instance == null) {
            instance = new CupcakeFacade(new DBCupcake());
        }
        return instance;
    }
}
