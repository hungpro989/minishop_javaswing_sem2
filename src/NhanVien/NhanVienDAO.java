/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import connectDB.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong
 */
public class NhanVienDAO {

    Connection conn = new Connect().connectDB();

    public ArrayList<NhanVien> read() {
        try {
            ArrayList<NhanVien> lst = new ArrayList<>();
            String sql = "{CALL select_nhanvien}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                int MaNhanVien = rs.getInt("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                String NgaySinh = rs.getString("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String NgayVaoLam = rs.getString("NgayVaoLam");
                String TenChucVu = rs.getString("TenChucVu");
                int ChucVu = rs.getInt("ChucVu");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SoDT");
                String GhiChu = rs.getString("GhiChu");
                NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, GhiChu, TenChucVu);
                lst.add(nv);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return null;

    }

    public boolean create(NhanVien nv) {
        try {
            String sql = "INSERT INTO NhanVien(TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi,SoDT, GhiChu) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, nv.getTenNhanVien());
            pSTT.setString(2, nv.getNgaySinh());
            pSTT.setBoolean(3, nv.isGioiTinh());
            pSTT.setString(4, nv.getNgayVaoLam());
            pSTT.setInt(5, nv.getChucVu());
            pSTT.setString(6, nv.getDiaChi());
            pSTT.setString(7, nv.getSDT());
            pSTT.setString(8, nv.getGhiChu());
            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("THÊM NV THÀNH CÔNG");
            } else {
                System.out.println("CÓ LỖI KHI THÊM");
            }
        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    public boolean update(NhanVien nv) {
        try {
            String sql = "UPDATE NhanVien SET\n"
                    + "	TenNhanVien = ?,\n"
                    + "	NgaySinh = ?,\n"
                    + "	GioiTinh = ?,\n"
                    + "	NgayVaoLam = ?,\n"
                    + "	ChucVu = ? ,\n"
                    + "	DiaChi = ?,\n"
                    + "	SoDT = ?,\n"
                    + "	GhiChu = ?\n"
                    + "WHERE MaNhanVien = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, nv.getTenNhanVien());
            pSTT.setString(2, nv.getNgaySinh());
            pSTT.setBoolean(3, nv.isGioiTinh());
            pSTT.setString(4, nv.getNgayVaoLam());
            pSTT.setInt(5, nv.getChucVu());
            pSTT.setString(6, nv.getDiaChi());
            pSTT.setString(7, nv.getSDT());
            pSTT.setString(8, nv.getGhiChu());
            pSTT.setInt(9, nv.getMaNhanVien());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("CẬP NHẬT thành công");
            } else {
                System.out.println("Có lỗi khi CẬP NHẬT");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
        }
        return true;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
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
        return true;
    }
}
