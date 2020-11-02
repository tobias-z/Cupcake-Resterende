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


        int getrank;

        User user = api.getUserFacade().login(email, password);

        if(user == null) {
            request.setAttribute("loginfail", "Email adresse eller password var forkert");
            return "Login";
        }
        request.getServletContext().setAttribute("notloggedin", null );

        HttpSession session = request.getSession();
        getrank = user.isRanked();
        String ranked = Integer.toString(getrank);

        if(getrank == 10){
            session.setAttribute("rank10", ranked);
        } else if (getrank == 50) {
            session.setAttribute("rank50", ranked);
        } else if (getrank == 99) {
            session.setAttribute("rank99", ranked);
        } else {
            session.setAttribute("norank", ranked);
        }

        if(user.getRole().equals("admin")){
            session.setAttribute("adminrole", user.getRole());
        } else {
            session.setAttribute("customerrole", user.getRole());
        }


        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", user.getEmail());  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        return "customerpage";

    }
}

