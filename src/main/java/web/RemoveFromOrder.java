package web;

import domain.Cupcake;
import domain.Order;
import domain.User;
import exeptions.LoginSampleException;
import exeptions.NoSuchCupcakeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveFromOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        int cupcakeId = Integer.parseInt(request.getParameter("cupcakeid"));



        try {
            api.getOrderFacade().removeCupcakeFromOrder(user.getId(), cupcakeId);
        } catch (NoSuchCupcakeException e) {
            e.printStackTrace();
        }



        Order order = api.getOrderFacade().getOrderById(user.getId());

        request.setAttribute("order", order);


        return "Kurv";
    }
}
