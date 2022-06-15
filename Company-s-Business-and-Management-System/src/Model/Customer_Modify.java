/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Admin
 */
public class Customer_Modify {
     public static List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from customer";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("Customer_ID"),
                        resultSet.getString("CustomerName"),
                        resultSet.getString("CustomerAddress"),
                        resultSet.getString("CustomerPhone")
                        
                );
               customerList.add( customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return customerList;
    }

    
    
    public static Customer getCustomerbyId(int customerId) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer=new Customer();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from customer where Customer_ID  = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("Customer_ID"),
                        resultSet.getString("CustomerName"),
                        resultSet.getString("CustomerAddress"),
                        resultSet.getString("CustomerPhone")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return  customer;
    }
    
    public static Customer getCustomerName(String name) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer cus = new Customer();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from customer where CustomerPhone = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cus = new Customer(resultSet.getInt("Customer_ID"),
                        
                        resultSet.getString("CustomerName"),
                        resultSet.getString("CustomerAddress"),
                        resultSet.getString("CustomerPhone")
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cus;
    }
    
    public static List<Customer> findByPhone(String Name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from customer where CustomerPhone like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer sk = new Customer(resultSet.getInt("Customer_ID"),
                        resultSet.getString("CustomerName"),
                        resultSet.getString("CustomerAddress"),
                        resultSet.getString("CustomerPhone")
                        
                );
                customerList.add(sk);
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
        return customerList;
    }

    public static void insert(Customer customerinsert) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into customer values(?,?,?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1,customerinsert.getCustomerName());
            statement.setString(2,customerinsert.getCustomerAddress());
            statement.setString(3,customerinsert.getCustomerPhone());
              
           
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD CUSTOMER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    public static void update(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update customer set CustomerName =? ,CustomerAddress=?, CustomerPhone=? where Customer_ID = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, customer.getCustomerName());
             statement.setString(2, customer.getCustomerAddress());
              statement.setString(3, customer.getCustomerPhone());
               statement.setInt(4, customer.getCustomer_ID());
           
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE CUSTOMER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
      public static void delete(int customerID) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from customer where 		Customer_ID  = ? ";
            statement = connection.prepareCall(sql);
            statement.setInt(1,customerID);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE CUSTOMER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Customer_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
