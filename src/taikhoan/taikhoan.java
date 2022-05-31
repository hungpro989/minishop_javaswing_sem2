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
public class taikhoan {
    int ID;
    int MaNhanVien;
    String TenDangNhap;
    String Password;
    int Quyen;
    String ChuThich;

    public taikhoan() {
    }

    public taikhoan(int ID, int MaNhanVien, String TenDangNhap, String Password, int Quyen, String ChuThich) {
        this.ID = ID;
        this.MaNhanVien = MaNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.Password = Password;
        this.Quyen = Quyen;
        this.ChuThich = ChuThich;
    }

    public taikhoan(int MaNhanVien, String TenDangNhap, String Password, int Quyen, String ChuThich) {
        this.MaNhanVien = MaNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.Password = Password;
        this.Quyen = Quyen;
        this.ChuThich = ChuThich;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }
    
}
