/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


/**
 *
 * @author Hung Dep Trai
 */

public class ChiTietHoaDon  {
    private int maCTHD;
    private int soLuong;
    private float tongTien;
    private String ghiChu;
    private Date ngayLapCTHD;
    private HoaDon hoaDon;
    private int sanPham;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int soLuong) {
        this.soLuong = soLuong;
    }

    public ChiTietHoaDon(int maCTHD, int sanPham) {
        this.maCTHD = maCTHD;
        this.sanPham = sanPham;
    }   
    
    public ChiTietHoaDon(int maCTHD, int soLuong, float tongTien) {
        this.maCTHD = maCTHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDon(int maCTHD, int soLuong, float tongTien, String ghiChu, Date ngayLapCTHD, HoaDon hoaDon, int sanPham) {
        this.maCTHD = maCTHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.ngayLapCTHD = ngayLapCTHD;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
    }
    
    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
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

    public Date getNgayLapCTHD() {
        return ngayLapCTHD;
    }

    public void setNgayLapCTHD(Date ngayLapCTHD) {
        this.ngayLapCTHD = ngayLapCTHD;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSanPham() {
        return sanPham;
    }



    
}
