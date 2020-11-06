package api.facades;

import domain.Cupcake;
import domain.Order;
import infrastucture.Database.DBCupcake;
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

    public List<Cupcake> getCupcakesInOrder(Order order) {
        return order.getCupcakes();
    }
}
