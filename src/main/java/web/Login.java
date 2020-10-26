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

        UserFactory userFactory = new UserFactory();

        userFactory.setEmail(request.getParameter( "email" ));
        userFactory.setPassword(request.getParameter( "password" ));
        User user = api.getUserFacade().login(userFactory);

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", user.getEmail());  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        return user.getRole() + "page";
    }

}
