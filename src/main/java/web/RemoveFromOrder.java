package web;

import domain.Cupcake;
import domain.Order;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveFromOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        List<Cupcake> allcupcakes = (List<Cupcake>) session.getAttribute("allcupcakes");
        String userid = request.getParameter("userid");
        int cupcakeId = Integer.parseInt(request.getParameter("cupcakeid"));
        String cupcakePrice = request.getParameter("cupcakeprice");
        String orderprice = request.getParameter("orderprice");

        double newCupcakePrice = 0;
        int newUserId = 0;
        double newOrderPrice = 0;

        //Parse to numbers
        try {
            newOrderPrice = Double.parseDouble(orderprice);
            newCupcakePrice = Double.parseDouble(cupcakePrice);
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        allcupcakes.removeIf(cupcake -> cupcake.getId() == cupcakeId);

        Order order = api.getOrderFacade().getOrderById(newUserId);
        double newPrice = newOrderPrice - newCupcakePrice;

        List<String> stringids = new ArrayList<>();
        for (Cupcake cupcake : allcupcakes) {
            String s = "" + cupcake.getId();
            stringids.add(s);
        }
        String cupcakes = String.join(",", stringids);
        Order newOrder = api.getOrderFacade().updateOrder(cupcakes,newPrice, newUserId);

        List<Cupcake> allCupcakes;
        allCupcakes = api.getCupcakeFacade().getCupcakesInOrder(newOrder);

        if(allCupcakes == null){
            return "Kurv";
        }

        request.setAttribute("orderprice", newPrice);
        // session.setAttribute("allcupcakes", allCupcakes);
        request.setAttribute("order", newOrder);


        return "Kurv";
    }
}
