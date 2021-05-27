/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

import java.util.Date;

/**
 *
 * @author ducan
 */
public class CanBo {

    String MaCanBo;
    String TenCanBo;
    String NamSinh;
    boolean GioiTinh;
    String DiaChi;
    String ChucVu;
    public CanBo(String MaCanBo, String TenCanBo, String NamSinh, boolean GioiTinh, String DiaChi, String ChucVu) {
        this.MaCanBo = MaCanBo;
        this.TenCanBo = TenCanBo;
        this.NamSinh = NamSinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.ChucVu = ChucVu;
    }

    CanBo() {
       
    }

    @Override
    public String toString() {
        return String.format("%-26s%-26s%-26s%-26B%-26s%-26s",MaCanBo,TenCanBo,NamSinh,GioiTinh,DiaChi,ChucVu);
    }
    
   
}
