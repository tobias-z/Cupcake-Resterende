package infrastucture.Database;

import domain.CupcakeTop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
