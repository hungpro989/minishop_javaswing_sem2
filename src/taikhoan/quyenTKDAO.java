/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

import KhachHang.LoaiKhachHang;
import connectDB.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NT Manh
 */
public class quyenTKDAO {
    Connection conn = new Connect().connectDB();
    public ArrayList<quyenTK> showQuyen(){
        ArrayList<quyenTK> lst = new ArrayList();
        try {
            String sql = "select * from Quyen";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while(rs.next()){
                int MaQuyen = rs.getInt(1);
                String TenQuyen =rs.getString(2);
                String ChuThich =rs.getString(3);
                lst.add(new quyenTK(MaQuyen, TenQuyen, ChuThich));
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị loại khách hàng "+ex);
            ex.printStackTrace();
        }
        return lst;
    }
}
