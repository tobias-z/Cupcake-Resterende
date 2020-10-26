package web;



import api.factories.UserFactory;
import exeptions.LoginSampleException;
import domain.User;
import exeptions.UserExists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        UserFactory userFactory = new UserFactory();
        userFactory.setName(request.getParameter("username"));
        userFactory.setEmail(request.getParameter("email"));
        userFactory.setPassword(request.getParameter("password1"));
        userFactory.setPassword2(request.getParameter("password2"));
        if (userFactory.isValid(userFactory)) {
            if (userFactory.getPassword().equals(userFactory.getPassword2())) {
                User user = null;
                try {
                    user = api.getUserFacade().createUser(userFactory);
                } catch (UserExists userExists) {
                    throw new LoginSampleException("User already exists");
                }
                HttpSession session = request.getSession();

                session.setAttribute("email", userFactory.getEmail());
                session.setAttribute("username", userFactory.getName());
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());

                return user.getRole() + "/" + user.getRole() + "page";
            } else {
                throw new LoginSampleException("the two passwords did not match");
            }

        } else{
            request.setAttribute("error", "hold nu op adam, du helt væk");
            request.setAttribute("400","400");
            return "errorpage" ;
        }
    }
}

