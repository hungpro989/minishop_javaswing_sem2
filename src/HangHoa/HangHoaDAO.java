/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangHoa;

import connectDB.Connect;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import java.awt.List;
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
public class HangHoaDAO {
        Connection conn = new Connect().connectDB();
    public ArrayList<HangHoa> read() {
        try {
            ArrayList<HangHoa> lst = new ArrayList<>();
            String sql = "{CALL select_HangHoa}";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                int MaSanPham = rs.getInt("MaSanPham");
                String TenSanPham = rs.getString("TenSanPham");
                int LoaiSanPham = rs.getInt("LoaiSanPham");
                int HangSanXuat = rs.getInt("HangSanXuat");
                float GiaNhap = rs.getFloat("GiaNhap");
                float GiaBan = rs.getFloat("GiaBan");
                int TonKho = rs.getInt("TonKho");
                boolean TrangThai = rs.getBoolean("TrangThai");
//                String Image = rs.getString("Image");
                String ChuThich = rs.getString("ChuThich");
                String TenLoaiSanPham=rs.getString("TenLoaiSanPham");
                String TenHangSanXuat=rs.getString("TenHangSanXuat");
                HangHoa ha = new HangHoa(MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, TonKho, TrangThai, ChuThich,TenLoaiSanPham,TenHangSanXuat);
                lst.add(ha);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
            return null;
        }
    }
    public boolean create(HangHoa hh) {
        try {
            String sql = "INSERT INTO SanPham(TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, TonKho,TrangThai, ChuThich) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, hh.getTenSanPham());
            pSTT.setInt(2, hh.getLoaiSanPham());
            pSTT.setInt(3, hh.getHangSanXuat());
            pSTT.setFloat(4, hh.getGiaNhap());
            pSTT.setFloat(5, hh.getGiaBan());
            pSTT.setInt(6, hh.getTonKho());
            pSTT.setBoolean(7, hh.isTrangThai());
            pSTT.setString(8, hh.getChuThich());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("THÊM THÀNH CÔNG");
            } else {
                System.out.println("CÓ LỖI KHI THÊM");
            }

        } catch (SQLException ex) {
            System.out.println("lỗi thêm  mới " + ex.getMessage());
        }
        return false;
    }

    public boolean update(HangHoa hh) {
        try {
            String sql = "UPDATE SanPham SET\n"
                    + "	TenSanPham = ?,\n"
                    + "	LoaiSanPham = ?,\n"
                    + "	HangSanXuat = ?,\n"
                    + "	GiaNhap = ?,\n"
                    + "	GiaBan = ? ,\n"
                    + "	TonKho = ?,\n"
                    + "	TrangThai = ?,\n"
                    + "	ChuThich = ?\n"
                    + "WHERE MaSanPham = ?";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setString(1, hh.getTenSanPham());
            pSTT.setInt(2, hh.getLoaiSanPham());
            pSTT.setInt(3, hh.getHangSanXuat());
            pSTT.setFloat(4, hh.getGiaNhap());
            pSTT.setFloat(5, hh.getGiaBan());
            pSTT.setInt(6, hh.getTonKho());
            pSTT.setBoolean(7, hh.isTrangThai());
            pSTT.setString(8, hh.getChuThich());
            pSTT.setInt(9, hh.getMaSanPham());

            int row = pSTT.executeUpdate();
            if (row > 0) {
                System.out.println("CẬP NHẬT thành công");
            } else {
                System.out.println("Có lỗi khi CẬP NHẬT");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
//            ketnoi kn = new ketnoi();
//            Connection conn = kn.ketNoiCSDL();
            String sql = "DELETE FROM SanPham WHERE MaSanPham = ?";
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
            ex.printStackTrace();
        }
            return true;
    }

    public ArrayList<HangHoa> readSP(int id) {
        try {
            
            ArrayList<HangHoa> lst = new ArrayList<>();

            String sql = "Select * from SanPham Where LoaiSanPham = ? Order By TenSanPham ASC";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, id);

            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {
                int MaSanPham = rs.getInt("MaSanPham");
                String TenSanPham = rs.getString("TenSanPham");
                int LoaiSanPham = rs.getInt("LoaiSanPham");
                int HangSanXuat = rs.getInt("HangSanXuat");
                float GiaNhap = rs.getFloat("GiaNhap");
                float GiaBan = rs.getFloat("GiaBan");

                int TonKho = rs.getInt("TonKho");
                boolean TrangThai = rs.getBoolean("TrangThai");
//                String Image = rs.getString("Image");
                String ChuThich = rs.getString("ChuThich");

                HangHoa ha = new HangHoa(MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, TonKho, TrangThai, ChuThich);
                lst.add(ha);

            }
            return lst;

        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());

        }
        return null;

    }
    
    public java.util.List<HoaDon> GetHoaDonBanChay() {
        //hoá đơn trong 1 tuần
        java.util.List<HoaDon> list = new ArrayList<>();
        try {
            String sql = "{CALL select_Week}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt("MaHoaDon"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return list;
    }
    public java.util.List<ChiTietHoaDon> CTHoaDonBanChay() {
        //chi tiết hoá đơn bán chạy trong 1 tuần
        java.util.List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            String sql = "{CALL slelec}";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                int MaCTHD = rs.getInt("MaSanPham");
                int MaSanPham = rs.getInt("MaSanPham");
                ChiTietHoaDon x=new ChiTietHoaDon(MaCTHD, MaSanPham);
                list.add(x);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<HangHoa> spBanChay(int MaSanPham){
        //sản phẩm bán chạy trong 1 tuần
        try {
            ArrayList<HangHoa> lst = new ArrayList<>();
            String sql = "select*from HangHoa Where MaSanPham=?";
            PreparedStatement pstt = conn.prepareStatement(sql);
            pstt.setInt(1, MaSanPham);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                int sMaSanPham = rs.getInt("MaSanPham");
                String TenSanPham = rs.getString("TenSanPham");
                int LoaiSanPham = rs.getInt("LoaiSanPham");
                int HangSanXuat = rs.getInt("HangSanXuat");
                float GiaNhap = rs.getFloat("GiaNhap");
                float GiaBan = rs.getFloat("GiaBan");
                int TonKho = rs.getInt("TonKho");
                boolean TrangThai = rs.getBoolean("TrangThai");
                String ChuThich = rs.getString("ChuThich");
                String TenLoaiSanPham=rs.getString("TenLoaiSanPham");
                String TenHangSanXuat=rs.getString("TenHangSanXuat");
                HangHoa ha = new HangHoa(sMaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, TonKho, TrangThai, ChuThich,TenLoaiSanPham,TenHangSanXuat);
                lst.add(ha);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
            return null;
        }
    }
    public ArrayList<HangHoa> readSPtheoid (int id) {
        try {
            
            ArrayList<HangHoa> lst = new ArrayList<>();

            String sql = "Select * from SanPham Where MaSanPham = ? Order By TenSanPham ASC";
            PreparedStatement pSTT = conn.prepareStatement(sql);
            pSTT.setInt(1, id);

            ResultSet rs = pSTT.executeQuery();
            while (rs.next()) {
                int MaSanPham = rs.getInt("MaSanPham");
                String TenSanPham = rs.getString("TenSanPham");
                int LoaiSanPham = rs.getInt("LoaiSanPham");
                int HangSanXuat = rs.getInt("HangSanXuat");
                float GiaNhap = rs.getFloat("GiaNhap");
                float GiaBan = rs.getFloat("GiaBan");
                int TonKho = rs.getInt("TonKho");
                boolean TrangThai = rs.getBoolean("TrangThai");
                String ChuThich = rs.getString("ChuThich");
                HangHoa ha = new HangHoa(MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, TonKho, TrangThai, ChuThich);
                lst.add(ha);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("LỖI: " + ex.toString());
        }
        return null;

    }
}
