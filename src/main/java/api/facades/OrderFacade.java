package api.facades;

import api.factories.CupcakeFactory;
import api.factories.OrderFactory;
import infrastucture.Database.DBOrder;
import domain.Order;


public class OrderFacade {

    private static OrderFacade instance;
    private final DBOrder dbOrder;

    public OrderFacade(DBOrder dbOrder) {
        this.dbOrder = dbOrder;
    }

    public static OrderFacade getInstance() {
        if(instance == null) {
            instance = new OrderFacade(new DBOrder());
        }
        return instance;
    }



    public void AddCupcakeToOrder(OrderFactory orderFactory) {
        dbOrder.addCupcakeToOrder(orderFactory);
    }


    public Order getOrderById(int newUserId) {
        return dbOrder.getOrderById(newUserId);
    }

    public Order createOrder(int newUserId) {
        return dbOrder.createOrder(newUserId);
    }
}
