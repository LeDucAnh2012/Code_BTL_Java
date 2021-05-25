/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    static Frame f_tb_Search = new Frame("Search");  
    
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
        
        Add.addActionListener((ActionEvent arg0) -> {
            tbAdd();
        });
        Search.addActionListener((ActionEvent arg0) -> {
            tbSearch();
        });
        View.addActionListener((ActionEvent arg0) -> {
            tbView();
           
        });
            Admin.addWindowListener(new WindowAdapter(){  
            @Override
            public void windowClosing(WindowEvent e) {  
                Admin.dispose();  
            }  
        });  
        mFile.addActionListener((ActionEvent arg0) -> {
            fUser.about();
        });
}
   
    static void tbAdd(){
       
        toolbarAdd.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        toolbarAdd.setSize(800, 550);
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
        
        //Ma can bo
        Label MaCanBo = new Label ("Mã cán bộ");
        MaCanBo.setBounds(100,100,80,30);
        
        TextField txtMaCanBo = new TextField();
        txtMaCanBo.setBounds(200,100,400,30);
        //hoten
        Label HoTen=new Label("Họ tên:");
        HoTen.setBounds(100, 150, 80, 30);
        
        TextField txtHoTen=new TextField();
        txtHoTen.setBounds(200, 150, 400, 30);
        //nam sinh
        Label NamSinh=new Label("Năm sinh");
        NamSinh.setBounds(100, 200, 80, 30);
        
        TextField txtNamSinh=new TextField();
        txtNamSinh.setBounds(200, 200, 400, 30);
        
        //gioi tinh
        Label GioiTinh=new Label("Giới tính");
        GioiTinh.setBounds(100, 250, 80, 30);
        
        JPanel RadGioiTinh=new JPanel();
        RadGioiTinh.setBounds(200, 250, 400, 50);
        Border blackline= BorderFactory.createTitledBorder("Giới tính");
        RadGioiTinh.setBorder(blackline);
        
        JRadioButton radioBtnNam = new JRadioButton("Nam");
        JRadioButton radioBtnNu = new JRadioButton("Nữ");
        radioBtnNam.setBounds(350, 260, 70, 30);
        radioBtnNu.setBounds(450, 260, 70, 30);
 
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioBtnNam);
        bg.add(radioBtnNu);
        
        RadGioiTinh.add(radioBtnNam);
        RadGioiTinh.add(radioBtnNu);
        
        toolbarAdd.add(radioBtnNam);
        toolbarAdd.add(radioBtnNu); 
        
        
        
        //diachi
        Label DiaChi=new Label("Địa chỉ");
        DiaChi.setBounds(100, 320, 80, 30);
        
        TextField txtDiaChi=new TextField();
        txtDiaChi.setBounds(200, 320, 400, 30);
        //chuc vu
        Label ChucVu=new Label("Chức vụ");
        ChucVu.setBounds(100, 370, 80, 30);
        
        Choice choice_ChucVu=new Choice();
        choice_ChucVu.setBounds(200, 370, 400, 30);
        choice_ChucVu.add("Chọn chức vụ");
        choice_ChucVu.add("Công Nhân");
        choice_ChucVu.add("Kỹ Sư");
        choice_ChucVu.add("Nhân Viên");
        
        //Thuoc tinh
        Label ThuocTinh=new Label("Thuộc tính");
        ThuocTinh.setBounds(100, 420, 80, 30);
        
        TextField txtThuocTinh=new TextField();
        txtThuocTinh.setBounds(200, 420, 400, 30);
        
        //Button
        Button btnSave=new Button("Lưu");
        btnSave.setBounds(200, 470, 100, 30);
        
        Button btnCancel=new Button("Hủy");
        btnCancel.setBounds(450, 470, 100, 30);
        
        toolbarAdd.add(title_tbAdd);
        
        toolbarAdd.add(MaCanBo);
        toolbarAdd.add(txtMaCanBo);
        
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
        //chuc nang them can bo
          choice_ChucVu.addItemListener((ItemEvent e) -> {
              if("Nhân Viên".equals(choice_ChucVu.getSelectedItem())){
                 ThuocTinh.setText("Bậc Lương");
              }
              else if("Kỹ Sư".equals(choice_ChucVu.getSelectedItem())){
                 ThuocTinh.setText("Ngành ĐT");
              }
              else if("Công Nhân".equals(choice_ChucVu.getSelectedItem())){
                 ThuocTinh.setText("Công Việc");
              }
        });  
        btnSave.addActionListener((ActionEvent arg0) -> {
            
            CanBo cb = new CanBo();
                cb.MaCanBo = txtMaCanBo.getText();
                cb.TenCanBo = txtHoTen.getText();
                cb.NamSinh = txtNamSinh.getText();
                cb.DiaChi = txtDiaChi.getText();
                if(radioBtnNam.isSelected())
                    cb.GioiTinh = true;
                if(radioBtnNu.isSelected())
                    cb.GioiTinh = false;
                cb.ChucVu = choice_ChucVu.getSelectedItem();
                
                if("".equals(txtMaCanBo.getText())){
                    JOptionPane.showMessageDialog(null, "Hãy ghi thông tin mã cán bộ");
                    return;
                }
                if("".equals(txtHoTen.getText())){
                    JOptionPane.showMessageDialog(null,"Hãy ghi thông tin tên cán bộ");
                    return;
                }
                if("".equals(txtNamSinh.getText())){
                    JOptionPane.showMessageDialog(null, "Hãy ghi thông tin năm sinh cán bộ");
                    return;
                }
                if("".equals(txtDiaChi.getText())){
                    JOptionPane.showMessageDialog(null, "Hãy ghi thông tin địa chỉ cán bộ");
                    return;
                }
                if(null == cb.ChucVu){
                    JOptionPane.showMessageDialog(null, "Hãy Chọn Chức Vụ");
                    return;
                }
                
                else switch (cb.ChucVu) {
                case "Công Nhân" ->                     {
                        txtThuocTinh.setName("Bậc");
                        CongNhan cn = new CongNhan();
                        cn.MaCanBo = cb.MaCanBo;
                        cn.TenCanBo = cb.TenCanBo;
                        cn.NamSinh = cb.NamSinh;
                        cn.GioiTinh = cb.GioiTinh;
                        cn.DiaChi = cb.DiaChi;
                        cn.ChucVu = cb.ChucVu;
                        cn.Bac = txtThuocTinh.getText();
                       
                        if("".equals(txtThuocTinh.getText())){
                            JOptionPane.showMessageDialog(null, "Hãy ghi thông tin bậc lương");
                            return;
                        }
                        DAO dao = new DAO();
                        if(dao.InsertCongNhan(cn)){
                            JOptionPane.showMessageDialog(null, "Insert Successfully!");
                        }
                        else JOptionPane.showMessageDialog(null, "Insert failed!");
                    }
                case "Kỹ Sư" ->                     {
                        txtThuocTinh.setName("Ngành Đào Tạo");
                        KySu ks = new KySu();
                        ks.MaCanBo = cb.MaCanBo;
                        ks.TenCanBo = cb.TenCanBo;
                        ks.NamSinh = cb.NamSinh;
                        ks.GioiTinh = cb.GioiTinh;
                        ks.DiaChi = cb.DiaChi;
                        ks.ChucVu = cb.ChucVu;
                        ks.NganhDaoTao = txtThuocTinh.getText();
                        if("".equals(txtThuocTinh.getText())){
                            JOptionPane.showMessageDialog(null, "Hãy ghi thông tin ngành đào tạo");
                            return;
                        }
                        DAO dao = new DAO();
                        if(dao.InsertKySu(ks)){
                            JOptionPane.showMessageDialog(null, "Insert Successfully!");
                        }
                        else JOptionPane.showMessageDialog(null, "Insert failed!");
                    }
                case "Nhân Viên" ->                     {
                        txtThuocTinh.setName("Công Việc");
                        NhanVien nv = new NhanVien();
                        nv.MaCanBo = cb.MaCanBo;
                        nv.TenCanBo = cb.TenCanBo;
                        nv.NamSinh = cb.NamSinh;
                        nv.GioiTinh = cb.GioiTinh;
                        nv.DiaChi = cb.DiaChi;
                        nv.ChucVu = cb.ChucVu;
                        nv.CongViec = txtThuocTinh.getText();
                        if("".equals(txtThuocTinh.getText())){
                            JOptionPane.showMessageDialog(null, "Hãy ghi thông tin công việc");
                            return;
                        }
                        DAO dao = new DAO();
                        if(dao.InsertNhanVien(nv)){
                            JOptionPane.showMessageDialog(null, "Insert Successfully!");
                        }
                        else JOptionPane.showMessageDialog(null, "Insert failed!");
                    }
                default -> JOptionPane.showMessageDialog(null, "Hãy Chọn Chức Vụ");
            }
                
                
        });
        
        btnCancel.addActionListener((ActionEvent arg0) -> {
            toolbarAdd.dispose();
        });
        
         toolbarAdd.addWindowListener(new WindowAdapter(){  
            @Override
            public void windowClosing(WindowEvent e) {  
                toolbarAdd.dispose();  
            }  
        });  
    }
    static void tbSearch(){
          
        Button btnTimKiem=new Button("Tìm kiếm");
        Label lb_header=new Label("TÌM KIẾM THÔNG TIN CÁN BỘ");
        Label lb_hoten =new Label("Nhập họ tên: ");
    
        
        f_tb_Search.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Set Size to Frame
        f_tb_Search.setSize(800, 400);
        //Get Location
        int w = f_tb_Search.getSize().width;
        int h = f_tb_Search.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the Frame to center Screen
        f_tb_Search.setLocation(x, y);
        f_tb_Search.setVisible(true);
        
        lb_header.setBounds(250, 50, 150, 30);
        
        
        lb_hoten.setBounds(160, 80, 70, 30);
        
        TextField txtTimKiem=new TextField();
        txtTimKiem.setBounds(250, 80, 200, 30);
        
        
        btnTimKiem.setBounds(300, 120, 70, 30);
        
        TextArea txaTTCanBo=new TextArea();
        txaTTCanBo.setBounds(50, 170, 700, 150);
        
        f_tb_Search.add(lb_header);
        f_tb_Search.add(lb_hoten);
        f_tb_Search.add(txtTimKiem);
        f_tb_Search.add(btnTimKiem);
        f_tb_Search.add(txaTTCanBo);

        btnTimKiem.setActionCommand("Tim Kiem");
        btnTimKiem.addActionListener((ActionEvent e) -> {
              try {
                 
                 DAO dao = new DAO();
                  ResultSet rs = dao.GetDataUser(txtTimKiem.getText());
                  String result =  String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Mã Cán Bộ","Tên Cán Bộ","Năm Sinh","Giới Tính","Địa Chỉ","Chức Vụ","Thuộc Tính");
                  txaTTCanBo.setText(result + "\n");
                  while (rs.next()){
                     switch (rs.getString("ChucVu")) {
                         case "Nhân Viên" -> {
                             
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
                         case "Kỹ Sư" -> {
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
                         case "Công Nhân" -> {
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
                         default -> txaTTCanBo.setText("");
                     }
                      
                  }
              }catch (SQLException ex) {
                  Logger.getLogger(fUser.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
    
        f_tb_Search.addWindowListener(new WindowAdapter(){  
            @Override
            public void windowClosing(WindowEvent e) {  
                f_tb_Search.dispose();  
            }  
        });  
    
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
        Label title_tbView=new Label("XEM THÔNG TIN CÁN BỘ");
        title_tbView.setBounds(300, 50, 150, 30);
        
        TextArea txaCanBo=new TextArea();
        txaCanBo.setBounds(50, 100, 700, 350);
        
         Button btnReload=new Button("ReLoad");
        btnReload.setBounds(600,50,50,30);
        
        toolbarView.add(title_tbView);
        toolbarView.add(txaCanBo);
        toolbarView.add(btnReload);
        
        toolbarView.addWindowListener(new WindowAdapter(){  
            @Override
            public void windowClosing(WindowEvent e) {  
                toolbarView.dispose();     
            }    
        });
             try {
                 DAO dao = new DAO();
                  ResultSet rs = dao.GetDataTableCanBo();
                  
                  String result =  String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Mã Cán Bộ","Tên Cán Bộ","Năm Sinh","Giới Tính","Địa Chỉ","Chức Vụ","Thuộc Tính");
                  txaCanBo.setText(result + "\n");
                  while (rs.next()){
                     switch (rs.getString("ChucVu")) {
                         case "Nhân Viên" -> {
                             NhanVien nv = new NhanVien();
                             nv.MaCanBo = rs.getString("MaCanBo");
                             nv.TenCanBo = rs.getString("TenCanBo");
                             nv.NamSinh = rs.getString("NamSinh");
                             nv.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                             nv.DiaChi = rs.getString("DiaChi");
                             nv.ChucVu = rs.getString("ChucVu");
                             nv.CongViec = rs.getString("ThuocTinh");
                             txaCanBo.setText(txaCanBo.getText()+ nv.toString()+ "\n");
                         }
                         case "Kỹ Sư" -> {
                             KySu ks = new KySu();
                             ks.MaCanBo = rs.getString("MaCanBo");
                             ks.TenCanBo = rs.getString("TenCanBo");
                             ks.NamSinh = rs.getString("NamSinh");
                             ks.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                             ks.DiaChi = rs.getString("DiaChi");
                             ks.ChucVu = rs.getString("ChucVu");
                             ks.NganhDaoTao = rs.getString("ThuocTinh");
                             txaCanBo.setText(txaCanBo.getText()+ ks.toString()+ "\n");
                         }
                         case "Công Nhân" -> {
                             CongNhan cn = new CongNhan();
                             cn.MaCanBo = rs.getString("MaCanBo");
                             cn.TenCanBo = rs.getString("TenCanBo");
                             cn.NamSinh = rs.getString("NamSinh");
                             cn.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                             cn.DiaChi = rs.getString("DiaChi");
                             cn.ChucVu = rs.getString("ChucVu");
                             cn.Bac = rs.getString("ThuocTinh");
                             txaCanBo.setText(txaCanBo.getText()+ cn.toString()+ "\n");
                         }
                         default -> txaCanBo.setText("");
                     }
                      
                  }
              }catch (SQLException ex) {
                  Logger.getLogger(fUser.class.getName()).log(Level.SEVERE, null, ex);
              }

        btnReload.addActionListener((ActionEvent e) -> {
            try {
                DAO dao = new DAO();
                ResultSet rs = dao.GetDataTableCanBo();
                String result =  String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Mã Cán Bộ","Tên Cán Bộ","Năm Sinh","Giới Tính","Địa Chỉ","Chức Vụ","Thuộc Tính");
                txaCanBo.setText(result + "\n");
                while (rs.next()){
                    switch (rs.getString("ChucVu")) {
                        case "Nhân Viên" -> {
                            NhanVien nv = new NhanVien();
                            nv.MaCanBo = rs.getString("MaCanBo");
                            nv.TenCanBo = rs.getString("TenCanBo");
                            nv.NamSinh = rs.getString("NamSinh");
                            nv.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                            nv.DiaChi = rs.getString("DiaChi");
                            nv.ChucVu = rs.getString("ChucVu");
                            nv.CongViec = rs.getString("ThuocTinh");
                            txaCanBo.setText(txaCanBo.getText()+ nv.toString()+ "\n");
                        }
                        case "Kỹ Sư" -> {
                            KySu ks = new KySu();
                            ks.MaCanBo = rs.getString("MaCanBo");
                            ks.TenCanBo = rs.getString("TenCanBo");
                            ks.NamSinh = rs.getString("NamSinh");
                            ks.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                            ks.DiaChi = rs.getString("DiaChi");
                            ks.ChucVu = rs.getString("ChucVu");
                            ks.NganhDaoTao = rs.getString("ThuocTinh");
                            txaCanBo.setText(txaCanBo.getText()+ ks.toString()+ "\n");
                        }
                        case "Công Nhân" -> {
                            CongNhan cn = new CongNhan();
                            cn.MaCanBo = rs.getString("MaCanBo");
                            cn.TenCanBo = rs.getString("TenCanBo");
                            cn.NamSinh = rs.getString("NamSinh");
                            cn.GioiTinh = Boolean.valueOf(rs.getString("GioiTinh"));
                            cn.DiaChi = rs.getString("DiaChi");
                            cn.ChucVu = rs.getString("ChucVu");
                            cn.Bac = rs.getString("ThuocTinh");
                            txaCanBo.setText(txaCanBo.getText()+ cn.toString()+ "\n");
                        }
                        default -> txaCanBo.setText("");
                    }
                    
                }
            }catch (SQLException ex) {
                Logger.getLogger(fUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
    }
 
}
