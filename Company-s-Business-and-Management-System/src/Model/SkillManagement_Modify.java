
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
public class SkillManagement_Modify {
     
      public static List<SkillManagement> findAll() {
        List<SkillManagement> skillmanagementList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from levelofskill";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SkillManagement skillmanagement = new SkillManagement(resultSet.getInt("StaffID"),
                        resultSet.getString("StaffName"),
                        resultSet.getString("StaffSkill"),
                        resultSet.getString("Comment"),
                        resultSet.getString("LastDateComment"));
                       
                 skillmanagementList.add(skillmanagement);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
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
        return skillmanagementList;
    }
      
      //insert
       public static void insert(SkillManagement skillmanagement) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into levelofskill(StaffID,StaffName,StaffSkill,Comment,LastDateComment) values(?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, skillmanagement.getID());
            statement.setString(2, skillmanagement.getStaffName());
            statement.setString(3, skillmanagement.getStaffSkill());
            statement.setString(4, skillmanagement.getComment());
            statement.setString(5, skillmanagement.getLastDateComment());
         
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
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
       
       
       
          // getbyid
        public static SkillManagement getSkillManagementId(int id,String skill) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SkillManagement skm =new SkillManagement();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from levelofskill where StaffID = ? AND StaffSkill=?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, skill);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skm = new SkillManagement(resultSet.getInt("StaffID"),
                        resultSet.getString("StaffName"),
                        resultSet.getString("StaffSkill"),
                        resultSet.getString("Comment"),
                        resultSet.getString("LastDateComment")
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
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
        return skm;
    }
        
        
        //update
         
    public static void update(int ID, String StaffName, String StaffSkill,String PreSkill, String Comment,String LastDateComment) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update levelofskill set Comment =?, LastDateComment=?, StaffSkill=? where StaffID = ? AND 	StaffSkill  =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, Comment);
            statement.setString(2,  LastDateComment);
              statement.setString(3,   StaffSkill);
            statement.setInt(4,ID);
            statement.setString(5, PreSkill);
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE SUCCESS","",2);
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
    
    
    //delete
     public static void delete(int id,String skill) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from levelofskill  where StaffID = ? AND StaffSkill =?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.setString(2, skill);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE EMPLOYEE SKILL SUCCESS:"+""+skill,"",2);
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
     
     
     public static List<SkillManagement> findByName(String Name) {
        List<SkillManagement> skillList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from levelofskill where StaffName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SkillManagement skm = new SkillManagement(resultSet.getInt("StaffID"),
                        resultSet.getString("StaffName"),
                        resultSet.getString("StaffSkill"),
                        resultSet.getString("Comment"),
                        resultSet.getString("LastDateComment")
                        
                );
                skillList.add(skm);
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
        return skillList;
    }
}
