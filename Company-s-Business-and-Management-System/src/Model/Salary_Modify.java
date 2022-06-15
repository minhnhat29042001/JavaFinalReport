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

/**
 *
 * @author anhng
 */
public class Salary_Modify {
      public static List<Salary> findAll() {
        List<Salary> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salary";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salary slr = new Salary(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime"),
                        resultSet.getString("Name")
                        
                );
                salaryList.add(slr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return salaryList;
    }

    public static List<Salary> findAll(String month, String year) {
        List<Salary> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            
            String sql = "select * from salary where month(SalaryTime) = " + month+ " and year(SalaryTime)="+year;
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salary slr = new Salary(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime"),
                        resultSet.getString("Name")
                        
                );
                salaryList.add(slr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return salaryList;
    }
    
    public static Salary getSalaryId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Salary slr=new Salary();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salary where Employee_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                slr = new Salary(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime"),
                        resultSet.getString("Name")
                        
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return slr;
    }
    

    public static void insert(Salary slr) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = ""
                    + "insert into Salary(Employee_ID, TotalSalary, SalaryTime, Name) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, slr.getEmployee_ID());
            statement.setInt(2, slr.getTotalSalary());
            statement.setString(3, slr.getSalaryTime());
            statement.setString(4, slr.getName());
               
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD EMPLOYEE SALARY SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static List<Salary> findByName(String Name) {
        List<Salary> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salary where name like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
                        Salary slr = new Salary(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime"),
                        resultSet.getString("Name")
                );
                salaryList.add(slr);
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
        return salaryList;
    }
    
    public static void update(Salary slr) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update salary set TotalSalary=?, Name=? where Employee_ID = ? and SalaryTime=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, slr.getTotalSalary());
            statement.setString(2, slr.getName());
            statement.setInt(3, slr.getEmployee_ID());
            statement.setString(4, slr.getSalaryTime());
           
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE EMPLOYEE SALARY SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Salary_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
