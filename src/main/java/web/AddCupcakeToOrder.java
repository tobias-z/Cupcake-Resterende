package web;

import api.factories.CupcakeFactory;
import exeptions.LoginSampleException;
import exeptions.ValidationError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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
         */

        CupcakeFactory cupcakeFactory = new CupcakeFactory();
        String antal = request.getParameter("antal");
        String userId = request.getParameter("userid");
        String cupcakeBottomArray = request.getParameter("cupcakebottom");
        String cupcakeTopArray = request.getParameter("cupcaketop");

        String[] newCupcakeBottom = cupcakeBottomArray.split(",", 0);

        ArrayList<String> bottoms = new ArrayList<>();
        for(String a:newCupcakeBottom){
            bottoms.add(a);
        }
        String cupcakeBottom = bottoms.get(0);

        String[] newCupcakeTop = cupcakeTopArray.split(",", 0);

        ArrayList<String> toppings = new ArrayList<>();
        for(String a:newCupcakeTop){
            toppings.add(a);
        }
        String cupcakeTop = bottoms.get(0);

        try {
            cupcakeFactory.setCupcakeBottomId(cupcakeBottom);
            cupcakeFactory.setCupcakeTopId(cupcakeTop);
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        api.getOrderFacade().AddCupcakeToOrder(cupcakeFactory);

        //String userid = request.getParameter("userid");
        //String antal = request.getParameter("antal");




        return "Bestillingsside";
    }
}
