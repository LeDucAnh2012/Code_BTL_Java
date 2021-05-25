/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chien10
 */
public class fUser implements ActionListener {
   
    
    public static void main(String[] args) {
          Frame User = new Frame("User");
    
     MenuBar menubar= new MenuBar();
     Menu mFile=new Menu("File");
     MenuItem itemAbout = new MenuItem("About");
     Button btnTimKiem=new Button("Tìm kiếm");
     Label lb_title_user=new Label("THÔNG TIN CÁN BỘ");
     Label lb_hoten =new Label("Nhập họ tên: ");
        //Get SizeScreen
        User.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        User.setSize(800, 400);
        //Get Location
        int w = User.getSize().width;
        int h = User.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        User.setLocation(x, y);
        User.setVisible(true);
        
       
       
       menubar.add(mFile);
       
       
       mFile.add(itemAbout);
       
       User.setMenuBar(menubar);
       
        
        lb_title_user.setBounds(250, 50, 150, 30);
        
        
        lb_hoten.setBounds(160, 80, 70, 30);
        
        TextField txtTimKiem=new TextField();
        txtTimKiem.setBounds(250, 80, 200, 30);
        
        
        btnTimKiem.setBounds(300, 120, 70, 30);
        
        TextArea txaTTCanBo=new TextArea();
        txaTTCanBo.setBounds(50, 170, 700, 150);
       
        
        User.add(lb_title_user);
        User.add(lb_hoten);
        User.add(txtTimKiem);
        User.add(btnTimKiem);
        User.add(txaTTCanBo);
       
        //code
        itemAbout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                about();
 
            }
        });
         User.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                User.dispose();  
            }  
        });  
        //Code button Search
        btnTimKiem.setActionCommand("Tim Kiem");
        btnTimKiem.addActionListener((var e) -> {
              try {
                 DAO dao = new DAO();
                  ResultSet rs = dao.GetDataUser(txtTimKiem.getText());
                  String result =  String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Mã Cán Bộ","Tên Cán Bộ","Năm Sinh","Giới Tính","Địa Chỉ","Chức Vụ","Thuộc Tính");
                  txaTTCanBo.setText(result + "\n");
                  while (rs.next()){
                      if(rs.getString("ChucVu").equals("Nhân Viên")){
                          NhanVien nv = new NhanVien();
                      nv.MaCanBo = rs.getString("MaCanBo");
                      nv.TenCanBo = rs.getString("TenCanBo");
                      nv.NamSinh = rs.getString("NamSinh"); 
                      nv.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                      nv.DiaChi = rs.getString("DiaChi");
                      nv.ChucVu = rs.getString("ChucVu");
                      nv.CongViec = rs.getString("ThuocTinh");
                      txaTTCanBo.setText(txaTTCanBo.getText()+ nv.toString()+ "\n");
                      }
                      else if(rs.getString("ChucVu").equals("Kỹ Sư")){
                          KySu ks = new KySu();
                      ks.MaCanBo = rs.getString("MaCanBo");
                      ks.TenCanBo = rs.getString("TenCanBo");
                      ks.NamSinh = rs.getString("NamSinh"); 
                      ks.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                      ks.DiaChi = rs.getString("DiaChi");
                      ks.ChucVu = rs.getString("ChucVu");
                      ks.NganhDaoTao = rs.getString("ThuocTinh");
                      txaTTCanBo.setText(txaTTCanBo.getText()+ ks.toString()+ "\n");
                      }
                      else if(rs.getString("ChucVu").equals("Công Nhân")){
                          CongNhan cn = new CongNhan();
                      cn.MaCanBo = rs.getString("MaCanBo");
                      cn.TenCanBo = rs.getString("TenCanBo");
                      cn.NamSinh = rs.getString("NamSinh"); 
                      cn.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                      cn.DiaChi = rs.getString("DiaChi");
                      cn.ChucVu = rs.getString("ChucVu");
                      cn.Bac = rs.getString("ThuocTinh");
                      txaTTCanBo.setText(txaTTCanBo.getText()+ cn.toString()+ "\n");
                      }
                      else {
                          txaTTCanBo.setText("");
                      } 
                      
                  }
              }catch (SQLException ex) {
                  Logger.getLogger(fUser.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
    }
    static void about(){
        Frame dialog_about=new Frame("About");
        dialog_about.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        dialog_about.setSize(300, 150);
        //Get Location
        int w = dialog_about.getSize().width;
        int h = dialog_about.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        dialog_about.setLocation(x, y);
        dialog_about.setVisible(true);
        
        Label aboutme=new Label("Made by nhom 1 KTPM1 K13");
        aboutme.setBounds(70, 50, 150, 40);
        
        dialog_about.add(aboutme);
        dialog_about.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dialog_about.dispose();  
            }  
        });  
        
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
