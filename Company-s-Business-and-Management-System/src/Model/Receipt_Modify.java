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
public class Receipt_Modify {
       public static List<Receipt> findAll() {
        List<Receipt> receiptList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from receipt";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Receipt receipt = new Receipt(
                        resultSet.getInt("Receipt_ID"),
                        resultSet.getString("DateReceipt"),
                        resultSet.getString("DatePrintReceipt"),
                        resultSet.getInt("Order_ID"),
                        resultSet.getInt("Employee_ID")
                        
                );
               receiptList.add(receipt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return receiptList;
    }

    
    
    public static  Receipt getReceiptbyId(int ReceiptId) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Receipt receipt=new Receipt();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from receipt where Receipt_ID  = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ReceiptId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                receipt = new Receipt(
                        resultSet.getInt("Receipt_ID"),
                        resultSet.getString("DateReceipt"),
                        resultSet.getString("DatePrintReceipt"),
                        resultSet.getInt("Order_ID"),
                        resultSet.getInt("Employee_ID")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return receipt;
    }
    

    public static void insert(Receipt receipt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into receipt(DateReceipt,DatePrintReceipt,Order_ID,Employee_ID) values(?,?,?,?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1,receipt.getDateReceipt());
            statement.setString(2,receipt.getDatePrintReceipt());
            statement.setInt(3,receipt.getOrder_ID());
            statement.setInt(4,receipt.getEmployee_ID());
           
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD RECEIPT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    public static void update(Receipt receipt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update receipt set DateReceipt =?, DatePrintReceipt=?, Order_ID=?, Employee_ID=? where Receipt_ID  = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, receipt.getDateReceipt());
            statement.setString(2, receipt.getDatePrintReceipt());
            statement.setInt(3, receipt.getOrder_ID());
            statement.setInt(4, receipt.getOrder_ID());
            statement.setInt(5, receipt.getReceipt_ID());
           
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE RECEIPT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Receipt_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
