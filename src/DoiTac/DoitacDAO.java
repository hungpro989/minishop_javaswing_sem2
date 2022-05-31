/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTac;

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
public class DoitacDAO {

    Connection conn = new Connect().connectDB();

    public ArrayList<Doitac> read() {
        try {
            ArrayList<Doitac> lst = new ArrayList<>();
            String sql = "Select * from NhaPhanPhoi";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {

                int MaNhaPhanPhoi = rs.getInt("MaNhaPhanPhoi");
                String TenNhaPhanPhoi = rs.getString("TenNhaPhanPhoi");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                String Email = rs.getString("Email");
                String ChuThich = rs.getString("ChuThich");
                Doitac dt = new Doitac(MaNhaPhanPhoi, TenNhaPhanPhoi, DiaChi, SDT, Email, ChuThich);
                lst.add(dt);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(DoitacDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean create(Doitac dt) {

        try {

            String sql = "INSERT INTO NhaPhanPhoi(TenNhaPhanPhoi, DiaChi, SDT, Email, ChuThich) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, dt.getTenNhaPhanPhoi());
            pSTT.setString(2, dt.getDiaChi());
            pSTT.setString(3, dt.getSDT());
            pSTT.setString(4, dt.getEmail());

            pSTT.setString(5, dt.getChuThich());

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

    public boolean update(Doitac dt) {
        try {
            String sql = "UPDATE NhaPhanPhoi SET\n"
                    + "	TenNhaPhanPhoi = ?,\n"
                    + "	DiaChi = ?,\n"
                    + "	SDT = ?,\n"
                    + "	Email = ?,\n"
                    + "	ChuThich = ? \n"
                    + "WHERE MaNhaPhanPhoi = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, dt.getTenNhaPhanPhoi());
            pSTT.setString(2, dt.getDiaChi());
            pSTT.setString(3, dt.getSDT());
            pSTT.setString(4, dt.getEmail());

            pSTT.setString(5, dt.getChuThich());
            pSTT.setInt(6, dt.getMaNhaPhanPhoi());

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
            String sql = "DELETE FROM NhaPhanPhoi WHERE MaNhaPhanPhoi = ?";
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
