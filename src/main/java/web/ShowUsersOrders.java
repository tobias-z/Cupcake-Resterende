package web;

import domain.Cupcake;
import domain.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowUsersOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String userid = request.getParameter("userid");
        int newUserId = 0;

        try {
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        //This is the users orders
        List<Order> orders =  api.getOrderFacade().getAllUserOrders(newUserId);

        if(orders == null || orders.isEmpty()) {
            request.setAttribute("noorder", "Denne bruger har ikke nogen ordre");
            return "adminpage";
        }

        List<OrderDTO> allCupcakes = new ArrayList<>();

        for (Order o: orders) {
            allCupcakes.add(new OrderDTO(o, api.getCupcakeFacade().getCupcakesInOrder(o)));
        }

        request.setAttribute("userorders", allCupcakes);
        return "adminpage";
    }

    public static class OrderDTO {
        private final Order order;
        private final List<Cupcake> cupcakes;

        public OrderDTO(Order order, List<Cupcake> cupcakes) {
            this.order = order;
            this.cupcakes = cupcakes;
        }

        public Order getOrder() {
            return order;
        }

        public List<Cupcake> getCupcakes() {
            return cupcakes;
        }
    }
}
