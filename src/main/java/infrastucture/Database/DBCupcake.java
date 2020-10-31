package infrastucture.Database;

import api.factories.CupcakeFactory;
import domain.Cupcake;
import exeptions.LoginSampleException;
import exeptions.UserExists;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.util.NoSuchElementException;

public class DBCupcake {


    public Cupcake createCupcake(CupcakeFactory cupcakeFactory) {
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO cupcake (cupcakeBottom, cupcakeTop, pris) " +
                                    "VALUE (?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cupcakeFactory.getCupcakeBottomId());
            ps.setInt(2, cupcakeFactory.getCupcakeTopId());
            ps.setDouble(3, cupcakeFactory.getPris());
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new UserExists("Cupcake: " + cupcakeFactory.getCupcakeBottomId() + cupcakeFactory.getCupcakeTopId());
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new UserExists("Cupcake: " + cupcakeFactory.getCupcakeBottomId() + cupcakeFactory.getCupcakeTopId());
            }
        } catch (ClassNotFoundException | LoginSampleException | SQLException | UserExists e) {
            throw new RuntimeException(e);
        }
        return findCupcake(id);
    }

    private Cupcake findCupcake(int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcake WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadCupcake(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("Cupcake findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Cupcake loadCupcake(ResultSet rs) throws SQLException {
        return new Cupcake(
                rs.getInt("cupcake.id"),
                rs.getInt("cupcake.cupcakeBottom"),
                rs.getInt("cupcake.cupcakeTop"),
                rs.getDouble("cupcake.pris")
        );
    }
}
