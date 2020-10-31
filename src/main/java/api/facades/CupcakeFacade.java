package api.facades;

import api.factories.CupcakeFactory;
import domain.Cupcake;
import domain.Order;
import infrastucture.Database.DBCupcake;
import infrastucture.Database.DBCupcakeTop;

import java.util.ArrayList;

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

    public ArrayList<Cupcake> getCupcakesInOrder(Order order) {
        ArrayList<Cupcake> cupcakesInOrder = new ArrayList<>();
        if(order == null){
            return null;
        } else {
            String[] splitCupcakes = order.getCupcakeId().split(",");
            int cupcakeId;

            //String[] splitCupcakes = {'6','7','8'};
            for(String s: splitCupcakes){
                cupcakeId = Integer.parseInt(s);
                Cupcake cupcake = dbCupcake.findCupcake(cupcakeId);
                cupcakesInOrder.add(cupcake);
            }
        }
        return cupcakesInOrder;
    }
}
