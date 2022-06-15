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
public class Bonus_Modify {
    
    
    
    public static List<Bonus> findAll() {
        List<Bonus> bonusList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from bonus";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bonus bon = new Bonus(resultSet.getInt("Bonus_ID"),
                        
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Bonus"),
                        resultSet.getString("BonusDate")
                        
                        
                );
                bonusList.add(bon);
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
        return bonusList;
    }

    
    
    public static Bonus getBonusId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Bonus bon = new Bonus();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from bonus where Bonus_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bon = new Bonus(resultSet.getInt("Bonus_ID"),
                        
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Bonus"),
                        resultSet.getString("BonusDate")
                        
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
        return bon;
    }
    

    public static void insert(Bonus bon) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into bonus(Bonus_ID, BonusLevel, Bonus, BonusDate) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, bon.getBonus_ID());
            statement.setString(2, bon.getBonus_Level());
            statement.setInt(3, bon.getBonus_Money());
            statement.setString(4, bon.getBonus_Date());   
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD NEW BONUS SUCCESS","",2);
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
    }
    
    
    
    public static void update(Bonus bon) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update bonus set BonusLevel=?, Bonus=?, BonusDate=? where Bonus_ID = ?";
            statement = connection.prepareCall(sql);
            
            
            statement.setString(1, bon.getBonus_Level());
            statement.setInt(2, bon.getBonus_Money());
            statement.setString(3, bon.getBonus_Date());
            statement.setInt(4, bon.getBonus_ID());
   
                      
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE EMPLOYEE SUCCESS","",2);
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
    }
    
    
     public static Bonus getBonusName(String level) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Bonus bon1 = new Bonus();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from bonus where BonusLevel = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, level);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bon1 = new Bonus(resultSet.getInt("Bonus_ID"),
                        
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Bonus"),
                        resultSet.getString("BonusDate")
                        
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
        return bon1;
    }
     
     
      public static List<Bonus> findByName(String Name) {
        List<Bonus> bonusList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from bonus where BonusLevel like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bonus rmn = new Bonus(
                        resultSet.getInt("Bonus_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Bonus"), 
                        resultSet.getString("BonusDate")
                        
                );
                bonusList.add(rmn);
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
        return bonusList;
    }
      
      
       public static void delete(String bonusname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from bonus  where 		BonusLevel  = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1,bonusname);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Bonus_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE BONUS SUCCESS","",2);
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
}
}
