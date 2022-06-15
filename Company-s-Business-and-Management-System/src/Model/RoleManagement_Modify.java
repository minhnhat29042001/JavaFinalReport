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
public class RoleManagement_Modify {
    
     public static List<RoleManagement> findAll() {
        List<RoleManagement> rolemanagementList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from staffrolemanagement";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
               RoleManagement rolemanagement = new RoleManagement(resultSet.getInt("ID"),
                        resultSet.getString("STAFFNAME"),
                        resultSet.getString("ROLE"),
                        resultSet.getString("START"),
                        resultSet.getString("END"));
                       
                 rolemanagementList.add(rolemanagement);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return rolemanagementList;
    }
      
      //insert
       public static void insert(RoleManagement rolemanagement) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into staffrolemanagement(ID,STAFFNAME,ROLE,START,END) values(?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, rolemanagement.getID());
            statement.setString(2, rolemanagement.getStaffName());
            statement.setString(3, rolemanagement.getRole());
            statement.setString(4, rolemanagement.getStartDate());
            statement.setString(5, rolemanagement.getEndDate());
         
            statement.execute();
    
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
               
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       // getbyid
        public static RoleManagement getRoleManagementId(int id,String role) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        RoleManagement rlm =new RoleManagement();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from staffrolemanagement where ID = ? AND 	ROLE=?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, role);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rlm = new RoleManagement(resultSet.getInt("ID"),
                        resultSet.getString("STAFFNAME"),
                        resultSet.getString("ROLE"),
                        resultSet.getString("START"),
                        resultSet.getString("END")
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return rlm;
    }
        
        
        //update
         
    public static void update(int ID, String Role, String StartDate, String EndDate,String prerole) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update staffrolemanagement set ROLE =?, START=?, END=? where ID = ? AND ROLE =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, Role);
            statement.setString(2, StartDate);
            statement.setString(3,EndDate);
            statement.setInt(4,ID);
            statement.setString(5, prerole);
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    //delete
     public static void delete(int id,String role) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from staffrolemanagement  where ID = ? AND ROLE =?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.setString(2, role);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE EMPLOYEE ROLE SUCCESS:"+""+role,"",2);
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoleManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
     
        public static List<RoleManagement> findByName(String Name) {
        List<RoleManagement> roleList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from staffrolemanagement where STAFFNAME like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                RoleManagement rmn = new RoleManagement(resultSet.getInt("ID"),
                        resultSet.getString("STAFFNAME"),
                        resultSet.getString("ROLE"),
                        resultSet.getString("START"),
                        resultSet.getString("END")
                        
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
