package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCupcake extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String cupcaketop = request.getParameter("Cupcaketop");
        String cupcakebottom = request.getParameter("Cupcakebottom");
/*
        Ordrer ordrer = LogicFacade.createOrder(cupcakebottom, cupcaketop);
        request.setAttribute("Ordrer", ordrer);
*/
        return "index";


    }
}
