/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import static btl_nhom_1_de1_awt.fUser.User;
import static btl_nhom_1_de1_awt.fUser.about;
import static btl_nhom_1_de1_awt.fUser.btnTimKiem;
import static btl_nhom_1_de1_awt.fUser.dialog_about;
import static btl_nhom_1_de1_awt.fUser.lb_hoten;
import static btl_nhom_1_de1_awt.fUser.lb_title_user;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

/**
 *
 * @author Chien10
 */
public class fAdmin {
    static Frame Admin = new Frame("Admin");
    static Frame dialog_about=new Frame("About");
    static MenuBar menubar= new MenuBar();
    static Menu mFile=new Menu("File");
    static MenuItem itemAbout = new MenuItem("About");
    static JToolBar toolbar=new JToolBar();
    static Button btnTimKiem=new Button("Tìm kiếm");
    static Label lb_title_user=new Label("THÔNG TIN CÁN BỘ");
    static Label lb_hoten =new Label("Nhập họ tên: ");
    
    static Button Add=new Button("Add");
    static Button Search=new Button("Search");
    static Button View=new Button("View");
    static Label title_admin=new Label("PHẦN MỀM QUẢN LÝ CÁN BỘ");
    
    static Frame toolbarAdd=new Frame("ADD");
    static Frame toolbarView=new Frame("View");
    
