/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDon;

/**
 *
 * @author NT Manh
 */
public class hoadons {
    int MaHoaDon;
    int MaKhachHang;
    int MaNhanVien;
    String NgayLapHoaDon;
    float TongTien;
    String GhiChu;

    public hoadons() {
    }

    public hoadons(int MaHoaDon, int MaKhachHang, int MaNhanVien, String NgayLapHoaDon, float TongTien, String GhiChu) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.NgayLapHoaDon = NgayLapHoaDon;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public hoadons(int MaKhachHang, int MaNhanVien, String NgayLapHoaDon, float TongTien, String GhiChu) {
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.NgayLapHoaDon = NgayLapHoaDon;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayLapHoaDon() {
        return NgayLapHoaDon;
    }

    public void setNgayLapHoaDon(String NgayLapHoaDon) {
        this.NgayLapHoaDon = NgayLapHoaDon;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
