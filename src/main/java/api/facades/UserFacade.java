package api.facades;


import api.factories.UserFactory;
import domain.User;
import exeptions.UserExists;
import infrastucture.Database.DBUser;

public class UserFacade {

    private static UserFacade instance;
    private final DBUser dbUser;

    public UserFacade(DBUser dbUser) {
        this.dbUser = dbUser;
    }

    public static UserFacade getInstance() {
        if(instance == null) {
            instance = new UserFacade(new DBUser());
        }
        return instance;
    }

    /*
        Gets the name and password from Login.
        It tries to login with the given strings, using the UserHandler.
        Checks if the user is banned, if yes then it returns a string. If the user is not banned then it checks if the password was correct.
        If the password was correct it returns the user, if not correct it throws an InvalidPassword exception.
         */
    public User login(String email, String password) {
        User user = dbUser.findUser(email);
        if (user.isPasswordCorrect(password)) {
            return user;
        } else {
            user = null;
            return user;
        }
    }


    /*
    Gets the name and password from Register.
    It tries returning a created new user in the database using the UserHandler.
    It is returned due to the user getting logged in after it is created.
    if the user did not get made, it will throw a UserExists exception.
     */
    public User createUser(UserFactory userFactory) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, userFactory.getPassword());
        return dbUser.createUser(userFactory, salt, secret);
    }
}
