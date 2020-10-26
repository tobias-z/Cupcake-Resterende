package infrastucture.Database;


import api.factories.UserFactory;
import domain.User;
import exeptions.LoginSampleException;
import exeptions.UserExists;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.util.NoSuchElementException;

public class DBUser {

    /*
    Is used to call from methods, where you want to get a user object.
    */
    private User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("users.id"),
                rs.getString("users.name"),
                rs.getString("users.email"),
                rs.getTimestamp("users.createdAt").toLocalDateTime(),
                rs.getBytes("users.salt"),
                rs.getBytes("users.secret"),
                rs.getString("users.role"),
                rs.getBoolean("users.banned"),
                rs.getInt("users.ranked"));
    }



    /*
    String name is given from LogicFacade findUser(String name).
    It finds a specific user, by the users name.
     */
    public User findUser(String email) throws NoSuchElementException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM users WHERE email = ?;");
            s.setString(1, email);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadUser(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException(email);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    int id is given from LogicFacade findUser(int id)
    It finds a specific user, by the users id.
     */
    public User findUser(int id) throws NoSuchElementException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM users WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadUser(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No user with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
           Creates a user in the database with the objects given from LogicFacade createUser.
       */
    public User createUser(UserFactory userFactory, byte[] salt, byte[] secret) throws UserExists {
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO users (name, email, salt, secret, role) " +
                                    "VALUE (?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userFactory.getName());
            ps.setString(2, userFactory.getEmail());
            ps.setBytes(3, salt);
            ps.setBytes(4, secret);
            ps.setString( 5, "customer");
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new UserExists(userFactory.getName());
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new UserExists(userFactory.getName());
            }
        } catch (ClassNotFoundException | LoginSampleException | SQLException e) {
            throw new RuntimeException(e);
        }
        return findUser(id);
    }
}
