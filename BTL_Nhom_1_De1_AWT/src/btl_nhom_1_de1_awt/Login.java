/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author ducan
 */
public class Login implements ActionListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // Tao Frame
        Frame Login = new Frame("Login");
        //Get SizeScreen
        Login.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        Login.setSize(500, 300);
        //Get Location
        int w = Login.getSize().width;
        int h = Login.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        Login.setLocation(x, y);
        Login.setVisible(true);
        
        // Tao Label 
        Font newfont= new Font("chien",20,30);       
        Label labLogin = new Label("LOGIN");
        labLogin.setFont(newfont);
        labLogin.setBounds(200,30,200,50);
        
//        DBConnection conn = new DBConnection();

        Label labUsername=new Label("User name: ");
        Label labPassword=new Label("Password: ");
        
        labUsername.setBounds(80, 100, 100, 30);
        labPassword.setBounds(80, 150, 100, 30);
        
        TextField txtUsername =new TextField();
        txtUsername.setBounds(190, 100, 200, 30);
        
        TextField txtPassword =new TextField();
        txtPassword.setBounds(190, 150, 200, 30);
        
        JRadioButton radioBtnAdmin = new JRadioButton("Admin");
        JRadioButton radioBtnUser = new JRadioButton("User");
        radioBtnAdmin.setBounds(150, 200, 70, 30);
        radioBtnUser.setBounds(280, 200, 70, 30);
 
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioBtnAdmin);
        bg.add(radioBtnUser);
 
        Login.add(radioBtnAdmin);
        Login.add(radioBtnUser); 
        
        Button btnLogin =new Button("Login");
        btnLogin.setBounds(100, 250 ,70, 30);
        
        Button btnExit=new Button("Exit");
        btnExit.setBounds(280, 250, 70, 30);
        
        //PopupMenu
        
        PopupMenu popupMenu = new PopupMenu("Edit");
        MenuItem clear = new MenuItem("Clear ALL Text");
        clear.setActionCommand("Clear");
        MenuItem exit = new MenuItem("Exit");
        exit.setActionCommand("Exit");

        popupMenu.add(clear);
        popupMenu.add(exit);
        
        
        Login.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getButton() == e.BUTTON3) 
                popupMenu.show(Login, e.getX(), e.getY());
            }    
        });
        clear.addActionListener((ActionEvent e) -> {
            txtUsername.setText("");
            txtPassword.setText("");
            radioBtnAdmin.setSelected(false);
            radioBtnUser.setSelected(false);
        });
        
        exit.addActionListener((ActionEvent e) -> {
            Login.dispose();
        });
        
        Login.add(popupMenu);
        Login.add(labLogin);        
        Login.add(labUsername);
        Login.add(labPassword);
        Login.add(txtUsername);
        Login.add(txtPassword);
        Login.add(btnLogin);
        Login.add(btnExit);

        
        btnLogin.setActionCommand("login");
        btnLogin.addActionListener((ActionEvent e) -> {
            try {
                DAO dao = new DAO();
                ResultSet rs = dao.GetDataTableLogin();
                
                    String userName = txtUsername.getText();
                    String password = txtPassword.getText();
                    int PK = 0;
                    if(radioBtnUser.isSelected()){
                        PK = 0;
                    } else
                    if(radioBtnAdmin.isSelected()){
                        PK = 1;
                    }
                while (rs.next()){
                    
                    if( userName.equals(rs.getString("UserName")) && password.equals(rs.getString("PassWord_")) 
                            && Integer.parseInt(rs.getString("PhanQuyen")) == PK && PK == 1){
                       
                           fAdmin.main(args);
                           break;
                       }
                   else    
                     if( userName.equals(rs.getString("UserName")) && password.equals(rs.getString("PassWord_")) 
                            && Integer.parseInt(rs.getString("PhanQuyen")) == PK && PK == 0){
                       
                           fUser.main(args);
                           break;
                       }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Xem lại thông tin nhập");
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnExit.setActionCommand("exit");
        btnExit.addActionListener((ActionEvent arg0) -> {
            int request = JOptionPane.showConfirmDialog(Login,"Are you sure?");  
                if(request == JOptionPane.YES_OPTION){  
                        System.exit(0);
            }  
            
        });
        Login.addWindowListener(new WindowAdapter(){  
            @Override
            public void windowClosing(WindowEvent e) {  
                Login.dispose();  
            }  
        });  
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

    }
    
}
