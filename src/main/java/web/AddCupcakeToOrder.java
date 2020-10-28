package web;

import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCupcakeToOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        /*
        Tag Imod variabler:
        cupcaketop, cupcakebottom, antal, userid

        CupcakeTopFactory, CupCakeBottomFactory.

        cupcakeTopFactory.getPrice() + cupcakeBottomFactory.getPrice() = cupcake.setPrice();

        Send igennem CupcakeFactory: cupcakeTopId - cupcakeBottomId: CalculatedPrice

        api.getCupcakeFacade().AddCupcakeToOrder(cupcakeFactory);
         */




        return "Bestillingsside";
    }
}
