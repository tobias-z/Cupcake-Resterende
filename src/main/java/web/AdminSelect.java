package web;

import domain.Order;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminSelect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        String select = request.getParameter("adminselect");

        switch (select) {
            case "Vis alle ordre":
                List<Order> orders = api.getOrderFacade().getAllPaidOrders();
                request.setAttribute("allorders", orders);
                break;
            case "Vis brugere":
                List<User> users = api.getUserFacade().findAllUsers();
                request.setAttribute("showusers",users);
                break;

            case "Administrer bruger saldo":
                request.setAttribute("managemoney", select);
                break;
            case "Tilføj topping":
                request.setAttribute("addtopping", select);
                break;
            case "Tilføj bund":
                request.setAttribute("addbottom", select);
                break;
            default: break;

        }

        return "adminpage";
    }
}

