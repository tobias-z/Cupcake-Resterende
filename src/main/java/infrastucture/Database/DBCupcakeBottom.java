package infrastucture.Database;

import domain.CupcakeBottom;
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

public class DBCupcakeBottom {
        private CupcakeBottom loadCupcakeBottom(ResultSet rs) throws SQLException {
            return new CupcakeBottom(
                    rs.getInt("cupcakeBottom.id"),
                    rs.getDouble("cupcakeBottom.pris"),
                    rs.getString("cupcakeBottom.type")
            );
        }
        public List<CupcakeBottom> findCupcakeBottoms() {
            try (Connection conn = getConnection()) {
                PreparedStatement s = conn.prepareStatement("SELECT * FROM cupcakeBottom;");
                ResultSet rs = s.executeQuery();
                ArrayList<CupcakeBottom> cupcakeBottoms = new ArrayList<>();
                while(rs.next()) {
                    cupcakeBottoms.add(loadCupcakeBottom(rs));
                }
                return cupcakeBottoms;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;

        }

    public CupcakeBottom findCupcakeById(int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cupcakeBottom  WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadCupcakeBottom(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

