package web;

import domain.Cupcake;
import domain.Order;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RemoveFromOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String allcupcakes = request.getParameter("allcupcakes");
        String userid = request.getParameter("userid");
        String cupcakeId = request.getParameter("cupcakeid");
        String cupcakePrice = request.getParameter("cupcakeprice");

        double newCupcakePrice = 0;
        int newUserId = 0;

        try {
            newCupcakePrice = Double.parseDouble(cupcakePrice);
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String replace = allcupcakes.replaceFirst(cupcakeId, "");
        String[] splitCupcakes = replace.split(",");
        String cupcakes = "";
        ArrayList<String> newCupcakes = new ArrayList<>();

        for(String s: splitCupcakes) {
            String oldCupcake = s + ",";
            if(!oldCupcake.startsWith(",")) {
                newCupcakes.add(oldCupcake);
            }
        }

        for(String s: newCupcakes) {
            cupcakes = cupcakes + s;
        }

        Order order = api.getOrderFacade().getOrderById(newUserId);
        double newPrice = order.getPrice() - newCupcakePrice;

        Order newOrder = api.getOrderFacade().updateOrder(cupcakes,newPrice, newUserId);

        ArrayList<Cupcake> allCupcakes;
        allCupcakes = api.getCupcakeFacade().getCupcakesInOrder(newOrder);

        if(allCupcakes == null){
            return "Kurv";
        }

        request.setAttribute("orderprice", newOrder.getPrice());
        request.setAttribute("allcupcakes", allCupcakes);
        request.setAttribute("order", newOrder);


        return "Kurv";
    }
}
