/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChiTietHoaDon;


import connectDB.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NT Manh
 */
public class CThoadonDAO {

    Connection conn = new Connect().connectDB();

    public ArrayList<ChiTietHoaDon> selectChiTietHD() {
        ArrayList<ChiTietHoaDon> lst = new ArrayList<>();
        try {

            String sql = "Select * from ChiTietHoaDon";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                int MaCTHD = rs.getInt("MaCTHD");
                int MaHoaDon = rs.getInt("MaHoaDon");
                int MaSanPham = rs.getInt("MaSanPham");
                int SoLuong = rs.getInt("SoLuong");
                float TongTien = rs.getFloat("TongTien");
                String GhiChu = rs.getString("GhiChu");
                ChiTietHoaDon CTHD = new ChiTietHoaDon(MaCTHD, SoLuong, TongTien, GhiChu, MaHoaDon, MaSanPham);
                lst.add(CTHD);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..." + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<ChiTietHoaDon> slHD(int id) {

        try {
            ArrayList<ChiTietHoaDon> lst = new ArrayList<>();

            String sql = "Select * from ChiTietHoaDon Where MaHoaDon = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, id);
            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {
                int MaCTHD = rs.getInt("MaCTHD");
                int MaHoaDon = rs.getInt("MaHoaDon");
                int MaSanPham = rs.getInt("MaSanPham");
                int SoLuong = rs.getInt("SoLuong");
                float TongTien = rs.getFloat("TongTien");
                String GhiChu = rs.getString("GhiChu");
                ChiTietHoaDon CTHD = new ChiTietHoaDon(MaCTHD, SoLuong, TongTien, GhiChu, MaHoaDon, MaSanPham);
                lst.add(CTHD);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..." + ex);
            ex.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietHoaDon> tongtien(int iss) {

        try {
            ArrayList<ChiTietHoaDon> lst = new ArrayList<>();

            String sql = "Select sum(TongTien) as 'TongTien' from ChiTietHoaDon Where MaHoaDon = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, iss);
            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {

                float TongTien = rs.getFloat("TongTien");

                ChiTietHoaDon CTHD = new ChiTietHoaDon(TongTien);
                lst.add(CTHD);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..." + ex);
            ex.printStackTrace();
        }
        return null;

    }

    public boolean taoCT(ChiTietHoaDon CThd) {

        try {
            Connection conn = new Connect().connectDB();

            String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon, MaSanPham, SoLuong, TongTien, GhiChu) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, CThd.getMaHoaDon());
            pSTT.setInt(2, CThd.getMaSanPham());
            pSTT.setInt(3, CThd.getSoLuong());
            pSTT.setFloat(4, CThd.getTongTien());
            pSTT.setString(5, CThd.getGhiChu());

            int row = pSTT.executeUpdate();
            System.out.println("THÊM THÀNH CÔNG");
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }
        return false;

    }

    public boolean update(ChiTietHoaDon CThd) {
        try {
            Connection conn = new Connect().connectDB();

            String sql = "UPDATE ChiTietHoaDon SET\n"
                    + "MaSanPham =?,\n"
                    + "	SoLuong = ?,\n"
                    + "	TongTien = ?,\n"
                    + "	GhiChu = ?\n"
                    + "WHERE MaCTHD = ?";

            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, CThd.getMaSanPham());
            pSTT.setInt(2, CThd.getSoLuong());
            pSTT.setFloat(3, CThd.getTongTien());
            pSTT.setString(4, CThd.getGhiChu());

            pSTT.setInt(5, CThd.getMaCTHD());

            int row = pSTT.executeUpdate();

            if (row > 0) {
                System.out.println("CẬP NHẬT thành công");
                return true;
            } else {
                System.out.println("Có lỗi khi CẬP NHẬT");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
        }
        return false;
    }

    public boolean delete(int MaCTHD) {
        try {
            Connection conn = new Connect().connectDB();

            String sql = "DELETE FROM ChiTietHoaDon WHERE MaCTHD = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, MaCTHD);
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
