package api.facades;

import api.factories.CupcakeFactory;
import infrastucture.Database.DBCupcake;

public class OrderFacade {

    private static OrderFacade instance;
    private final DBCupcake dbCupcake;

    public OrderFacade(DBCupcake dbCupcake) {
        this.dbCupcake = dbCupcake;
    }

    public static OrderFacade getInstance() {
        if(instance == null) {
            instance = new OrderFacade(new DBCupcake());
        }
        return instance;
    }

    public void AddCupcakeToOrder(CupcakeFactory cupcakeFactory) {
    }
}
