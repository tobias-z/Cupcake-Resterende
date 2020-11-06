package infrastucture.Database;

import api.factories.OrderFactory;
import domain.Cupcake;
import domain.Order;
import infrastucture.DBSetup.Connector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DBOrder {

    private final DBCupcake dbCupcake;

    public DBOrder(DBCupcake dbCupcake) {
        this.dbCupcake = dbCupcake;
    }

    public Order getOrderByUserId(int newUserId) {

        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE userid = ? AND paid = 0;");
            s.setInt(1, newUserId);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                int orderid = rs.getInt("orders.id");
                return loadOrder(rs, dbCupcake.findAllFromOrder(orderid));
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Order loadOrder(ResultSet rs, List<Cupcake> cupcakes) throws SQLException {
        return new Order(
                rs.getInt("orders.id"),
                rs.getInt("orders.userid"),
                cupcakes,
                rs.getTimestamp("orders.paydate").toLocalDateTime(),
                rs.getBoolean("orders.paid")
        );
    }

    /* public Order addCupcakeToOrder(OrderFactory orderFactory) {
        int id;
        dbCupcake.saveCupcakes(orderFactory.getCupcakeList());
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE orders SET price = ? WHERE userid = ? AND paid = 0;");
            ps.setDouble(1, orderFactory.getPrice());
            ps.setInt(2, orderFactory.getUserId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        Order order = getOrderById(orderFactory.getUserId());
        return findOrder(order.getId());
    }
     */

    Order findOrder(int id) {
        List<Cupcake> cupcakes = dbCupcake.findAllFromOrder(id);
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE id = ? AND paid = 0;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                return loadOrder(rs, cupcakes);
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

    public void deleteOrder(int newUserId) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "DELETE FROM orders WHERE userid = ? AND paid = 0;");
            ps2.setInt(1, newUserId);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Order orderPurchased(Order order) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE orders SET paid = 1 WHERE userid = ?;");
            ps.setInt(1, order.getUserId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return findPaidOrder(order.getId());
    }

    Order findPaidOrder(int id) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE id = ? AND paid = 1;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                int orderid = rs.getInt("orders.id");
                return loadOrder(rs, dbCupcake.findAllFromOrder(orderid));
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("findes ikke");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Order> getAllUserOrders(int newUserId) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM orders WHERE paid = 1 AND userid = ?;");
            s.setInt(1, newUserId);
            ResultSet rs = s.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderid = rs.getInt("orders.id");
                orders.add(loadOrder(rs, dbCupcake.findAllFromOrder(orderid)));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order updateOrder(String cupcakes, double newPrice, int newUserId) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE orders SET cupcakeid = ? WHERE userid = ? AND paid = 0;");
            ps2.setString(1, cupcakes);
            ps2.setInt(2, newUserId);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return getOrderByUserId(newUserId);
    }

    public void orderDelivered(int newOrderId) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "DELETE FROM orders WHERE id = ?;");
            ps2.setInt(1, newOrderId);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Order> getAllPaidOrders() {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM orders;");
            ResultSet rs = s.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderid = rs.getInt("orders.id");
                orders.add(loadOrder(rs, dbCupcake.findAllFromOrder(orderid)));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
