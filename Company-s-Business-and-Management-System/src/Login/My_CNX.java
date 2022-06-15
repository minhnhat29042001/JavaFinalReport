/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class My_CNX {
    public static String servername = "localhost";
    public static String username = "root";
    public static String dbname = "loginuser";
    public static Integer portnumber = 3306;
    public static String password = "";
    
    
   
    public static Connection getConnection()
    {
        Connection cnx = null;
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx =  (Connection) datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> "+ My_CNX.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
}
