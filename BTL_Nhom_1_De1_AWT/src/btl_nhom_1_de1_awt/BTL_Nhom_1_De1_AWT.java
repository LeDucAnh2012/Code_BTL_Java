/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author ducan
 */
public class BTL_Nhom_1_De1_AWT {

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
          Login.setSize(600, 600);
        //Get Location
        int w = Login.getSize().width;
        int h = Login.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        Login.setLocation(x, y);
        Login.setVisible(true);
        
        // Tao Label 
        Label labLogin = new Label("ĐĂNG NHẬP");
       
        labLogin.setBounds(250,30,200,50);
        Login.add(labLogin);
        DBConnection conn = new DBConnection();

    }
    
}
