/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoaiSanPham;

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
public class LoaiSanPhamDAO {
    Connection conn = new Connect().connectDB();
    public ArrayList<LoaiSanPham> read() {
        try {
            ArrayList<LoaiSanPham> lst = new ArrayList<>();
            String sql = "Select * from LoaiSanPham ";
            
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()) {
                int MaLoaiSanPham = rs.getInt("MaLoaiSanPham");
                String TenLoaiSanPham = rs.getString("TenLoaiSanPham");
                LoaiSanPham lo = new LoaiSanPham(MaLoaiSanPham, TenLoaiSanPham);
                lst.add(lo);

            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPham.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return null;

    }

    public void create(LoaiSanPham lsp) {

        try {
            String sql = "INSERT INTO LoaiSanPham VALUES(?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, lsp.getTenLoaiSanPham());

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

    public void update(LoaiSanPham lsp) {
        try {
            String sql = "UPDATE LoaiSanPham SET\n"
                    + "	TenLoaiSanPham = ?,\n"
                    + "WHERE MaLoaiSanPham = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, lsp.getTenLoaiSanPham());

            pSTT.setInt(2, lsp.getMaLoaiSanPham());

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
            String sql = "DELETE FROM LoaiSanPham WHERE MaLoaiSanPham = ?";
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
