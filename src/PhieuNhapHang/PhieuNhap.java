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
public class PhieuNhap {
    private int  MaPhieuNhap;
    private int MaNhanVien;
    private int MaNhaPhanPhoi;
    private float TongTien;
    private String NgayNhap;
    private String ChuThich;

    public PhieuNhap() {
    }

    public PhieuNhap(int MaNhanVien, int MaNhaPhanPhoi, float TongTien, String NgayNhap, String ChuThich) {
        this.MaNhanVien = MaNhanVien;
        this.MaNhaPhanPhoi = MaNhaPhanPhoi;
        this.TongTien = TongTien;
        this.NgayNhap = NgayNhap;
        this.ChuThich = ChuThich;
    }

    public PhieuNhap(int MaPhieuNhap, int MaNhanVien, int MaNhaPhanPhoi, float TongTien, String NgayNhap, String ChuThich) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNhanVien = MaNhanVien;
        this.MaNhaPhanPhoi = MaNhaPhanPhoi;
        this.TongTien = TongTien;
        this.NgayNhap = NgayNhap;
        this.ChuThich = ChuThich;
    }

    public int getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(int MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaNhaPhanPhoi() {
        return MaNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(int MaNhaPhanPhoi) {
        this.MaNhaPhanPhoi = MaNhaPhanPhoi;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }
    
}
