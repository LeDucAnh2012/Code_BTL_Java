/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;
import com.sun.jdi.connect.spi.Connection;

import java.sql.*;
/**
 *
 * @author ducan
 */
public class DAO {
    DBConnection DBconn = new DBConnection();
   public ResultSet GetDataTableLogin(){
       String SQL_SELECT = "Select * from Account";
       return DBconn.GetData(SQL_SELECT);
   }
   
   public ResultSet GetDataUser(String UserName){
       String SQL_SELECT = "select * from CanBo Where TenCanBo = N'"+UserName+"'";
       return DBconn.GetData(SQL_SELECT);
   }
   public boolean InsertCongNhan(CongNhan cn){
        String SQL_INSERT = "INSERT INTO CanBo values ( '"+cn.MaCanBo+"' , N'"+cn.TenCanBo+"' , '"+cn.NamSinh+"' , '"+cn.GioiTinh+"'"
               + " , N'"+cn.DiaChi+"' , N'"+cn.ChucVu+"' , N'"+cn.Bac+"')";
       return DBconn.Execute(SQL_INSERT);
   }
   public boolean InsertKySu(KySu ks){
        String SQL_INSERT = "INSERT INTO CanBo values ( '"+ks.MaCanBo+"' , N'"+ks.TenCanBo+"' , '"+ks.NamSinh+"' , '"+ks.GioiTinh+"'"
               + " , N'"+ks.DiaChi+"' , N'"+ks.ChucVu+"' , N'"+ks.NganhDaoTao+"')";
       return DBconn.Execute(SQL_INSERT);
   }
   public boolean InsertNhanVien(NhanVien nv){
        String SQL_INSERT = "INSERT INTO CanBo values ( '"+nv.MaCanBo+"' , N'"+nv.TenCanBo+"' , '"+nv.NamSinh+"' , '"+nv.GioiTinh+"'"
               + " , N'"+nv.DiaChi+"' , N'"+nv.ChucVu+"' , N'"+nv.CongViec+"')";
       return DBconn.Execute(SQL_INSERT);
   }
   public ResultSet GetDataTableCanBo(){
       String SQL_SELECT = "select * from CanBo";
       return DBconn.GetData(SQL_SELECT);
   } 
}

