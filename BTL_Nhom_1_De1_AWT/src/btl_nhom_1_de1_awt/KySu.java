/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_nhom_1_de1_awt;

/**
 *
 * @author ducan
 */
public class KySu extends CanBo{
    String NganhDaoTao;
     public KySu() {
    }
 public KySu( String MaCanBo,String TenCanBo,String NamSinh,boolean GioiTinh,String DiaChi,String ChucVu,String NganhDaoTao){
     super(MaCanBo, TenCanBo, NamSinh, GioiTinh, DiaChi, ChucVu);
     this.MaCanBo = MaCanBo;
     this.TenCanBo = TenCanBo;
     this.NamSinh = NamSinh;
     this.GioiTinh = GioiTinh;
     this.DiaChi = DiaChi;
     this.ChucVu = ChucVu;
     this.NganhDaoTao = NganhDaoTao;
 }
 @Override
    public String toString() {
        return super.toString() + String.format("%-26s",NganhDaoTao);
    }
}
