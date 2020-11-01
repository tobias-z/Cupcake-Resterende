package web;

import domain.Cupcake;
import domain.Order;
import exeptions.LoginSampleException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShowUsersOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String userid = request.getParameter("userid");
        int newUserId = 0;

        try {
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e){
            e.getMessage();
        }

        //This is the users orders
        ArrayList<Order> orders =  api.getOrderFacade().getAllUserOrders(newUserId);

        if(orders == null) {
            request.setAttribute("noorder", "Denne bruger har ikke nogen ordre");
        }

        ArrayList<String> cupcakeStrings = new ArrayList<>();
        int count = 1;
        for (Order o: orders) {
            ArrayList<Cupcake> cupcakes = api.getCupcakeFacade().getCupcakesInOrder(o);
            for (Cupcake c: cupcakes) {
                cupcakeStrings = new ArrayList<>();
                cupcakeStrings.add("Bottom: " + c.getCupcakeBottomType() + " - Topping: " +  c.getCupcakeTopType());
            }
        }

        request.setAttribute("cupcakenames", cupcakeStrings);
        request.setAttribute("userorders", orders);


        return "adminpage";
    }
}
