package web;

import api.factories.CupcakeFactory;
import api.factories.OrderFactory;
import domain.Cupcake;
import domain.CupcakeBottom;
import domain.CupcakeTop;
import domain.Order;
import exeptions.LoginSampleException;
import exeptions.ValidationError;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddCupcakeToOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        /*

        √ Lav cupcake klasser.
        Lav cupcake factories
        Lav facades.
        Lav DB.




        Tag Imod variabler:
        cupcaketop, cupcakebottom, antal, userid

        CupcakeTopFactory, CupCakeBottomFactory, CupcakeFactory.

        cupcakeTopFactory.getPrice() + cupcakeBottomFactory.getPrice() = cupcake.setPrice();

        Send igennem CupcakeFactory: cupcakeTopId - cupcakeBottomId: CalculatedPrice

        api.getCupcakeFacade().AddCupcakeToOrder(cupcakeFactory);
         */


        /**
         * Vi skal generere vores cupcake via vores create cupcake som er en kombination af cupcaketopID og cupcakebottomID
         * Så skal vi bruge den Cupcake, og den cupcake bruger vi så til at blive puttet ind i en ordre.
         *
         * Lav CupcakeFacade:
         * Tag imod cupcaketop + cupcakebottom og antal. return Cupcake
         *
         *
         * CupcakeTop cupcakeTop = findCupcakeTop(cupcakeTopId)
         * cupcakeTop.getPrice
         * CupcakeBottom cupcakeBottom = findCupcakeBottom(cupcakeBottomId)
         * cupcakeBottom.getPrice
         *
         * Lav DBCupcake:
         * CreateCupcake(cupcakeFactory) return Cupcake
         *
         * Brug Cupcake til at lave en ny Ordre:
         * OrdreFacade(cupcake, userid)
         *
         *
         */


        //Initialice Factories
        CupcakeFactory cupcakeFactory = new CupcakeFactory();
        OrderFactory orderFactory = new OrderFactory();

        //Get the parameters from jsp sites
        String antal = request.getParameter("antal");
        String userId = request.getParameter("userid");
        String cupcakeBottomArray = request.getParameter("cupcakebottom");
        String cupcakeTopArray = request.getParameter("cupcaketop");

        //Call methods to generate the integers for us
        int CupcakebottomId = findCupcakeBottomId(cupcakeBottomArray);
        int CupcakeTopId = findCupcakeTopId(cupcakeTopArray);

        //Find the chosen CupcakeTopping and CupcakeBottom.
        CupcakeTop cupcakeTop = api.getCupcakeTopFacade().findCupcakeById(CupcakeTopId);
        CupcakeBottom cupcakeBottom = api.getCupcakeBottomFacade().findCupcakeById(CupcakebottomId);

        //Create the actual cupcake with the given top and bottom START
        try {
            cupcakeFactory.setPris(cupcakeBottom.getPris(), cupcakeTop.getPris(), antal);
            cupcakeFactory.setCupcakeBottomId(cupcakeBottom.getId());
            cupcakeFactory.setCupcakeTopId(cupcakeTop.getId());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        Cupcake cupcake;
        if(cupcakeFactory.isValid()){
            cupcake = api.getCupcakeFacade().createCupcake(cupcakeFactory);
        } else {
            request.setAttribute("error", "Your cupcake was not created");
            return "errorpage";
        }
        //Create the actual cupcake with the given top and bottom END


        try {
            //parse the users id to an integer.
            int newUserId = Integer.parseInt(userId);

            //Try to find an order with the users id
            Order order = null;
            if(newUserId < 0) {
                order = api.getOrderFacade().getOrderById(newUserId);
            }

            //If the order did not exist, create an order with that users id.
            if(order == null) {
                order = api.getOrderFacade().createOrder(newUserId);
            }

            //insert the new cupcakes id, and the old order.
            orderFactory.setCupcakeId(cupcake.getId(), order);

            //Insert the orders userid
            orderFactory.setUserId(order.getUserId());

            //Insert the old orders current price and the new cupcakes price.
            orderFactory.setPrice(order.getPrice(), cupcakeFactory.getPris());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        //See if the something went wrong with the OrderFactory. If nothing went wrong it will call AddCupcakeToOrder
        //Then it will regenerate the toppings and bottoms and set them as attributes
        if(orderFactory.isValid()) {
            api.getOrderFacade().AddCupcakeToOrder(orderFactory);
            List<CupcakeTop> toppings = api.getCupcakeTopFacade().findCupcakeTops();
            List<CupcakeBottom> bottoms = api.getCupcakeBottomFacade().findCupcakeBottoms();
            request.setAttribute("toppings", toppings);
            request.setAttribute("bottoms", bottoms);
        } else {
            request.setAttribute("error", "Your order could not be created");
        }


        return "Bestillingsside";
    }

    private int findCupcakeTopId(String cupcakeTopArray) {

        String[] newCupcakeTop = cupcakeTopArray.split(",", 0);

        ArrayList<String> toppings = new ArrayList<>();
        for(String a:newCupcakeTop){
            toppings.add(a);
        }
        String cupcakeTopStringId = toppings.get(0);

        int CupcaketopId = 0;
        try {
            CupcaketopId = Integer.parseInt(cupcakeTopStringId);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return CupcaketopId;
    }

    private int findCupcakeBottomId(String cupcakeBottomArray) {

        String[] newCupcakeBottom = cupcakeBottomArray.split(",", 0);

        ArrayList<String> bottoms = new ArrayList<>();
        for(String a:newCupcakeBottom){
            bottoms.add(a);
        }
        String cupcakeBottomStringId = bottoms.get(0);

        int CupcakebottomId = 0;
        try {
            CupcakebottomId = Integer.parseInt(cupcakeBottomStringId);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return CupcakebottomId;
    }
}
