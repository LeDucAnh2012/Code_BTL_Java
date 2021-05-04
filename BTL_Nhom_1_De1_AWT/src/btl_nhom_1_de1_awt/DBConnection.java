/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;
import java.util.Collection;

/**
 *
 * @author ducan
 */
public class DBConnection {
    private Connection conn = null;
    private String query = null;
    private ResultSet rs;
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
        try{
             conn = ds.getConnection();
            System.out.println("Ket noi thanh cong");
            System.out.println(conn.getCatalog());
            try{

                query = "SELECT * from Account";
                PreparedStatement stm = conn.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()){
                    String userName = rs.getString("Username");
                    String password = rs.getString("PassWord_");

                    System.out.println("Username : " + userName + "\n" + "Password : " + password);

                }
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
