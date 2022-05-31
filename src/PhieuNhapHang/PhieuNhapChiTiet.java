/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhieuNhapHang;

/**
 *
 * @author Phong
 */
public class PhieuNhapChiTiet {
    private int MaCTPN;
    private int MaPhieuNhap;
    private int MaSanPham;
    private int SoLuong;
    private float TongTien;
    private String ChuThich;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(int MaPhieuNhap, int MaSanPham, int SoLuong, float TongTien, String ChuThich) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.ChuThich = ChuThich;
    }

    public PhieuNhapChiTiet(int MaCTPN, int MaPhieuNhap, int MaSanPham, int SoLuong, float TongTien, String ChuThich) {
        this.MaCTPN = MaCTPN;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.ChuThich = ChuThich;
    }

    public int getMaCTPN() {
        return MaCTPN;
    }

    public void setMaCTPN(int MaCTPN) {
        this.MaCTPN = MaCTPN;
    }

    public int getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(int MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    public PhieuNhapChiTiet(float TongTien) {
        this.TongTien = TongTien;
    }
    
}
