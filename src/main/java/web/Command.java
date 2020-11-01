package web;

import api.CupCake;
import api.facades.*;
import exeptions.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "createcupcake", new CreateCupcake() );
        commands.put("redirect", new Redirect());
        commands.put("addcupcaketoorder", new AddCupcakeToOrder());
        commands.put("buyorder", new BuyOrder());
        commands.put("logoutuser", new Logout());
        commands.put("adminselect", new AdminSelect());
    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    protected final static CupCake api;

    static {
        api = createCupCake();
    }

    private static CupCake createCupCake(){
        return new CupCake(UserFacade.getInstance(),
                OrderFacade.getInstance(),
                CupcakeTopFacade.getInstance(),
                CupcakeBottomFacade.getInstance(),
                CupcakeFacade.getInstance());
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
