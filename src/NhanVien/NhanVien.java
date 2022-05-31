/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

/**
 *
 * @author Phong
 */
public class NhanVien {

    private int MaNhanVien;
    private String TenNhanVien;
    private String NgaySinh;
    private boolean GioiTinh;
    private String NgayVaoLam;
    private int ChucVu;
    private String DiaChi;
    private String SDT;
    private String GhiChu;
    private String TenChucVu;
    public NhanVien() {
    }

    public NhanVien(int MaNhanVien, String TenNhanVien, String NgaySinh, boolean GioiTinh, String NgayVaoLam, int ChucVu, String DiaChi, String SDT, String GhiChu, String TenChucVu) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.NgayVaoLam = NgayVaoLam;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GhiChu = GhiChu;
        this.TenChucVu = TenChucVu;
    }
    
    public NhanVien(String TenNhanVien, String NgaySinh, boolean GioiTinh, String NgayVaoLam, int ChucVu, String DiaChi, String SDT, String GhiChu) {
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.NgayVaoLam = NgayVaoLam;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GhiChu = GhiChu;
    }

    public NhanVien(int MaNhanVien, String TenNhanVien, String NgaySinh, boolean GioiTinh, String NgayVaoLam, int ChucVu, String DiaChi, String SDT, String GhiChu) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.NgayVaoLam = NgayVaoLam;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GhiChu = GhiChu;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
    
    @Override
    public String toString() {
       return this.TenNhanVien;
    }
    public String gioitinhnam() {
        return "Nam";
    }

    public String gioitinhnu() {
        return "Nữ";
    }
}
