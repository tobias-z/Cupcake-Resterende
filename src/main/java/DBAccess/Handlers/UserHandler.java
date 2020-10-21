package DBAccess.Handlers;

import DBAccess.DBSetup.Connector;
import DBAccess.Mappers.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserExists;

import java.sql.*;

public class UserHandler {
    /*
           Creates a user in the database with the objects given from LogicFacade createUser.
       */
    public User createUser(String name, String email, byte[] salt, byte[] secret) throws UserExists {
        UserMapper userMapper = new UserMapper();
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO users (name, email, salt, secret, role) " +
                                    "VALUE (?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setBytes(3, salt);
            ps.setBytes(4, secret);
            ps.setString( 5, "customer");
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new UserExists(name);
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new UserExists(name);
            }
        } catch (ClassNotFoundException | LoginSampleException | SQLException e) {
            throw new RuntimeException(e);
        }
        return userMapper.findUser(id);
    }
}
