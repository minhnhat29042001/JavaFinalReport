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
public class ItemType_Modify {
       public static List<ItemType> findAll() {
        List<ItemType> itemtypeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from itemtype";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ItemType itemtype = new ItemType(
                        resultSet.getString("ItemType")
                        
                );
               itemtypeList.add(itemtype);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return itemtypeList;
    }

    
    
    public static ItemType getItemtypeName(String itemtypeName) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ItemType itemtype=new ItemType();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from itemtype where ItemType  = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, itemtypeName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                itemtype = new ItemType(
                        resultSet.getString("ItemType")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return itemtype;
    }
    

    public static void insert(String itemtypeinsert) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into itemtype(ItemType) values(?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1,itemtypeinsert);
           
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD ITEM SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<ItemType> findByName(String Name) {
        List<ItemType> itemtypeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from itemtype where ItemType like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ItemType itt = new ItemType(resultSet.getString("ItemType")
                        
                        
                );
                itemtypeList.add(itt);
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
        return itemtypeList;
    }
    
    public static void update(ItemType itemtype,String PreItemType) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update itemtype set ItemType =? where ItemType = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, itemtype.getItemTypeName());
            statement.setString(2, PreItemType);
           
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE ITEM TYPE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static void delete(String itemtypename) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from itemtype  where 	ItemType  = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1,itemtypename);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE ITEMTYPE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemType_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
