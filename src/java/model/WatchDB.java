
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author ASUS
 */
public class WatchDB implements DatabaseInfo{
    
    public static Connection getConnect(){
        try{ 
            Class.forName(DRIVERNAME); 
	} catch(ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
	}
        try{            
            Connection con = DriverManager.getConnection(DBURL,USERDB,PASSDB);
            return con;
        }
        catch(SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
//    -----------------------------------------------------------------------------------------------------------------------
    public static boolean addWatch(Watch watch) {
        try (Connection con = getConnect()) {
            String sql = "INSERT INTO Watches (WatchName, Brand, Price, Description, ImageURL) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, watch.getWatchName());
            stmt.setString(2, watch.getBrand());
            stmt.setBigDecimal(3, watch.getPrice());
            stmt.setString(4, watch.getDescription());
            stmt.setString(5, watch.getImageURL());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -------------------------------------------------------------------------------------------------------------------
    public static boolean updateWatch(Watch watch) {
        try (Connection con = getConnect()) {
            String sql = "UPDATE Watches SET WatchName = ?, Brand = ?, Price = ?, Description = ?, ImageURL = ? WHERE WatchID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, watch.getWatchName());
            stmt.setString(2, watch.getBrand());
            stmt.setBigDecimal(3, watch.getPrice());
            stmt.setString(4, watch.getDescription());
            stmt.setString(5, watch.getImageURL());
            stmt.setInt(6, watch.getWatchID());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    ----------------------------------------------------------------------------------------------------------------
    public static ArrayList<Watch> listAll(){
          ArrayList<Watch> list= new ArrayList<Watch>();
          //Connection con = getConnect();
          try(Connection con=getConnect()) {
            PreparedStatement stmt=con.prepareStatement("Select WatchID, WatchName, Brand, Price, Description, ImageURL from Watches");
            ResultSet  rs=stmt.executeQuery();
            while(rs.next()){
                list.add(new Watch(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBigDecimal(4),rs.getString(5),rs.getString(6)));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
          return null;
        }
    //    -----------------------------------------------------------------------------------------------------------------
    public static boolean deleteWatch(int watchID) {
        try (Connection con = getConnect()) {
            String sql = "DELETE FROM Watches WHERE WatchID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, watchID);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    ----------------------------------------------------------------------------------------------------------------- 
    public static boolean addClient(Client client) {
        try (Connection con = getConnect()) {
            String sql = "INSERT INTO Clients (Username, Password, Email, Address) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getUsername());
            stmt.setString(2, client.getPassword());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getAddress());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
    public static boolean updateClient(Client client) {
        try (Connection con = getConnect()) {
            String sql = "UPDATE Clients SET Username = ?, Password = ?, Email = ?, Address = ? WHERE ClientID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getUsername());
            stmt.setString(2, client.getPassword());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getAddress());
            stmt.setInt(5, client.getClientID());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
    public static boolean deleteClient(int clientID) {
        try (Connection con = getConnect()) {
            String sql = "DELETE FROM Clients WHERE ClientID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, clientID);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
    public static Client getClientByUsernameAndPassword(String username, String password) {
        Client client = null;
        try (Connection con = getConnect()) {
            String sql = "SELECT ClientID, Username, Password, Email, Address FROM Clients WHERE Username = ? AND Password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Client> listAllClients() {
        ArrayList<Client> list = new ArrayList<>();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT ClientID, Username, Password, Email, Address FROM Clients");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Order> listOrder() {
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT OrderID, ClientID, WatchID, Quantity, OrderDate, Shipped FROM Orders");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getBoolean(6)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
     public static boolean addOrder(Order order) {
        try (Connection con = getConnect()) {
            String sql = "INSERT INTO Orders (ClientID, WatchID, Quantity, OrderDate, Shipped) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, order.getClientID());
            stmt.setInt(2, order.getWatchID());
            stmt.setInt(3, order.getQuantity());
            stmt.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setBoolean(5, order.isShipped());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
     public static boolean updateOrder(Order order) {
        try (Connection con = getConnect()) {
            String sql = "UPDATE Orders SET ClientID = ?, WatchID = ?, Quantity = ?, OrderDate = ?, Shipped = ? WHERE OrderID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, order.getClientID());
            stmt.setInt(2, order.getWatchID());
            stmt.setInt(3, order.getQuantity());
            stmt.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setBoolean(5, order.isShipped());
            stmt.setInt(6, order.getOrderID());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
      public static boolean deleteOrder(int orderID) {
        try (Connection con = getConnect()) {
            String sql = "DELETE FROM Orders WHERE OrderID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderID);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //    -----------------------------------------------------------------------------------------------------------------------
      public static ArrayList<Order> getOrdersByClientID(int clientID) {
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = getConnect()) {
            String sql = "SELECT OrderID, ClientID, WatchID, Quantity, OrderDate, Shipped FROM Orders WHERE ClientID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, clientID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getBoolean(6)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //    -----------------------------------------------------------------------------------------------------------------------  
      public static ArrayList<Order> getOrdersByShipmentStatus(boolean shipped) {
        ArrayList<Order> list = new ArrayList<>();
        try (Connection con = getConnect()) {
            String sql = "SELECT OrderID, ClientID, WatchID, Quantity, OrderDate, Shipped FROM Orders WHERE Shipped = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, shipped);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getBoolean(6)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WatchDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //    -----------------------------------------------------------------------------------------------------------------------  
    public static void main(String[] a) throws SQLException{
        ArrayList<Client> watches = WatchDB.listAllClients();
        
        
        
        for (Client item: watches) 
        {
            System.out.println(item);
        }
    }
}
