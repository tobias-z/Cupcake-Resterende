package web;



import exeptions.LoginSampleException;
import domain.User;
import exeptions.UserExists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = null;
            try {
                user = api.getUserFacade().createUser(username, email, password1);
            } catch (UserExists userExists) {
                throw new LoginSampleException("User already exists");
            }
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("username",username);
            session.setAttribute( "user", user);
            session.setAttribute( "role", user.getRole());

            return user.getRole() + "/" + user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}