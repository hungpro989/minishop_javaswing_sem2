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
public class LoaiKhachHang {
    private int id;
    private String tenloaiKH;
    private String ghichu;

    public LoaiKhachHang() {
    }

    public LoaiKhachHang(int id, String tenloaiKH, String ghichu) {
        this.id = id;
        this.tenloaiKH = tenloaiKH;
        this.ghichu = ghichu;
    }

    public LoaiKhachHang(String tenloaiKH, String ghichu) {
        this.tenloaiKH = tenloaiKH;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloaiKH() {
        return tenloaiKH;
    }

    public void setTenloaiKH(String tenloaiKH) {
        this.tenloaiKH = tenloaiKH;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    @Override
    public String toString() {
        return this.tenloaiKH;
    }
}
