/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KhachHang;

import connectDB.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hung Dep Trai
 */
public class LoaiKhachHangCRUD {
    Connection conn = new Connect().connectDB();
    public ArrayList<LoaiKhachHang> select_LoaiKH(){
        ArrayList<LoaiKhachHang> lst = new ArrayList();
        try {
            String sql = "select * from LoaiKhachHang";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String tenloaiKH =rs.getString(2);
                String ghichu =rs.getString(3);
                lst.add(new LoaiKhachHang(id, tenloaiKH, ghichu));
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị loại khách hàng "+ex);
            ex.printStackTrace();
        }
        return lst;
    }
}
