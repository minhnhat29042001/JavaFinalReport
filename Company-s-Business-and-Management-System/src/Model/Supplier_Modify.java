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
public class Supplier_Modify {
      public static List<Supplier> findAll() {
        List<Supplier> supplierList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from supplier";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getString("Supplier")
                      
                        
                );
                supplierList.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return  supplierList;
    }

    
    
    public static Supplier getSupplierName(String Name) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Supplier supplier=new Supplier();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from supplier where Supplier = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, Name);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                supplier = new Supplier(
                        resultSet.getString("Supplier")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return supplier;
    }
    

    public static void insert(String SuppName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into supplier(Supplier) values(?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1,SuppName);
            
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD SUPPLIER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    public static void update(String suppliernameupdate,String presupplier) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update supplier set Supplier =? where Supplier = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,suppliernameupdate);
            statement.setString(2,presupplier);
            
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE SUPPLIER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
     public static void delete(String suppliername) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from supplier where 		Supplier  = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1,suppliername);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE SUPPLIER SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Supplier_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
