package web;


import domain.Order;
import domain.User;

import exeptions.ValidationError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class BuyOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        User user = (User) request.getSession().getAttribute("user");
        //Double

        //double
        String orderPrice = request.getParameter("orderprice");
        double calculateOrder = 0;
        double newOrderPrice = 0;

        if (orderPrice == null || orderPrice.isBlank()){
            return "Kurv";
        }

        try {
            newOrderPrice = Double.parseDouble(orderPrice);
            calculateOrder = calculateOrder(user.getBank(), orderPrice);
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        Order order = api.getOrderFacade().getOrderById(user.getId());

        if(calculateOrder < 0) {
            request.setAttribute("nomoney", "Du har ikke nok penge på din konto");
            request.setAttribute("orderprice", newOrderPrice);
            request.setAttribute("preorder", order);
            return "Kurv";
        } else {
            api.getUserFacade().updateUserBank(user.getId(), calculateOrder);
            Order orderPurchased = api.getOrderFacade().orderPurchased(order);

            session.setAttribute("bank", user.getBank());
            request.setAttribute("order", orderPurchased);
            request.setAttribute("orderprice", newOrderPrice);
            request.getSession().setAttribute("allcupcakes", new ArrayList<>());
        }

        return "Kvitering";
    }




    private double calculateOrder(double userBank, String orderPrice) throws ValidationError {
        double calculateOrder;
        double newOrderPrice;

        try {
            newOrderPrice = Double.parseDouble(orderPrice);
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }

        calculateOrder = userBank - newOrderPrice;

        return calculateOrder;
    }
}
