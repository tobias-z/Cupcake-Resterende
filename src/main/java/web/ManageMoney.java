package web;

import domain.User;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageMoney extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        String amount = request.getParameter("amount");
        String moneyans = request.getParameter("moneyans");
        double newAmount = 0;
        double calculatedBank;

        try {
            newAmount = Double.parseDouble(amount);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        User user = api.getUserFacade().findUser(email);

        if(moneyans.equals("add")){
            calculatedBank = newAmount + user.getBank();
        } else {
            calculatedBank = user.getBank() - newAmount;
        }

        api.getUserFacade().updateUserBank(user.getId(), calculatedBank);

        return "adminpage";
    }
}
