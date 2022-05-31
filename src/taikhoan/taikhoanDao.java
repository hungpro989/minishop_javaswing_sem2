/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

import HoaDon.hoadon;
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
public class taikhoanDao {
    Connection conn = new Connect().connectDB();
     public ArrayList<taikhoan> showTK(){
        ArrayList<taikhoan> lst = new ArrayList<>();
        try {
            
            String sql = "Select * from Users";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                int ID = rs.getInt("ID");
                int MaNhanVien = rs.getInt("MaNhanVien");
                String TenDangNhap = rs.getString("TenDangNhap");
                String Password = rs.getString("Password");
                int Quyen = rs.getInt("Quyen");
                String ChuThich = rs.getString("ChuThich");
                taikhoan TK = new taikhoan(ID, MaNhanVien, TenDangNhap, Password, Quyen, ChuThich);
                lst.add(TK);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..."+ex);
            ex.printStackTrace();
        }
        return lst;
    }
     
     public boolean InsertTK(taikhoan tk) {

        try {
            Connection conn = new Connect().connectDB();

            String sql = "INSERT INTO Users(MaNhanVien, TenDangNhap, Password, Quyen, ChuThich) VALUES(?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, tk.getMaNhanVien());
            pSTT.setString(2, tk.getTenDangNhap());
            pSTT.setString(3, tk.getPassword());
            pSTT.setInt(4, tk.getQuyen());
            pSTT.setString(5, tk.getChuThich());

            int row = pSTT.executeUpdate();
            System.out.println("THÊM THÀNH CÔNG");
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }
         return false;

    }
     
     public boolean CapNhatTK(taikhoan tk) {
        try {
            Connection conn = new Connect().connectDB();

            String sql = "UPDATE Users SET\n"
                    + "MaNhanVien =?,\n"
                    + "	TenDangNhap = ?,\n"
                    + "	Password = ?,\n"
                    + "	Quyen = ?,\n"
                    + "	ChuThich = ?\n"
                    + "WHERE ID = ?";

            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, tk.getMaNhanVien());
            pSTT.setString(2, tk.getTenDangNhap());
            pSTT.setString(3, tk.getPassword());
            pSTT.setInt(4, tk.getQuyen());
            pSTT.setString(5, tk.getChuThich());
            pSTT.setInt(6, tk.getID());

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
     
     public boolean XoaTK(int ID) {
        try {
            Connection conn = new Connect().connectDB();
            
            String sql = "DELETE FROM Users WHERE ID = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, ID);
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
