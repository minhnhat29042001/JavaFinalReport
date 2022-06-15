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
public class Contract_Modify {
      public static List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contract";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contract contract = new Contract(
                        resultSet.getString("ContractName"),
                        resultSet.getInt("BasicSalary"),
                        resultSet.getString("ContractTime")
                );
                       
                 contractList.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return  contractList;
    }
      
      //insert
       public static void insert(Contract contract) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "insert into contract set  ContractName =?, BasicSalary =?, ContractTime =?  ";
            statement = connection.prepareCall(sql);
            statement.setString(1, contract.getContractName());
            statement.setInt(2, contract.getBasicSalary());
            statement.setString(3, contract.getContractTime());
  
         
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"INSERT CONTRACT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
       
       
     //update
       public static void update(Contract contract, String PreContract) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "update contract set ContractName = ?, BasicSalary =?, ContractTime =?  where ContractName  = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, contract.getContractName());
            statement.setInt(2, contract.getBasicSalary());
            statement.setString(3, contract.getContractTime());
            statement.setString(4, PreContract);
            
         
            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"UPDATE CONTRACT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
       
        
       // getRolebyid
        public static Contract getContractbyName(String contractname) {  
       
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Contract contract =new Contract();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contract where ContractName   = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, contractname);
        
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contract = new Contract(
                        resultSet.getString("ContractName"),
                        resultSet.getInt("BasicSalary"),    
                         resultSet.getString("ContractTime")
                      
                );
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contract;
    }   
        
        
          public static List<Contract> findByName(String Name) {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contract where ContractName like '%"+Name+"%'";
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contract sk = new Contract(resultSet.getString("ContractName"),
                        resultSet.getInt("BasicSalary"),
                        resultSet.getString("ContractTime")
                        
                );
                contractList.add(sk);
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
        return contractList;
    }
          
          
           public static void delete(String contractname) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "delete from contract  where 		ContractName  = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1,contractname);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    JOptionPane.showMessageDialog(null,"DELETE CONTRACT SUCCESS","",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Contract_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
