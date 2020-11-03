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

        //Parse to numbers
        try {
            newCupcakePrice = Double.parseDouble(cupcakePrice);
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Create a string that replaces the chosen number with nothing
        String replace = allcupcakes.replaceFirst(cupcakeId, "");

        //Split the new string into a stringarray
        String[] splitCupcakes = replace.split(",");

        //create a new string that will be the one we put our cupcakes in
        String cupcakes = "";
        ArrayList<String> newCupcakes = new ArrayList<>();

        //For each element in the string array of our cupcake ids it will add that number to the string.
        //If a cupcake was removed it will still have the comma which means we have to check for if the s starts with a comma
        //If it does it will just skip it and not add it to the ArrayLis of Strings.
        for(String s: splitCupcakes) {
            String oldCupcake = s + ",";
            if(!oldCupcake.startsWith(",")) {
                newCupcakes.add(oldCupcake);
            }
        }

        //We now check for the elements in the ArrayList newCupcakes, and add them to the string we created earlier.
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
