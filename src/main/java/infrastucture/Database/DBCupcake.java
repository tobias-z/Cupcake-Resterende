package infrastucture.Database;

import api.factories.CupcakeFactory;
import domain.Cupcake;
import exeptions.LoginSampleException;
import exeptions.UserExists;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DBCupcake {

    public Cupcake createCupcake(CupcakeFactory cupcakeFactory, int orderid) {
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO cupcake (cupcakeBottom, cupcakeTop, cupcakeBottomType, cupcakeTopType, pris, antal, orderid) " +
                                    "VALUE (?,?,?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cupcakeFactory.getCupcakeBottomId());
            ps.setInt(2, cupcakeFactory.getCupcakeTopId());
            ps.setString(3, cupcakeFactory.getCupcakeBottomType());
            ps.setString(4, cupcakeFactory.getCupcakeTopType());
            ps.setDouble(5, cupcakeFactory.getPris());
            ps.setInt(6, cupcakeFactory.getAntal());
            ps.setInt(7, orderid);
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

    public Cupcake findCupcake(int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcake WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadCupcake(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("Cupcake" + id + " findes ikke");
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
                rs.getString("cupcake.cupcakeBottomType"),
                rs.getString("cupcake.cupcakeTopType"),
                rs.getDouble("cupcake.pris"),
                rs.getInt("cupcake.antal"));

    }

    public List<Cupcake> findAllFromOrder(int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcake WHERE orderid = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            ArrayList<Cupcake> cupcakeList = new ArrayList<>();
            while(rs.next()) {
                cupcakeList.add(loadCupcake(rs));
            }
            return cupcakeList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCupcake(Cupcake cupcake) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "REPLACE INTO cupcake (id, orderid, cupcakeBottom, cupcakeTop, cupcakeBottomType, cupcakeTopType, pris, antal) " +
                                    "VALUE (?,?,?,?,?,?,?);");
            ps.setInt(1, cupcake.getId());
            ps.setInt(2, cupcake.getCupcakeBottomId());
            ps.setInt(3, cupcake.getCupcakeTopId());
            ps.setString(4, cupcake.getCupcakeBottomType());
            ps.setString(5, cupcake.getCupcakeTopType());
            ps.setDouble(6, cupcake.getPris());
            ps.setInt(7, cupcake.getAntal());
            ps.executeUpdate();
        } catch (ClassNotFoundException |  SQLException  e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCupcakes(List<Cupcake> cupcakeList) {
        for (Cupcake c : cupcakeList){
            saveCupcake(c);
        }
    }
}
