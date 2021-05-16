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
import java.awt.event.KeyEvent;

/**
 *
 * @author Chien10
 */
public class fUser {
    static Frame User = new Frame("User");
    static Frame dialog_about=new Frame("About");
    static MenuBar menubar= new MenuBar();
    static Menu mFile=new Menu("File");
    static MenuItem itemAbout = new MenuItem("About");
    static MenuItem itemExit = new MenuItem("Exit");
    static Button btnTimKiem=new Button("Tìm kiếm");
    static Label lb_title_user=new Label("THÔNG TIN CÁN BỘ");
    static Label lb_hoten =new Label("Nhập họ tên: ");
    
    public static void main(String[] args) {
        
        //Get SizeScreen
        User.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        User.setSize(500, 300);
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
       mFile.add(itemExit);
       
       User.setMenuBar(menubar);
       
        
        lb_title_user.setBounds(170, 50, 150, 30);
        
        
        lb_hoten.setBounds(80, 80, 70, 30);
        
        TextField txtTimKiem=new TextField();
        txtTimKiem.setBounds(170, 80, 200, 30);
        
        
        btnTimKiem.setBounds(200, 120, 70, 30);
        
        TextArea txaTTCanBo=new TextArea();
        txaTTCanBo.setBounds(50, 170, 400, 100);
       
        
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
        itemExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                User.dispose();
 
            }
        });
    }
    static void about(){
       
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
        
        Label aboutme=new Label("Made by nhom ... ");
        aboutme.setBounds(70, 50, 150, 40);
        
        dialog_about.add(aboutme);
        
     
    }
}
