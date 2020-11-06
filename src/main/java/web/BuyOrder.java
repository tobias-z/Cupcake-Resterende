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

        //Double
        String userBank = request.getParameter("userbank");
        //double
        String orderPrice = request.getParameter("orderprice");
        String userid = request.getParameter("userid");
        double calculateOrder = 0;
        int newUserId = 0;
        double newOrderPrice = 0;

        if (orderPrice == null || orderPrice.isBlank()){
            return "Kurv";
        }

        try {
            newOrderPrice = Double.parseDouble(orderPrice);
            newUserId = Integer.parseInt(userid);
            calculateOrder = calculateOrder(userBank, orderPrice);
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        Order order = api.getOrderFacade().getOrderById(newUserId);

        if(calculateOrder < 0) {
            request.setAttribute("nomoney", "Du har ikke nok penge på din konto");
            request.setAttribute("orderprice", newOrderPrice);
            request.setAttribute("preorder", order);
            return "Kurv";
        } else {
            User user = api.getUserFacade().findUser(newUserId);
            api.getUserFacade().updateUserBank(newUserId, calculateOrder);
            Order orderPurchased = api.getOrderFacade().orderPurchased(order);

            session.setAttribute("bank", user.getBank());
            request.setAttribute("order", orderPurchased);
            request.setAttribute("user", user);
            request.setAttribute("orderprice", newOrderPrice);
            request.getSession().setAttribute("allcupcakes", new ArrayList<>());
        }

        return "Kvitering";
    }




    private double calculateOrder(String userBank, String orderPrice) throws ValidationError {
        double calculateOrder;
        double newUserBank;
        double newOrderPrice;

        try {
            newUserBank = Double.parseDouble(userBank);
            newOrderPrice = Double.parseDouble(orderPrice);
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }

        calculateOrder = newUserBank - newOrderPrice;

        return calculateOrder;
    }
}
