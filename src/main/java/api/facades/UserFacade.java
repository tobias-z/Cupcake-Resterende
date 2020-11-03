package api.facades;


import api.factories.UserFactory;
import domain.User;
import exeptions.UserExists;
import exeptions.ValidationError;
import infrastucture.Database.DBUser;

import java.util.List;

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
    public User login(String email, String password){
        User user = dbUser.findUser(email);
        if(user == null){
            return null;
        }

        try {
            if (user.isPasswordCorrect(password)) {
                return user;
            } else {
                user = null;
                return user;
            }
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }
        return null;
    }


    /*
    Gets the name and password from Register.
    It tries returning a created new user in the database using the UserHandler.
    It is returned due to the user getting logged in after it is created.
    if the user did not get made, it will throw a UserExists exception.
     */
    public User createUser(UserFactory userFactory) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = new byte[0];
        try {
            secret = User.calculateSecret(salt, userFactory.getPassword());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }
        return dbUser.createUser(userFactory, salt, secret);
    }

    public User findUser(int newUserId) {
        return dbUser.findUser(newUserId);
    }

    public User findUser(String email) {
        return dbUser.findUser(email);
    }

    public void updateUserBank(int newUserId, double newBank) {
        dbUser.updateUserBank(newUserId, newBank);
    }

    public List<User> findAllUsers() {
        return dbUser.findAllUsers();
    }
}
