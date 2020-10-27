package web;

import api.factories.UserFactory;
import exeptions.LoginSampleException;
import domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {

        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );

        User user = api.getUserFacade().login(email, password);

        if(user == null) {
            request.setAttribute("loginfail", "Username or password was incorrect");
            return "Login";
        }

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", user.getEmail());  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        return user.getRole() + "page";

    }
}

