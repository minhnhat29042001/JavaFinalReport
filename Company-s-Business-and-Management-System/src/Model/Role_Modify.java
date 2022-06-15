/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static com.mysql.cj.MysqlType.NULL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Role_Modify {
     public static List<Role> findAll() {
        List<Role> roleList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from role";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role rol = new Role(
                        resultSet.getString("RoleName"),
                        resultSet.getInt("Allowance"),
                        resultSet.getString("AllowanceTime")
                    );
                roleList.add(rol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return roleList;
    }
     
     //update
       public static void update(Role role,String PreRole) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update role set RoleName =?, Allowance=?, AllowanceTime=? where RoleName = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, role.getRolename());
            statement.setInt(2, role.getAllowance());
            statement.setString(3,role.getAllowanceTime());
            statement.setString(4,PreRole);
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE ROLE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        
       // getRolebyid
        public static Role getRolebyName(String rolename) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Role role =new Role();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from role where RoleName  = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, rolename);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role(
                        resultSet.getString("RoleName"),
                        resultSet.getInt("Allowance"),
                        resultSet.getString("AllowanceTime")
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return role;
    }
        
        
         //insert
       public static void insert(String rolename,int Allowance,String AllowanceTime) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into role set  RoleName =?, Allowance=?, AllowanceTime=?  ";
            statement = connection.prepareCall(sql);
            statement.setString(1, rolename);
            statement.setInt(2, Allowance);
            statement.setString(3,AllowanceTime);
        
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"INSERT ROLE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        public static void delete(String rolename) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "DELETE FROM `role` WHERE RoleName =?  ";
            statement = connection.prepareCall(sql);
            statement.setString(1, rolename);
            
        
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE ROLE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
      
        
         public static List<Role> findByName(String Name) {
        List<Role> roleList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from role where RoleName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role rmn = new Role(
                        resultSet.getString("RoleName"),
                        resultSet.getInt("Allowance"),
                        
                        resultSet.getString("AllowanceTime")
                        
                );
                roleList.add(rmn);
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
        return roleList;
    }
}
