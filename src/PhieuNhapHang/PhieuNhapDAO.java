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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Phong
 */
public class PhieuNhapDAO {

Connection conn = new Connect().connectDB();
    public ArrayList<PhieuNhap> read() {
        try {
            ArrayList<PhieuNhap> lst = new ArrayList<>();

            String sql = "Select * from PhieuNhap";

            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()) {
                int MaPhieuNhap = rs.getInt("MaPhieuNhap");
                int MaNhanVien = rs.getInt("MaNhanVien");
                int MaNhaPhanPhoi = rs.getInt("MaNhaPhanPhoi");
                String NgayNhap = rs.getString("NgayNhap");
                float TongTien = rs.getFloat("TongTien");
                String ChuThich = rs.getString("ChuThich");
                PhieuNhap ph = new PhieuNhap(MaPhieuNhap, MaNhanVien, MaNhaPhanPhoi, TongTien, NgayNhap, ChuThich);
                lst.add(ph);

            }

            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
            return null;
        }

    }

    public void create(PhieuNhap ph) {

        try {

            String sql = "INSERT INTO PhieuNhap(MaNhanVien, MaNhaPhanPhoi, NgayNhap, TongTien, ChuThich) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);

            pSTT.setInt(1, ph.getMaNhanVien());
            pSTT.setInt(2, ph.getMaNhaPhanPhoi());
            pSTT.setString(3, ph.getNgayNhap());
            pSTT.setFloat(4, ph.getTongTien());

            pSTT.setString(5, ph.getChuThich());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("THÊM THÀNH CÔNG");
            } else {
                System.out.println("CÓ LỖI KHI THÊM");
            }

        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }

    }

    public void update(PhieuNhap ph) {
        try {

            String sql = "UPDATE PhieuNhap SET\n"
                    + "	MaNhanVien = ?,\n"
                    + "	MaNhaPhanPhoi = ?,\n"
                    + "	NgayNhap = ?,\n"
                    + "	TongTien = ?,\n"
                    + "	ChuThich = ?\n"
                    + "WHERE MaPhieuNhap = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, ph.getMaNhanVien());
            pSTT.setInt(2, ph.getMaNhaPhanPhoi());
            pSTT.setString(3, ph.getNgayNhap());
            pSTT.setFloat(4, ph.getTongTien());

            pSTT.setString(5, ph.getChuThich());
            pSTT.setInt(6, ph.getMaPhieuNhap());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("CẬP NHẬT thành công");
            } else {
                System.out.println("Có lỗi khi CẬP NHẬT");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
        }
    }

    public void delete(int id) {
        try {

            String sql = "DELETE FROM PhieuNhap WHERE MaPhieuNhap = ?";
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
    }
}
