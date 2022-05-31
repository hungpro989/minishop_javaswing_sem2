/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KhachHang;

import connectDB.Connect;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hung Dep Trai
 */
public class KhachHangCRUD {
    Connection conn = new Connect().connectDB();
    public ArrayList<KhachHang> selectKH(){
        ArrayList<KhachHang> lst = new ArrayList<>();
        try {
            
            String sql = "{CALL select_KhachHang}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String hoten = rs.getString(2);
                String ngaysinh = rs.getString(3);
                byte gioitinh = rs.getByte(4);
                String diachi = rs.getString(5);
                String sdt = rs.getString(6);
                String tenloaiKH = rs.getString(7);
                int loaikhachhang=rs.getInt(8);
                String ghichu = rs.getString(9);
                KhachHang kh = new KhachHang(id, hoten, ngaysinh, gioitinh, diachi, sdt,tenloaiKH, loaikhachhang, ghichu);
                lst.add(kh);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu..."+ex);
            ex.printStackTrace();
        }
        return lst;
    }
    public boolean insert_KhachHang(KhachHang kh){
        try {
            String sql = "{CALL insert_KhachHang(?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, kh.getHoten());
            cs.setString(2, kh.getNgaysinh());
            cs.setByte(3, kh.getGioitinh());
            cs.setString(4, kh.getDiachi());
            cs.setString(5, kh.getDienthoai());
            cs.setInt(6, kh.getLoaikhachhang());
            cs.setString(7, kh.getGhichu());
            if(cs.executeUpdate()>0){
                System.out.println("Thêm thành công");
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            System.err.println("Lỗi thêm khách hàng vào csdl " + ex);
            ex.printStackTrace();
        }
        return false;
    }
    public boolean update_KhachHang(KhachHang kh){
        try {
            String sql = "{CALL update_KhachHang(?,?,?,?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, kh.getHoten());
            cs.setString(2, kh.getNgaysinh());
            cs.setByte(3, kh.getGioitinh());
            cs.setString(4, kh.getDiachi());
            cs.setString(5, kh.getDienthoai());
            cs.setInt(6, kh.getLoaikhachhang());
            cs.setString(7, kh.getGhichu());
            cs.setInt(8, kh.getId());
            if(cs.executeUpdate()>0){
                System.out.println("Sửa thành công");
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi sửa khách hàng trong csdl " + ex);
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean del_KhachHang(KhachHang kh){
        try {
            String sql = "{CALL del_KhachHang(?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, kh.getId());
            if(cs.executeUpdate()>0){
                System.out.println("Xoá thành công");
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi xoá khách hàng trong csdl"+ex);
            ex.printStackTrace();
        }
        return false;
    }
}
