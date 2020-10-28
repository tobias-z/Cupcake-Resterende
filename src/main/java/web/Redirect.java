package web;

import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        switch (destination) {

            case "index":
                request.setAttribute("message", "Alt er godt!!!");
                break;
            case "Login":
                break;
            case "customerpage":
                destination = "customer/customerpage";
                break;
            case "FAQ":
                break;
            case "adminpage":
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
