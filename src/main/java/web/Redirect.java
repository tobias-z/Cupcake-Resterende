package web;

import domain.User;
import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
                destination = "customer/customerpage";
                break;
            case "FAQ":
                break;
            case "adminpage":
                user = (User) session.getAttribute("user");
                if(!user.getRole().equals("admin")) {
                    request.setAttribute("nicetry", "Nice try :)");
                    return "errorpage";
                }
                destination = "admin/adminpage";
                break;
            case "Signup":
                break;
            default:
                request.setAttribute("message", "Denne side findes ikke");
                break;
        }
        return destination;
    }
}
