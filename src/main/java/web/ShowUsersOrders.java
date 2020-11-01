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

        ArrayList<Cupcake> cupcakes = new ArrayList<>();

        for (Order o: orders) {
            cupcakes = api.getCupcakeFacade().getCupcakesInOrder(o);
        }

        request.setAttribute("cupcakenames", cupcakes);
        request.setAttribute("userorders", orders);


        return "adminpage";
    }
}
