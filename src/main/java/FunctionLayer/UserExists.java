package FunctionLayer;


public class UserExists extends Exception {
    public UserExists(String name) throws LoginSampleException {
        /*
        Called when creating a new user in Register, LogicFacade and UserHandler respectively
         */
        super("User already exists: " + name);
    }
}