/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoaiSanPham;

/**
 *
 * @author Phong
 */
public class LoaiSanPham {
     private int MaLoaiSanPham;
    private String TenLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int MaLoaiSanPham, String TenLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public LoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public int getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    

    @Override
    public String toString() {
        return this.TenLoaiSanPham;
    }
}
