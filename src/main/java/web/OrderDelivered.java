package web;

import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderDelivered extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String orderid = request.getParameter("orderid");
        int newOrderId = 0;

        try {
            newOrderId = Integer.parseInt(orderid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        api.getOrderFacade().orderDelivered(newOrderId);

        return "adminpage";
    }
}
