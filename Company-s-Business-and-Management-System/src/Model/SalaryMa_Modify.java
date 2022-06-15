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
public class SalaryMa_Modify {
     public static List<SalaryMa> findAll() {
        List<SalaryMa> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salarymanagement";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SalaryMa slr = new SalaryMa(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Overtime"),
                        resultSet.getInt("OvertimePay"),
                        resultSet.getInt("TotalOVT"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime")
                        
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

    public static List<SalaryMa> findAll(String month, String year) {
        List<SalaryMa> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            
            String sql = "select * from salarymanagement where month(SalaryTime) = " + month+ " and year(SalaryTime)="+year;
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SalaryMa slr = new SalaryMa(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Overtime"),
                        resultSet.getInt("OvertimePay"),
                        resultSet.getInt("TotalOVT"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime")
                        
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
    
    public static SalaryMa getSalaryId(int id) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SalaryMa slr = new SalaryMa();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salarymanagement where Employee_ID = ?";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                slr = new SalaryMa(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Overtime"),
                        resultSet.getInt("OvertimePay"),
                        resultSet.getInt("TotalOVT"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime")
                        
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
    
     public static SalaryMa getSalary(int emid, int month, int year) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SalaryMa slr = new SalaryMa();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salarymanagement where Employee_ID = "+emid+" and MONTH(SalaryTime)="+month+" and YEAR(SalaryTime)="+year;
            
            statement = connection.prepareStatement(sql);
            
            
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                slr = new SalaryMa(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Overtime"),
                        resultSet.getInt("OvertimePay"),
                        resultSet.getInt("TotalOVT"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime")
                        
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
    
    public static void insert(SalaryMa slr) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into salarymanagement(Employee_ID, BonusLevel,Overtime, OvertimePay,TotalOVT,TotalSalary, SalaryTime) values(?,?,?,?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, slr.getEmployee_ID());
            statement.setString(2, slr.getBonusLevel());
            statement.setInt(3, slr.getOvertime());
            statement.setInt(4, slr.getOvertimePay());
            statement.setInt(5, slr.getTotalOVT());
            statement.setInt(6, slr.getTotalSalary());
            statement.setString(7, slr.getSalaryTime());
               
               
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
    
    
    
    
   public static void update(SalaryMa slr, int month, int year) {
        Connection connection = null;
        PreparedStatement statement = null;
        String SalaryTime = slr.getSalaryTime();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update salarymanagement set BonusLevel=?, Overtime=?,OvertimePay=?,TotalOVT=?,TotalSalary=? where Employee_ID = ? and MONTH(SalaryTime)="+month+" and YEAR(SalaryTime)="+year;
            statement = connection.prepareCall(sql);
            
            statement.setString(1, slr.getBonusLevel());
            statement.setInt(2, slr.getOvertime());
            statement.setInt(3, slr.getOvertimePay());
            statement.setInt(4, slr.getTotalOVT());
            statement.setInt(5, slr.getTotalSalary());
            statement.setInt(6, slr.getEmployee_ID());
            
           
            
            
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
   
   
     public static List<SalaryMa> findByName(String Name, int month, int year) {
        List<SalaryMa> salaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from salarymanagement where Employee_ID = "+Name+" and month(SalaryTime)="+month+" and year(SalaryTime)="+year;
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SalaryMa slr = new SalaryMa(resultSet.getInt("Salary_ID"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("BonusLevel"),
                        resultSet.getInt("Overtime"),
                        resultSet.getInt("OvertimePay"),
                        resultSet.getInt("TotalOVT"),
                        resultSet.getInt("TotalSalary"),
                        resultSet.getString("SalaryTime")
                        
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
}
