/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhieuNhapHang;

import connectDB.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phong
 */
public class PhieuNhapChiTietDAO {
    Connection conn = new Connect().connectDB();

    public ArrayList<PhieuNhapChiTiet> read(int Ma) {
        try {
            ArrayList<PhieuNhapChiTiet> lst = new ArrayList<>();

            String sql = "Select * from ChiTietPhieuNhap Where MaPhieuNhap = ? ";

            PreparedStatement pSTT = conn.prepareStatement(sql);

            pSTT.setInt(1, Ma);
            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {
                int MaCTPN = rs.getInt("MaCTPN");
                int MaPhieuNhap = rs.getInt("MaPhieuNhap");
                int MaSanPham = rs.getInt("MaSanPham");
                int SoLuong = rs.getInt("SoLuong");
                float TongTien = rs.getFloat("TongTien");
                String ChuThich = rs.getString("ChuThich");
                PhieuNhapChiTiet phct = new PhieuNhapChiTiet(MaCTPN, MaPhieuNhap, MaSanPham, SoLuong, TongTien, ChuThich);
                lst.add(phct);

            }

            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
            return null;
        }

    }

    public ArrayList<PhieuNhapChiTiet> readTien(int Ma) {
        try {
            ArrayList<PhieuNhapChiTiet> lst = new ArrayList<>();

            String sql = "Select Sum(TongTien) AS 'TongTienXXX' from ChiTietPhieuNhap Where MaPhieuNhap = ? ";

            PreparedStatement pSTT = conn.prepareStatement(sql);

            pSTT.setInt(1, Ma);
            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {

                float TongTien = rs.getFloat("TongTienXXX");
                PhieuNhapChiTiet phct = new PhieuNhapChiTiet(TongTien);
                lst.add(phct);

            }

            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
            return null;
        }

    }

    public boolean create(PhieuNhapChiTiet phct) {

        try {

            String sql = "INSERT INTO ChiTietPhieuNhap(MaPhieuNhap, MaSanPham, SoLuong, TongTien, ChuThich) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);

            pSTT.setInt(1, phct.getMaPhieuNhap());
            pSTT.setInt(2, phct.getMaSanPham());
            pSTT.setInt(3, phct.getSoLuong());

            pSTT.setFloat(4, phct.getTongTien());

            pSTT.setString(5, phct.getChuThich());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("THÊM THÀNH CÔNG");
            } else {
                System.out.println("CÓ LỖI KHI THÊM");
            }

        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }
        return true;

    }

    public boolean update(PhieuNhapChiTiet phct) {
        try {

            String sql = "UPDATE ChiTietPhieuNhap SET\n"
                    + "	MaPhieuNhap = ?,\n"
                    + "	MaSanPham = ?,\n"
                    + "	SoLuong = ?,\n"
                    + "	TongTien = ?,\n"
                    + "	ChuThich = ?\n"
                    + "WHERE MaCTPN = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, phct.getMaPhieuNhap());
            pSTT.setInt(2, phct.getMaSanPham());
            pSTT.setInt(3, phct.getSoLuong());

            pSTT.setFloat(4, phct.getTongTien());

            pSTT.setString(5, phct.getChuThich());
            pSTT.setInt(6, phct.getMaCTPN());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("CẬP NHẬT thành công");
            } else {
                System.out.println("Có lỗi khi CẬP NHẬT");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
        }
        return false;
    }

    public boolean delete(int id) {
        try {

            String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaCTPN = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, id);
            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("XÓA thành công");
            } else {
                System.out.println("Có lỗi khi XÓA");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
        }
        return false;
    }

}
