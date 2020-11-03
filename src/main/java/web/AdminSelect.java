package web;

import domain.Order;
import domain.User;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AdminSelect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String select = request.getParameter("adminselect");

        switch (select) {
            case "Vis alle ordre":
                List<Order> orders = api.getOrderFacade().getAllPaidOrders();
                request.setAttribute("allorders", orders);
                break;
            case "Vis brugere":
                ArrayList<User> users = api.getUserFacade().findAllUsers();
                request.setAttribute("showusers",users);
                break;

            case "Administrer bruger saldo":
                request.setAttribute("managemoney", select);
                break;
            default: break;

        }

        return "adminpage";
    }
}

