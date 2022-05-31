/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChiTietHoaDon;

/**
 *
 * @author Hung Dep Trai
 */
public class ChiTietHoaDon {
    private int MaCTHD;
    private int soLuong;
    private float tongTien;
    private String ghiChu;
    private String ngaylapCTHD;
    private int MaHoaDon;
    private int MaSanPham;

    public ChiTietHoaDon(int MaCTHD, int soLuong, float tongTien, String ghiChu, String ngaylapCTHD, int MaHoaDon, int MaSanPham) {
        this.MaCTHD = MaCTHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngaylapCTHD = ngaylapCTHD;
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(float tongTien) {
        this.tongTien = tongTien;
    }

    public ChiTietHoaDon(int MaCTHD, int soLuong, float tongTien, String ghiChu, int MaHoaDon, int MaSanPham) {
        this.MaCTHD = MaCTHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
    }

    public ChiTietHoaDon(int soLuong, float tongTien, String ghiChu, int MaHoaDon, int MaSanPham) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
    }
    
    public ChiTietHoaDon(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public ChiTietHoaDon(int MaCTHD, int MaSanPham) {
        this.MaCTHD = MaCTHD;
        this.MaSanPham = MaSanPham;
    }

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgaylapCTHD() {
        return ngaylapCTHD;
    }

    public void setNgaylapCTHD(String ngaylapCTHD) {
        this.ngaylapCTHD = ngaylapCTHD;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }
    
}
