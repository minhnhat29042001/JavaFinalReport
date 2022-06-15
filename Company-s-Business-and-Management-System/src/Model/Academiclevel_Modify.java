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
public class Academiclevel_Modify {
 
    public static List<Academiclevel> findAll() {
        List<Academiclevel> academiclevelList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from academic_level";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Academiclevel acl = new Academiclevel(
                        resultSet.getString("Academic_Name")
                    );
                academiclevelList.add(acl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return academiclevelList;
    }
    
      //insert
       public static void insert(String academiclevelname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into academic_level set  Academic_Name =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, academiclevelname);
  
         
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"INSERT ACADEMIC LEVEL SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
       
       
     //update
       public static void update(Academiclevel academiclevel,String PreAcademiclevel) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update academic_level set Academic_Name =? where Academic_Name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, academiclevel.getAcademic_name());
            statement.setString(2, PreAcademiclevel);
      
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE ACADEMIC LEVEL SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        
       // getRolebyid
        public static Academiclevel getAcademiclevelbyName(String academiclevelname) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Academiclevel academiclevel =new Academiclevel();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from academic_level where Academic_Name  = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, academiclevelname);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                academiclevel = new  Academiclevel(
                        resultSet.getString("Academic_Name")
                     
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Academiclevel_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return academiclevel;
    }   
       
     public static void delete(String academicname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from academic_level  where Academic_Name  =";
            statement = connection.prepareCall(sql);
            statement.setString(1, academicname);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE ACADEMIC LEVEL SUCCESS:"+""+academicname,"",2);
                } catch (SQLException ex) {
                    Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
