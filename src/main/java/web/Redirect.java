package web;

import domain.*;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        String destination = request.getParameter("destination");
        User user;

        switch (destination) {

            case "index":
                request.setAttribute("message", "Alt er godt!!!");
                break;
            case "Login":
                break;
            case "customerpage":
                user = (User) session.getAttribute("user");
                if(user == null) {
                    request.setAttribute("nicetry", "Nice try :)");
                    return "errorpage";
                }
                destination = "customerpage";
                break;
            case "FAQ":
                break;
            case "adminpage":
                user = (User) session.getAttribute("user");
                /*
                if(!user.getRole().equals("admin")) {
                    request.setAttribute("nicetry", "Nice try :)");
                    return "errorpage";
                }

                 */
                break;
            case "Signup":
                break;

            case "findcupcakes":
                /*
                Lavet 2 lister
                1 med cupcake bottoms
                1 med cupcake tops
                Og de skal tages fra databasen med en select
                 */
                List<CupcakeTop> toppings = api.getCupcakeTopFacade().findCupcakeTops();
                List<CupcakeBottom> bottoms = api.getCupcakeBottomFacade().findCupcakeBottoms();
                request.setAttribute("toppings", toppings);
                request.setAttribute("bottoms", bottoms);
                return "Bestillingsside";
            case "findkurv":
                user = (User) session.getAttribute("user");
                if(user == null){
                    request.setAttribute("error", "You are currently not logged in");
                    return "errorpage";
                } else {
                    Order order = api.getOrderFacade().getOrderById(user.getId());

                    if(order == null){
                        return "Kurv";
                    }

                    ArrayList<Cupcake> cupcakesInOrder = api.getCupcakeFacade().getCupcakesInOrder(order);

                    request.setAttribute("orderprice", order.getPrice());
                    request.setAttribute("allcupcakes", cupcakesInOrder);
                    request.setAttribute("order", order);
                }
                return "Kurv";
            default:
                request.setAttribute("message", "Denne side findes ikke");
                break;
        }
        return destination;
    }
}
