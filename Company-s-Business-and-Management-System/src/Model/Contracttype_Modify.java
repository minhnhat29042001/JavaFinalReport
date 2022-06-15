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
public class Contracttype_Modify {
      public static List<Contracttype> findAll() {
        List<Contracttype> contracttypeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contracttype";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contracttype contracttype = new Contracttype(resultSet.getInt("ContractType_ID"),
                        resultSet.getString("Contract_NAME"),
                        resultSet.getString("StartDateContract"),
                        resultSet.getString("EndDateContract"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("QuitJobDate")
                    );
                contracttypeList.add(contracttype);
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
        return  contracttypeList;
    }
 
      
        //insert
       public static void insert(Contracttype ctrt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into contracttype(ContractType_ID, Contract_NAME, StartDateContract, EndDateContract, Employee_ID, QuitJobDate) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, ctrt.getContracttypeid());
            statement.setString(2, ctrt.getContracttypeName());
            statement.setString(3, ctrt.getContractStartDate());
            statement.setString(4, ctrt.getContractEndDate());
            statement.setInt(5, ctrt.getStaffID());
            statement.setString(6, ctrt.getQuitJobDate());
              
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"ADD NEW CONTRACTTYPE SUCCESS","",2);
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
    
       
       
     //update
       public static void update(Contracttype contracttype) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update contracttype set Contract_NAME=?, StartDateContract=?, EndDateContract=?, Employee_ID=?, QuitJobDate=? where ContractType_ID=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, contracttype.getContracttypeName());
            statement.setString(2, contracttype.getContractStartDate());
            statement.setString(3, contracttype.getContractEndDate());
            statement.setInt(4, contracttype.getStaffID());
            statement.setString(5, contracttype.getQuitJobDate());
            statement.setInt(6, contracttype.getContracttypeid());
            
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Department_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE CONTRACT TYPE SUCCESS","",2);
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
        public static Contracttype getContracttypebyID(int contracttypeid) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Contracttype contracttype =new Contracttype();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contracttype where ContractType_ID = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1,contracttypeid);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 contracttype = new Contracttype(resultSet.getInt("ContractType_ID"),
                        resultSet.getString("Contract_NAME"),
                        resultSet.getString("StartDateContract"),
                         resultSet.getString("EndDateContract"),
                         resultSet.getInt("Employee_ID"),
                         resultSet.getString("QuitJobDate")
                     
                      
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
        return contracttype;
    }  
        
        
         public static List<Contracttype> findByName(String Name) {
        List<Contracttype> contracttypeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contracttype where Contract_NAME like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contracttype ctt = new Contracttype(resultSet.getInt("ContractType_ID"),
                        resultSet.getString("Contract_NAME"),
                        resultSet.getString("StartDateContract"),
                        resultSet.getString("EndDateContract"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("QuitJobDate")
                        
                );
                contracttypeList.add(ctt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contracttypeList;
    }
         
         
         
         public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from contracttype  where 	ContractType_ID  =?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE  EMPLOYEE CONTRACTTYPE SUCCESS ","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contracttype_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
         
    public static Contracttype getContracttypebyEmployee(int employee) {  
       Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Contracttype contracttype =new Contracttype();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contracttype where Employee_ID = ? and EndDateContract = (Select max(EndDateContract) from contracttype where Employee_ID=?)";
            
            statement = connection.prepareStatement(sql);
            statement.setInt(1,employee);
            statement.setInt(2,employee);
            
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 contracttype = new Contracttype(resultSet.getInt("ContractType_ID"),
                        resultSet.getString("Contract_NAME"),
                        resultSet.getString("StartDateContract"),
                         resultSet.getString("EndDateContract"),
                         resultSet.getInt("Employee_ID"),
                         resultSet.getString("QuitJobDate")
                     
                      
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
        return contracttype;
    }     
         
}
