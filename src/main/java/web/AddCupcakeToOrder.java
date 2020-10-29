package web;

import api.factories.CupcakeFactory;
import exeptions.LoginSampleException;
import exeptions.ValidationError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        CupcakeTopFactory, CupCakeBottomFactory.

        cupcakeTopFactory.getPrice() + cupcakeBottomFactory.getPrice() = cupcake.setPrice();

        Send igennem CupcakeFactory: cupcakeTopId - cupcakeBottomId: CalculatedPrice

        api.getCupcakeFacade().AddCupcakeToOrder(cupcakeFactory);
         */

        CupcakeFactory cupcakeFactory = new CupcakeFactory();

        try {
            cupcakeFactory.setCupcakeBottomId(request.getParameter("cupcakebottom"));
            cupcakeFactory.setCupcakeTopId(request.getParameter("cupcaketop"));

        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        //String userid = request.getParameter("userid");
        //String antal = request.getParameter("antal");




        return "Bestillingsside";
    }
}
