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


    public Cupcake createCupcake(CupcakeFactory cupcakeFactory) {
        return dbCupcake.createCupcake(cupcakeFactory);
    }

    public List<Cupcake> getCupcakesInOrder(Order order) {
        List<Cupcake> cupcakesInOrder = new ArrayList<>();
        if(order == null || order.getCupcakeId().equals("")){
            return cupcakesInOrder;
        } else {
            String[] splitCupcakes = order.getCupcakeId().split(",");
            int cupcakeId;

            for(String s: splitCupcakes){
                cupcakeId = Integer.parseInt(s);
                Cupcake cupcake = dbCupcake.findCupcake(cupcakeId);
                cupcakesInOrder.add(cupcake);
            }
        }
        return cupcakesInOrder;
    }

    public Cupcake getCupcakeById(int id) {
        return dbCupcake.findCupcake(id);
    }
}
