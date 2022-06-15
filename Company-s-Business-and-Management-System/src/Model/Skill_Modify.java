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
public class Skill_Modify {
    
    
      public static List<Skill> findAll() {
        List<Skill> skillList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from Skill";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Skill skill = new Skill(resultSet.getString("SkillName")
                        );
                       
                 skillList.add(skill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return skillList;
    }
      
      //insert
       public static void insert(String skillname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into Skill set  SkillName =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, skillname);
  
         
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"INSERT SKILL SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
       
       
     //update
       public static void update(Skill skill,String PreSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update skill set SkillName =? where SkillName = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, skill.getName());
            statement.setString(2, PreSkill);
      
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Role_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE SKILL SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        
       // getRolebyid
        public static Skill getSkillbyName(String skillname) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Skill skill =new Skill();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from skill where SkillName  = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, skillname);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skill = new Skill(
                        resultSet.getString("SkillName")
                     
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Skill_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return skill;
    }   
       
       
      public static void delete(String skillName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from skill  where SkillName  = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, skillName);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE SKILL SUCCESS","",2);
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
       
       
       public static List<Skill> findByName(String Name) {
        List<Skill> skillList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from skill where SkillName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Skill sk = new Skill(resultSet.getString("SkillName")
                        
                        
                );
                skillList.add(sk);
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
