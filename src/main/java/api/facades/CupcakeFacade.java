package api.facades;

import api.factories.CupcakeFactory;
import domain.Cupcake;
import domain.Order;
import infrastucture.Database.DBCupcake;

import java.util.ArrayList;
import java.util.List;

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


    public Cupcake createCupcake(CupcakeFactory cupcakeFactory, int orderid) {
        return dbCupcake.createCupcake(cupcakeFactory, orderid);
    }

    public List<Cupcake> getCupcakesInOrder(Order order) {
        return order.getCupcakes();
    }

    public Cupcake getCupcakeById(int id) {
        return dbCupcake.findCupcake(id);
    }
}
