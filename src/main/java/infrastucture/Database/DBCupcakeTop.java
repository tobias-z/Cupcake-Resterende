package infrastucture.Database;

import domain.CupcakeTop;
import infrastucture.DBSetup.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static infrastucture.DBSetup.Connector.getConnection;

public class DBCupcakeTop {

    private CupcakeTop loadCupcakeTop(ResultSet rs) throws SQLException{
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
            while(rs.next()) {
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

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcakeTop  WHERE id = ?;");
            s.setInt(1, cupcaketopId);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadCupcakeTop(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
