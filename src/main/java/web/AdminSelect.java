package web;

import exeptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminSelect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String select = request.getParameter("adminselect");

        switch (select) {
            case "Vis brugere":
                request.setAttribute("showusers",select);
                break;

            case "Administrer bruger saldo":
                request.setAttribute("managemoney", select);
                break;
            default: break;
        }

        return "adminpage";
    }
}

