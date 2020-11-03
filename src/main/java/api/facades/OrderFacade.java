package api.facades;

import api.factories.CupcakeFactory;
import api.factories.OrderFactory;
import infrastucture.Database.DBOrder;
import domain.Order;

import java.util.ArrayList;
import java.util.List;


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

    public void deleteOrder(int newUserId) {
        dbOrder.deleteOrder(newUserId);
    }

    public Order orderPurchased(Order order) {
        return dbOrder.orderPurchased(order);
    }

    public ArrayList<Order> getAllUserOrders(int newUserId) {
        return dbOrder.getAllUserOrders(newUserId);
    }

    public Order updateOrder(String cupcakes, double newPrice, int newUserId) {
        return dbOrder.updateOrder(cupcakes,newPrice, newUserId);
    }

    public void orderDelivered(int newOrderId) {
        dbOrder.orderDelivered(newOrderId);
    }

    public List<Order> getAllPaidOrders() {
        return dbOrder.getAllPaidOrders();
    }
}
