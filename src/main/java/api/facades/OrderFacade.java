package api.facades;

import api.factories.CupcakeFactory;
import api.factories.OrderFactory;
import domain.Order;
import exeptions.NoSuchCupcakeException;
import infrastucture.Database.DBCupcake;
import infrastucture.Database.DBOrder;

import java.util.List;


public class OrderFacade {

    private static OrderFacade instance;
    private final DBOrder dbOrder;
    private final DBCupcake dbCupcakes;

    public OrderFacade(DBOrder dbOrder, DBCupcake dbCupcakes) {
        this.dbOrder = dbOrder;
        this.dbCupcakes = dbCupcakes;
    }

    public static OrderFacade getInstance() {
        if(instance == null) {
            DBCupcake cupcakes = new DBCupcake();
            instance = new OrderFacade(new DBOrder(cupcakes), cupcakes);
        }
        return instance;
    }


    public void addCupcakeToOrder(int userid, CupcakeFactory cupcake) {
        Order order = getOrderById(userid);
        if (order == null) {
            order = createOrder(userid);
        }
        dbCupcakes.createCupcake(cupcake, order.getId());
    }


    public Order getOrderById(int newUserId) {
        return dbOrder.getOrderByUserId(newUserId);
    }

    public Order createOrder(int newUserId) {
        return dbOrder.createOrder(newUserId);
    }

    public void deleteOrder(int newUserId) throws NoSuchCupcakeException {
        removeAllCupcakesFromOrder(newUserId);
        dbOrder.deleteOrder(newUserId);
    }

    public Order orderPurchased(Order order) {
        return dbOrder.orderPurchased(order);
    }

    public List<Order> getAllUserOrders(int newUserId) {
        return dbOrder.getAllUserOrders(newUserId);
    }

    public List<Order> getAllClosedUserOrders(int newUserId) {
        return dbOrder.getAllClosedUserOrders(newUserId);
    }

    public void orderDelivered(int newOrderId) {
        dbOrder.orderDelivered(newOrderId);
    }

    public List<Order> getAllPaidOrders() {
        return dbOrder.getAllPaidOrders();
    }

    public void removeCupcakeFromOrder(int newUserId, int cupcakeId) throws NoSuchCupcakeException {
        Order order = getOrderById(newUserId);
        if (order == null){
            throw new NoSuchCupcakeException();
        } else {
            dbCupcakes.deleteCupcake(cupcakeId, order.getId());
        }

    }

    public void removeAllCupcakesFromOrder(int newUserId) throws NoSuchCupcakeException {
        Order order = getOrderById(newUserId);
        if(order == null){
            throw new NoSuchCupcakeException();
        } else {
            dbCupcakes.deleteAllCupcakesInOrder(order.getId());
        }
    }
}