    public static String iconNew = "iconNew.png";
    public static String iconOpen = "iconOpen.png";
    public static String iconSave = "iconSave.png";
    
    
    public static void main(String[] args) {
        //Code giao dien
        //Get SizeScreen
        Admin.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        Admin.setSize(500, 300);
        //Get Location
        int w = Admin.getSize().width;
        int h = Admin.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        Admin.setLocation(x, y);
        Admin.setVisible(true);
        
       
       //menubar
       menubar.add(mFile);
       
       
       mFile.add(itemAbout);
       Admin.setMenuBar(menubar);
       
        //toolbar
        Panel p=new Panel();
        toolbar.setBounds(0, 50, Admin.getWidth(), 30);
        //toolbar.add(p);
        toolbar.add(Add);
        toolbar.add(Search);
        toolbar.add(View);     
    
        Admin.add(toolbar,BorderLayout.NORTH);
        
        title_admin.setBounds(150, 150, 200, 50);
        Admin.add(title_admin);
        
        Add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tbAdd();
            }
        
        });
        Search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tbSearch();
            }
        });
        View.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tbView();
            }
        });
    
}
    static void tbAdd(){
       
        toolbarAdd.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        toolbarAdd.setSize(800, 500);
        //Get Location
        int w = toolbarAdd.getSize().width;
        int h = toolbarAdd.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        toolbarAdd.setLocation(x, y);
        toolbarAdd.setVisible(true);
        
        //header
        Label title_tbAdd=new Label("THÊM THÔNG TIN CÁN BỘ");
        title_tbAdd.setBounds(300, 50, 150, 30);
        
        //hoten
        Label HoTen=new Label("Họ tên:");
        HoTen.setBounds(100, 100, 80, 30);
        
        TextField txtHoTen=new TextField();
        txtHoTen.setBounds(200, 100, 400, 30);
        //nam sinh
        Label NamSinh=new Label("Năm sinh");
        NamSinh.setBounds(100, 150, 80, 30);
        
        TextField txtNamSinh=new TextField();
        txtNamSinh.setBounds(200, 150, 400, 30);
        
        //gioi tinh
        Label GioiTinh=new Label("Giới tính");
        GioiTinh.setBounds(100, 200, 80, 30);
        
        JPanel RadGioiTinh=new JPanel();
        RadGioiTinh.setBounds(200, 200, 400, 50);
        Border blackline= BorderFactory.createTitledBorder("Giới tính");
        RadGioiTinh.setBorder(blackline);
        
        Checkbox radNam=new Checkbox("Nam");
        
        Checkbox radNu=new Checkbox("Nữ");
        
        RadGioiTinh.add(radNam);
        RadGioiTinh.add(radNu);
        
        //diachi
        Label DiaChi=new Label("Đỉa chỉ");
        DiaChi.setBounds(100, 270, 80, 30);
        
        TextField txtDiaChi=new TextField();
        txtDiaChi.setBounds(200, 270, 400, 30);
        //chuc vu
        Label ChucVu=new Label("Chức vụ");
        ChucVu.setBounds(100, 320, 80, 30);
        
        Choice choice_ChucVu=new Choice();
        choice_ChucVu.setBounds(200, 320, 400, 30);
        choice_ChucVu.add("Chọn chức vụ");
        choice_ChucVu.add("Công nhân");
        choice_ChucVu.add("Kỹ sư");
        choice_ChucVu.add("Nhân viên");
        
        //Thuoc tinh
        Label ThuocTinh=new Label("Thuộc tính");
        ThuocTinh.setBounds(100, 370, 80, 30);
        
        TextField txtThuocTinh=new TextField();
        txtThuocTinh.setBounds(200, 370, 400, 30);
        
        //Button
        Button btnSave=new Button("Lưu");
        btnSave.setBounds(200, 420, 100, 30);
        
        Button btnCancel=new Button("Hủy");
        btnCancel.setBounds(450, 420, 100, 30);
        
        toolbarAdd.add(title_tbAdd);
        
        toolbarAdd.add(HoTen);
        toolbarAdd.add(txtHoTen);
        
        toolbarAdd.add(NamSinh);
        toolbarAdd.add(txtNamSinh);
        
        toolbarAdd.add(GioiTinh);
        toolbarAdd.add(RadGioiTinh);
        
        toolbarAdd.add(DiaChi);
        toolbarAdd.add(txtDiaChi);
        
        toolbarAdd.add(ChucVu);
        toolbarAdd.add(choice_ChucVu);
        
        toolbarAdd.add(ThuocTinh);
        toolbarAdd.add(txtThuocTinh);
        
        toolbarAdd.add(btnSave);
        toolbarAdd.add(btnCancel);
        
        //code chức năng: 
        btnCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                toolbarAdd.dispose();
            }
        });
    }
    static void tbSearch(){
        Frame f_tb_Search = new Frame("Search");    
        Button btnTimKiem=new Button("Tìm kiếm");
        Label lb_header=new Label("TÌM KIẾM THÔNG TIN CÁN BỘ");
        Label lb_hoten =new Label("Nhập họ tên: ");
    
        
        f_tb_Search.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        f_tb_Search.setSize(500, 300);
        //Get Location
        int w = f_tb_Search.getSize().width;
        int h = f_tb_Search.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        f_tb_Search.setLocation(x, y);
        f_tb_Search.setVisible(true);
        
        lb_header.setBounds(170, 50, 150, 30);
        
        
        lb_hoten.setBounds(80, 80, 70, 30);
        
        TextField txtTimKiem=new TextField();
        txtTimKiem.setBounds(170, 80, 200, 30);
        
        
        btnTimKiem.setBounds(200, 120, 70, 30);
        
        TextArea txaTTCanBo=new TextArea();
        txaTTCanBo.setBounds(50, 170, 400, 100);
        
        f_tb_Search.add(lb_header);
        f_tb_Search.add(lb_hoten);
        f_tb_Search.add(txtTimKiem);
        f_tb_Search.add(btnTimKiem);
        f_tb_Search.add(txaTTCanBo);
    }
    static void tbView(){
        toolbarView.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        toolbarView.setSize(800, 500);
        //Get Location
        int w = toolbarView.getSize().width;
        int h = toolbarView.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        toolbarView.setLocation(x, y);
        toolbarView.setVisible(true);
        
                //header
        Label title_tbView=new Label("THÊM THÔNG TIN CÁN BỘ");
        title_tbView.setBounds(300, 50, 150, 30);
        
        TextArea txaCanBo=new TextArea();
        txaCanBo.setBounds(100, 100, 600, 350);
        
        toolbarView.add(title_tbView);
        toolbarView.add(txaCanBo);
        
    }
}
