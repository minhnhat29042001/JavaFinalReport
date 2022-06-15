/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anhng
 */
public class Order_Modify {
    public static List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from `order`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt("Order_ID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getInt("Item_ID"),
                        resultSet.getInt("Number"),
                        resultSet.getString("Order_DH")
                );
               orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return orderList;
    }

    public static List<Order> findByName(String Name) {
        List<Order> orderList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from `order` inner join `item` on order.Item_ID = `item`.Item_ID and Order_DH = '"+Name+"'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order ord = new Order(resultSet.getInt("Order_ID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getInt("Item_ID"),
                        resultSet.getInt("Number"),
                        resultSet.getString("Order_DH")
                        
                        
                );
                orderList.add(ord);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return orderList;}
    
    public static Order getOrderId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Order order = new Order();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from order where Order_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order(resultSet.getInt("Order_ID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getInt("Item_ID"),
                        resultSet.getInt("Number"),
                        resultSet.getString("Order_DH")
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return order;
    }
    
    public static Order getOrderDH() {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Order order = new Order();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from `order` where Order_ID IN (Select MAX(Order_ID) from `order`)";
            
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("Order_ID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getInt("Item_ID"),
                        resultSet.getInt("Number"),
                        resultSet.getString("Order_DH")
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return order;
    }
    
//    public static List<Order> findByName(String Name) {
//        List<Order> orderList = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
//            String sql = "select * from order where Order_ID like '%"+Name+"%'";
//            statement = connection.createStatement();
//            
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                Item itt = new Item(resultSet.getInt("Item_ID"),
//                        resultSet.getString("ItemName"),
//                        resultSet.getString("ItemUnit"),
//                        resultSet.getString("ItemType"),
//                        resultSet.getString("Supplier"),
//                        resultSet.getInt("Price"),
//                        resultSet.getString("PriceDate")
//                        
//                        
//                );
//                itemList.add(itt);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return itemList;}

    public static void insert(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into `order`(OrderDate,Customer_ID,Item_ID,Number,Order_DH) values(?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
           
            
             statement.setString(1, order.getOrderDate());
              statement.setInt(2, order.getCustomer_ID());
               statement.setInt(3, order.getItem_ID());
                statement.setInt(4, order.getNumber());
                statement.setString(5, order.getOrder_DH());
                
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD ORDER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    public static void update(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update order set OrderDate=?, Customer_ID =?,Item_ID=?,Number=? where Item_ID= ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, order.getOrderDate());
             statement.setInt(2, order.getCustomer_ID());
              statement.setInt(3, order.getItem_ID());
               statement.setInt(4, order.getNumber());
                statement.setInt(5, order.getOrder_ID());
                 
            statement.setString(6, order.getOrder_DH());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE ORDER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Order_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
