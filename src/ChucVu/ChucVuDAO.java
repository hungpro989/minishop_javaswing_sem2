/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucVu;

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
public class ChucVuDAO {
    Connection conn = new Connect().connectDB();
    public ArrayList<ChucVu> read() {
        try {
            ArrayList<ChucVu> lst = new ArrayList<>();
            String sql = "Select * from ChucVu ";

            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()) {
                int MaChucVu = rs.getInt("MaChucVu");
                String TenChucVu = rs.getString("TenChucVu");
                String GhiChu = rs.getString("GhiChu");
              ChucVu cv = new ChucVu(MaChucVu, TenChucVu, GhiChu);
              lst.add(cv);

            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(ChucVu.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return null;

    }

    public void create(ChucVu cv) {

        try {

            String sql = "INSERT INTO ChucVu(TenChucVu,GhiChu) VALUES(?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, cv.getTenChucVu());
            pSTT.setString(2, cv.getGhiChu());

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

    public void update(ChucVu cv) {
        try {

            String sql = "UPDATE ChucVu SET\n"
                    + "	TenChucVu = ?,\n"
                    + "	GhiChu = ?\n"
                    + "WHERE MaChucVu = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, cv.getTenChucVu());
            pSTT.setString(2, cv.getGhiChu());


            pSTT.setInt(3, cv.getMaChucVu());

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
            String sql = "DELETE FROM ChucVu WHERE MaChucVu = ?";
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
