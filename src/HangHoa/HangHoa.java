/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangHoa;

/**
 *
 * @author Phong
 */
public class HangHoa {
    private int MaSanPham;
    private String TenSanPham;
    private int LoaiSanPham;
    private int HangSanXuat;
    private float GiaNhap;
    private float GiaBan;
    private int TonKho;
    private boolean TrangThai;
//    private String Image;
    private String ChuThich;
    private String TenLoaiSanPham;
    private String TenHangSanXuat;
    private int soluong;
    public HangHoa() {
    }

    public HangHoa(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public HangHoa(String TenSanPham, int soluong) {
        this.TenSanPham = TenSanPham;
        this.soluong = soluong;
    }

    public HangHoa(int MaSanPham, String TenSanPham) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
    }
    
    public HangHoa(String TenSanPham, int LoaiSanPham, int HangSanXuat, float GiaNhap, float GiaBan, int TonKho, boolean TrangThai, String ChuThich) {
        this.TenSanPham = TenSanPham;
        this.LoaiSanPham = LoaiSanPham;
        this.HangSanXuat = HangSanXuat;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TonKho = TonKho;
        this.TrangThai = TrangThai;
        this.ChuThich = ChuThich;
    }
//hien thi bang select_hanghoa

    public HangHoa(int MaSanPham, String TenSanPham, int LoaiSanPham, int HangSanXuat, float GiaNhap, float GiaBan, int TonKho, boolean TrangThai, String ChuThich, String TenLoaiSanPham, String TenHangSanXuat) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.LoaiSanPham = LoaiSanPham;
        this.HangSanXuat = HangSanXuat;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TonKho = TonKho;
        this.TrangThai = TrangThai;
        this.ChuThich = ChuThich;
        this.TenLoaiSanPham = TenLoaiSanPham;
        this.TenHangSanXuat = TenHangSanXuat;
    }
    
    public HangHoa(int MaSanPham, String TenSanPham, int LoaiSanPham, int HangSanXuat, float GiaNhap, float GiaBan, int TonKho, boolean TrangThai, String ChuThich) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.LoaiSanPham = LoaiSanPham;
        this.HangSanXuat = HangSanXuat;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TonKho = TonKho;
        this.TrangThai = TrangThai;
        this.ChuThich = ChuThich;
    }

    public HangHoa(int MaSanPham, String TenSanPham, float GiaNhap, float GiaBan, int TonKho, boolean TrangThai, String ChuThich) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TonKho = TonKho;
        this.TrangThai = TrangThai;
        this.ChuThich = ChuThich;
    }
    
    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(int LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }

    public int getHangSanXuat() {
        return HangSanXuat;
    }

    public void setHangSanXuat(int HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public String getTenHangSanXuat() {
        return TenHangSanXuat;
    }

    public void setTenHangSanXuat(String TenHangSanXuat) {
        this.TenHangSanXuat = TenHangSanXuat;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    public String statusEnable() {
        return "Hiện";
    }
    
    public String statusDisable() {
        return "Ẩn";
    }

  

    
}
