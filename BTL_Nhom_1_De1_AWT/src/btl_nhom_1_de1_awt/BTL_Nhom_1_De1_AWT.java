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
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ducan
 */
public class BTL_Nhom_1_De1_AWT implements ActionListener{

    /**
     * @param args the command line arguments
     */
    static TextField txtUsername =new TextField();
    static Button btnLogin =new Button("Login");
    
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
        
        
        txtUsername.setBounds(190, 100, 200, 30);
        
        TextField txtPassword =new TextField();
        txtPassword.setBounds(190, 150, 200, 30);
        
        
        btnLogin.setBounds(100, 200, 70, 30);
        
        Button btnExit=new Button("Exit");
        btnExit.setBounds(280, 200, 70, 30);
        
        Login.add(labLogin);        
        Login.add(labUsername);
        Login.add(labPassword);
        Login.add(txtUsername);
        Login.add(txtPassword);
        Login.add(btnLogin);
        Login.add(btnExit);
        
        btnLogin.setActionCommand("login");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String x= txtUsername.getText();
                if(x.equals("abc")){
                    btnLogin.setLabel(x);
                }
 
            }
        });
        
        btnExit.setActionCommand("exit");
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnExit.setLabel("Chieens");
 
            }
        });
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("login".equals(e.getActionCommand())){
            
        }
    }
    
}
