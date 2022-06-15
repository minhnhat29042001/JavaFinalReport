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
public class Department_Modify {
      public static List<Department> findAll() {
        List<Department> departmentlList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from department";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department dpt = new Department(
                        resultSet.getString("DepartmentName"),
                        resultSet.getString("DepartmentPhonenumber")
                    );
                departmentlList.add(dpt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return departmentlList;
    }
      
      
      
      
      
      
      
        //insert
       public static void insert(Department department) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into department(DepartmentName, DepartmentPhonenumber)  values(?,?)";
            statement = connection.prepareCall(sql);
            statement.setString(1,department.getName() );
            statement.setString(2,department.getTelephone() );
  
         
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"INSERT DEPARTMENT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
       
       
     //update
       public static void update(Department department, String PreDepartment) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update department set DepartmentName =?, DepartmentPhonenumber=? where DepartmentName = ?";
            statement = connection.prepareCall(sql);
            
            
            statement.setString(1, department.getName());
            statement.setString(2, department.getTelephone()); 
            statement.setString(3, PreDepartment);
                       
                       
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE DEPARTMENT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        
       // getRolebyid
        public static Department getDepartmentbyName(String departmentname) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Department department =new Department();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from department where DepartmentName   = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1,departmentname);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                department = new Department(
                        resultSet.getString("DepartmentName"),
                        resultSet.getString("DepartmentPhonenumber")
                     
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return department;
    }  
        
        
        
         public static void delete(String departmentname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from department  where DepartmentName=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, departmentname);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SkillManagement_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE DEPARTMENT SUCCESS:"+""+departmentname,"",2);
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
         
         
          public static List<Department> findByName(String Name) {
        List<Department> departmentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from department where DepartmentName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department sk = new Department(resultSet.getString("DepartmentName"),
                        resultSet.getString("DepartmentPhonenumber")
                        
                );
                departmentList.add(sk);
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
        return departmentList;
    }
}
