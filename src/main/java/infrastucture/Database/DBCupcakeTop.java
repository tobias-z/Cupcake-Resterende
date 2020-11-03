package infrastucture.Database;

import domain.CupcakeTop;
import exeptions.LoginSampleException;
import exeptions.UserExists;
import exeptions.ValidationError;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static infrastucture.DBSetup.Connector.getConnection;

public class DBCupcakeTop {

    private CupcakeTop loadCupcakeTop(ResultSet rs) throws SQLException {
        return new CupcakeTop(
                rs.getInt("cupcakeTop.id"),
                rs.getDouble("cupcakeTop.pris"),
                rs.getString("cupcakeTop.type")
        );
    }

    public List<CupcakeTop> findCupcakeTops() {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM cupcakeTop;");
            ResultSet rs = s.executeQuery();
            ArrayList<CupcakeTop> cupcakeTops = new ArrayList<>();
            while (rs.next()) {
                cupcakeTops.add(loadCupcakeTop(rs));
            }
            return cupcakeTops;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CupcakeTop findCupcakeTopById(int cupcaketopId) {

        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcakeTop  WHERE id = ?;");
            s.setInt(1, cupcaketopId);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                return loadCupcakeTop(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void addTopping(String type, double newAmount){
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO cupcakeTop (pris, type) " +
                                    "VALUE (?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, newAmount);
            ps.setString(2, type);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
