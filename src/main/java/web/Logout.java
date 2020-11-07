package web;

import exeptions.NoSuchCupcakeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

          /*
        Called when user clicks the Logout button
        It is done so that the session instances that might have been set during a login are not there anymore.
         */

        String answer = request.getParameter("logoutans");
        String userid = request.getParameter("userid");
        int newUserId = 0;

        try {
            newUserId = Integer.parseInt(userid);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        if (answer.equals("No") && newUserId > 0) {
            try {
                api.getOrderFacade().deleteOrder(newUserId);
            } catch (NoSuchCupcakeException e) {
                e.printStackTrace();
            }
        }

        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }
}
