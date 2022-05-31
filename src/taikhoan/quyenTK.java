/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

/**
 *
 * @author NT Manh
 */
public class quyenTK {
    int MaQuyen;
    String TenQuyen;
    String ChuThich;

    public quyenTK() {
    }

    public quyenTK(int MaQuyen, String TenQuyen, String ChuThich) {
        this.MaQuyen = MaQuyen;
        this.TenQuyen = TenQuyen;
        this.ChuThich = ChuThich;
    }

    public quyenTK(String TenQuyen, String ChuThich) {
        this.TenQuyen = TenQuyen;
        this.ChuThich = ChuThich;
    }

    public int getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(int MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    @Override
    public String toString() {
        return this.TenQuyen;
    }
    
}
