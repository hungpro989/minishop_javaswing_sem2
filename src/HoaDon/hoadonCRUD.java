/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDon;

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
public class hoadonCRUD {
     Connection conn = new Connect().connectDB();
     public ArrayList<hoadons> selectHD(){
        ArrayList<hoadons> lst = new ArrayList<>();
        try {
            
            String sql = "Select * from HoaDon";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                int MaHoaDon = rs.getInt("MaHoaDon");
                int MaKhachHang = rs.getInt("MaKhachHang");
                int MaNhanVien = rs.getInt("MaNhanVien");
                String NgayLapHoaDon = rs.getString("NgayLapHoaDon");
                float TongTien = rs.getFloat("TongTien");
                String GhiChu = rs.getString("GhiChu");
                hoadons hd = new hoadons(MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, GhiChu);
                lst.add(hd);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..."+ex);
            ex.printStackTrace();
        }
        return lst;
    }
     
     public boolean create(hoadons hd) {

        try {
            

            String sql = "INSERT INTO HoaDon(MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, GhiChu) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, hd.getMaKhachHang());
            pSTT.setInt(2, hd.getMaNhanVien());
            pSTT.setString(3, hd.getNgayLapHoaDon());
            pSTT.setFloat(4, hd.getTongTien());
            pSTT.setString(5, hd.getGhiChu());

            int row = pSTT.executeUpdate();
            System.out.println("THÊM THÀNH CÔNG");
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }
         return false;

    }
     
     public boolean update(hoadons hd) {
        try {
            

            String sql = "UPDATE HoaDon SET\n"
                    + "MaKhachHang =?,\n"
                    + "	MaNhanVien = ?,\n"
                    + "	NgayLapHoaDon = ?,\n"
                    + "	TongTien = ?,\n"
                    + "	GhiChu = ?\n"
                    + "WHERE MaHoaDon = ?";

            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, hd.getMaKhachHang());
            pSTT.setInt(2, hd.getMaNhanVien());
            pSTT.setString(3, hd.getNgayLapHoaDon());
            pSTT.setFloat(4, hd.getTongTien());
            pSTT.setString(5, hd.getGhiChu());
            pSTT.setInt(6, hd.getMaHoaDon());

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
     
     public boolean delete(int MaHoaDon) {
        try {
            
            
            String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, MaHoaDon);
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
