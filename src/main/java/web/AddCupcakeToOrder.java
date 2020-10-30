package web;

import api.factories.CupcakeFactory;
import domain.CupcakeBottom;
import domain.CupcakeTop;
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
        String cupcakeBottomStringId = bottoms.get(0);

        String[] newCupcakeTop = cupcakeTopArray.split(",", 0);

        ArrayList<String> toppings = new ArrayList<>();
        for(String a:newCupcakeTop){
            toppings.add(a);
        }
        String cupcakeTopStringId = toppings.get(0);

        int CupcaketopId = 0;
        int CupcakebottomId = 0;
        try {
            CupcaketopId = Integer.parseInt(cupcakeTopStringId);
            CupcakebottomId = Integer.parseInt(cupcakeBottomStringId);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        CupcakeTop cupcakeTop = api.getCupcakeTopFacade().findCupcakeById(CupcaketopId);
        CupcakeBottom cupcakeBottom = api.getCupcakeBottomFacade().findCupcakeById(CupcakebottomId);


        try {
            cupcakeFactory.setPris(cupcakeBottom.getPris(), cupcakeTop.getPris());
            cupcakeFactory.setCupcakeBottomId(cupcakeBottom.getId());
            cupcakeFactory.setCupcakeTopId(cupcakeTop.getId());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }


        api.getOrderFacade().AddCupcakeToOrder(cupcakeFactory);

        //String userid = request.getParameter("userid");
        //String antal = request.getParameter("antal");




        return "Bestillingsside";
    }
}
