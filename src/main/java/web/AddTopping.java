package web;

import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTopping extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        double newAmount = 0;

        try {
            newAmount = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        api.getCupcakeTopFacade().addTopping(type,newAmount);

        return "adminpage";
    }
}
