/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
// ko github
/**
 *
 * @author anhng
 */
public class Staff_Modify {

    public static List<Staff> findAll() {
        List<Staff> staffList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from Employee";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Staff stf = new Staff(resultSet.getInt("Employee_ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("BirthPlace"),
                        resultSet.getString("DayOfBirth"),
                        resultSet.getString("Academic_NAME"),
                        resultSet.getString("Department_NAME"),
                        resultSet.getString("Role")
                );
                staffList.add(stf);
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
        return staffList;
    }

    public static List<Staff> findByName(String Name) {
        List<Staff> staffList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from Employee where name like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Staff stf = new Staff(resultSet.getInt("Employee_ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("BirthPlace"),
                        resultSet.getString("DayOfBirth"),
                        resultSet.getString("Academic_NAME"),
                        resultSet.getString("Department_NAME"),
                         resultSet.getString("Role")
                );
                staffList.add(stf);
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
        return staffList;
    }
    
    public static Staff getStaffId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Staff stf=new Staff();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from Employee where Employee_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stf = new Staff(resultSet.getInt("Employee_ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("BirthPlace"),
                        resultSet.getString("DayOfBirth"),
                        resultSet.getString("Academic_NAME"),
                        resultSet.getString("Department_NAME"),
                         resultSet.getString("Role")
                );
                
              
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
        return stf;
    }
    

    public static void insert(Staff stf) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into Employee(Employee_ID, Name, Gender, Address, BirthPlace, DayOfBirth, Academic_NAME, Department_NAME,Role) values(?, ?, ?, ?, ?, ?, ?, ?,?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, stf.getId());
            statement.setString(2, stf.getHoten());
            statement.setString(3, stf.getGioitinh());
            statement.setString(4, stf.getDiachithuongtru());
            statement.setString(5, stf.getNoisinh());
            statement.setString(6, stf.getNgaysinh());
            statement.setString(7, stf.getTrinhdohocvan());
            statement.setString(8, stf.getPhongban());      
            statement.setString(9, stf.getChucvuhientai());     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD NEW EMPLOYEE SUCCESS","",2);
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
    }
    
    
    
    public static void update(Staff stf) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update employee set Name=?, Gender=?, Address=?, BirthPlace=?, DayOfBirth=?, Academic_NAME=?, Department_NAME=?, Role=? where Employee_ID = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, stf.getHoten());
            statement.setString(2, stf.getGioitinh());
            statement.setString(3, stf.getDiachithuongtru());
            statement.setString(4, stf.getNoisinh());
            statement.setString(5, stf.getNgaysinh());
            statement.setString(6, stf.getTrinhdohocvan());
            statement.setString(7, stf.getPhongban());
            statement.setString(8, stf.getChucvuhientai());
            statement.setInt(9, stf.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE EMPLOYEE SUCCESS","",2);
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
    }
    
    
      public static List<Staff> findById(int id) {
        List<Staff> staffList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from Employee where Employee_ID ="+id;
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Staff stf = new Staff(resultSet.getInt("Employee_ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("BirthPlace"),
                        resultSet.getString("DayOfBirth"),
                        resultSet.getString("Academic_NAME"),
                        resultSet.getString("Department_NAME"),
                         resultSet.getString("Role")
                );
                staffList.add(stf);
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
        return staffList;
    }
}
