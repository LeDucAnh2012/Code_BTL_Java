/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

/**
 *
 * @author ducan
 */
public class DBConnection {
    private Connection conn = null;
    private  final  String url = ("DESKTOP-CJNDNVK\\LEDUCANH_2043");
    private final String usrName = "sa";
    private final String pwd = "leducanh2012" ;
    private final String db = "QLCanBo";
    private final int port = 1433;

    SQLServerDataSource ds = new SQLServerDataSource();


    public DBConnection(){
        ds.setUser(usrName);
        ds.setPassword(pwd);
        ds.setDatabaseName(db);
        ds.setServerName(url);
        ds.setPortNumber(port);
    }
    
    public Connection GetConn(){
        try{
             conn = ds.getConnection();
             return conn;
        }catch (SQLException e) {
            
        }
           return conn;
    }
    public ResultSet GetData(String query){
        conn = GetConn();
        ResultSet rs = null;
         try{
                PreparedStatement stm = conn.prepareStatement(query);
                rs = stm.executeQuery();
                return rs;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
         return null;
    }
    public boolean Execute(String query){
        conn = GetConn();
         try{
                PreparedStatement stm = conn.prepareStatement(query);
                if(stm.executeUpdate() == 1)
                    return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
         return false;
    }    
}

       