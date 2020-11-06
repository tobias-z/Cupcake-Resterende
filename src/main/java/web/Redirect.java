package web;

import domain.*;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                    request.setAttribute("nicetry", "Godt forsøgt :)");
                    return "errorpage";
                }
                destination = "customerpage";
                break;
            case "FAQ":
                break;
            case "adminpage":
                user = (User) session.getAttribute("user");

                if(user == null || !user.getRole().equals("admin")) {
                    request.setAttribute("nicetry", "Godt forsøgt :)");
                    return "errorpage";
                }
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
                    request.setAttribute("loginfail", "Du er ikke logget ind");
                    return "Login";
                } else {
                    Order order = api.getOrderFacade().getOrderById(user.getId());

                    if(order == null || order.getCupcakes().isEmpty()){
                        return "Kurv";
                    }

                    List<Cupcake> cupcakesInOrder = api.getCupcakeFacade().getCupcakesInOrder(order);

                    double currentprice = 0;
                    double oldprice = 0;
                    for(Cupcake c : cupcakesInOrder){
                        currentprice = c.getPris();
                        oldprice = oldprice + currentprice;
                    }

                    request.setAttribute("orderprice", oldprice);
                    request.getSession().setAttribute("allcupcakes", cupcakesInOrder);
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
