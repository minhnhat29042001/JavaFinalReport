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
public class Item_Modify {
      public static List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from item";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item(resultSet.getInt("Item_ID"),
                        resultSet.getString("ItemName"),
                        resultSet.getString("ItemUnit"),
                        resultSet.getString("ItemType"),
                        resultSet.getString("Supplier"),
                        resultSet.getInt("Price"),
                        resultSet.getString("PriceDate")
                        
                );
               itemList.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return itemList;
    }

    
    
    public static Item getItemId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Item item=new Item();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from item where Item_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getInt("Item_ID"),
                        resultSet.getString("ItemName"),
                        resultSet.getString("ItemUnit"),
                        resultSet.getString("ItemType"),
                        resultSet.getString("Supplier"),
                        resultSet.getInt("Price"),
                        resultSet.getString("PriceDate")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return item;
    }
    
    public static List<Item> findByName(String Name) {
        List<Item> itemList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from item where ItemName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item itt = new Item(resultSet.getInt("Item_ID"),
                        resultSet.getString("ItemName"),
                        resultSet.getString("ItemUnit"),
                        resultSet.getString("ItemType"),
                        resultSet.getString("Supplier"),
                        resultSet.getInt("Price"),
                        resultSet.getString("PriceDate")
                        
                        
                );
                itemList.add(itt);
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
        return itemList;}

    public static void insert(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into item(ItemName,ItemUnit,ItemType,Supplier,	Price,PriceDate ) values(?, ?, ?,?,?,?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1,item.getItem_Name());
             statement.setString(2, item.getItem_Unit());
              statement.setString(3, item.getItem_Type());
               statement.setString(4, item.getItem_Suplier());
                statement.setInt(5,item.getPrice());
                statement.setString(6,item.getItem_Date());
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD ITEM SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static Item getItemName(String name) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Item item = new Item();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from item where ItemName = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getInt("Item_ID"),
                        
                        resultSet.getString("ItemName"),
                        resultSet.getString("ItemUnit"),
                        resultSet.getString("ItemType"),
                        resultSet.getString("Supplier"),
                        resultSet.getInt("Price"),
                        resultSet.getString("PriceDate")
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
        return item;
    }
    
    public static void update(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update item set ItemName=?, ItemUnit=?, ItemType =?,Supplier=?,Price=?,PriceDate =? where Item_ID= ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, item.getItem_Name());
             statement.setString(2, item.getItem_Unit());
              statement.setString(3, item.getItem_Type());
               statement.setString(4, item.getItem_Suplier());
                statement.setInt(5, item.getPrice());
                 statement.setString(6, item.getItem_Date());
                statement.setInt(7, item.getItem_ID());
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE ITEM SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
      public static void delete(int itemid) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from item  where 	Item_ID  = ? ";
            statement = connection.prepareCall(sql);
            statement.setInt(1,itemid);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE ITEM SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Item_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
