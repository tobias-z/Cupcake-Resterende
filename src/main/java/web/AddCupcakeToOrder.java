package web;

import api.factories.CupcakeFactory;
import domain.*;
import exeptions.ValidationError;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddCupcakeToOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        //Initialice Factories
        CupcakeFactory cupcakeFactory = new CupcakeFactory();
        HttpSession session = request.getSession();


        User user = (User) session.getAttribute("user");


        if(user == null){
            request.setAttribute("loginfail", "Du skal være logget ind før du laver din ordre");
            return "Login";
        }

        String antal = request.getParameter("antal");
        String cupcakeBottomArray = request.getParameter("cupcakebottom");
        String cupcakeTopArray = request.getParameter("cupcaketop");
        int newBottomId = 0;
        int newTopId = 0;

        try {
            newBottomId = Integer.parseInt(cupcakeBottomArray);
            newTopId = Integer.parseInt(cupcakeTopArray);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Find the chosen CupcakeTopping and CupcakeBottom.
        CupcakeTop cupcakeTop = api.getCupcakeTopFacade().findCupcakeById(newTopId);
        CupcakeBottom cupcakeBottom = api.getCupcakeBottomFacade().findCupcakeById(newBottomId);

        //Create the actual cupcake with the given top and bottom START
        try {
            cupcakeFactory.setAntal(antal);
            cupcakeFactory.setCupcakeTopType(cupcakeTop.getType());
            cupcakeFactory.setCupcakeBottomType(cupcakeBottom.getType());
            cupcakeFactory.setPris(cupcakeBottom.getPris(), cupcakeTop.getPris(), antal);
            cupcakeFactory.setCupcakeBottomId(cupcakeBottom.getId());
            cupcakeFactory.setCupcakeTopId(cupcakeTop.getId());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        api.getOrderFacade().addCupcakeToOrder(user.getId(), cupcakeFactory);
        List<CupcakeTop> toppings = api.getCupcakeTopFacade().findCupcakeTops();
        List<CupcakeBottom> bottoms = api.getCupcakeBottomFacade().findCupcakeBottoms();
        request.setAttribute("toppings", toppings);
        request.setAttribute("bottoms", bottoms);
        return "Bestillingsside";


    }
}
