package FunctionLayer;

import DBAccess.Handlers.UserHandler;
import DBAccess.Mappers.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

//---- USERS START ----

    /*
    Gets the name and password from Login.
    It tries to login with the given strings, using the UserHandler.
    Checks if the user is banned, if yes then it returns a string. If the user is not banned then it checks if the password was correct.
    If the password was correct it returns the user, if not correct it throws an InvalidPassword exception.
     */
    public User login(String email, String password) {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.findUser(email);
        if(user.isBanned()){
            user = null;
            return user;
        } else {
            if (user.isPasswordCorrect(password)) {
                return user;
            } else {
                user = null;
                return user;
            }
        }
    }

    /*
    Gets the name and password from Register.
    It tries returning a created new user in the database using the UserHandler.
    It is returned due to the user getting logged in after it is created.
    if the user did not get made, it will throw a UserExists exception.
     */
    public User createUser(String name, String email, String password) throws UserExists {
        UserHandler userHandler = new UserHandler();
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return userHandler.createUser(name, email, salt, secret);
    }
    /*
    public static Ordrer createOrder(String cupcakebottom, String cupcaketop) {
        Ordrer ordrer = OrderHandler.createOrder(cupcakebottom, cupcaketop);
        return ordrer;

    }
 */
}
