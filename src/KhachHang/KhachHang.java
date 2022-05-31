/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KhachHang;

/**
 *
 * @author Hung Dep Trai
 */
public class KhachHang {

    private int id;
    private String hoten;
    private String ngaysinh;
    private byte gioitinh;
    private String diachi;
    private String dienthoai;
    private String tenloaiKH;
    private int loaikhachhang;
    private String ghichu;

    public KhachHang() {
    }
//

    public KhachHang(int id) {
        this.id = id;
    }
//thêm kh
    public KhachHang(String hoten, String ngaysinh, byte gioitinh, String diachi, String dienthoai, int loaikhachhang, String ghichu) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.loaikhachhang = loaikhachhang;
        this.ghichu = ghichu;
    }
//sua kh
    public KhachHang(int id, String hoten, String ngaysinh, byte gioitinh, String diachi, String dienthoai, int loaikhachhang, String ghichu) {
        this.id = id;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.loaikhachhang = loaikhachhang;
        this.ghichu = ghichu;
    }
//hiển thị
    public KhachHang(int id, String hoten, String ngaysinh, byte gioitinh, String diachi, String dienthoai, String tenloaiKH, int loaikhachhang, String ghichu) {
        this.id = id;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.tenloaiKH = tenloaiKH;
        this.loaikhachhang = loaikhachhang;
        this.ghichu = ghichu;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public byte getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(byte gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public int getLoaikhachhang() {
        return loaikhachhang;
    }

    public void setLoaikhachhang(int loaikhachhang) {
        this.loaikhachhang = loaikhachhang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getTenloaiKH() {
        return tenloaiKH;
    }

    public void setTenloaiKH(String tenloaiKH) {
        this.tenloaiKH = tenloaiKH;
    }
    
    public String gioitinhnam() {
        return "Nam";
    }

    public String gioitinhnu() {
        return "Nữ";
    }

    public String loaivip() {
        return "VIP";
    }

    public String loaithuong() {
        return "Thường";
    }
    public String loaisinhvien(){
        return "Sinh Viên";
    }
}
