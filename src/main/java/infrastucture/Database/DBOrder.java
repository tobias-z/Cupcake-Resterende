package infrastucture.Database;

import api.factories.OrderFactory;
import domain.Order;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class DBOrder {
    public Order getOrderById(int newUserId) {

        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE userid = ? AND paid = 0;");
            s.setInt(1, newUserId);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadOrder(rs);
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Order loadOrder(ResultSet rs) throws SQLException {
        return new Order(
                rs.getInt("orders.id"),
                rs.getInt("orders.userid"),
                rs.getString("orders.cupcakeid"),
                rs.getInt("orders.price"),
                rs.getTimestamp("orders.paydate").toLocalDateTime(),
                rs.getBoolean("orders.paid")
                );
    }

    public Order addCupcakeToOrder(OrderFactory orderFactory) {
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE orders SET cupcakeid = ?, price = ? WHERE userid = ?;");
            ps.setString(1, orderFactory.getCupcakeId());
            ps.setDouble(2, orderFactory.getPrice());
            ps.setInt(3, orderFactory.getUserId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        Order order = getOrderById(orderFactory.getUserId());
        return findOrder(order.getId());
    }

    private Order findOrder(int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE id = ? AND paid = 0;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadOrder(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Order createOrder(int newUserId) {
        int id;
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO orders (userid, paydate) " +
                                    "VALUE (?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, newUserId);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new SQLException();
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new SQLException();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return findOrder(id);
    }
}
