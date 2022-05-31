/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TongQuan;

import connectDB.Connect;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hung Dep Trai
 */
public class TongQuanCRUD {

    Connection conn = new Connect().connectDB();

    public ArrayList<TongQuan> select_TongQuan_HomNay() {
        //Doanh thu ngày hôm nay
        try {
            ArrayList<TongQuan> lst = new ArrayList<>();
            String sql = "{CALL select_chinhxac_ngayhnay}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("DoanhThuHD");
                float tongdonhang = rs.getFloat("TongHD");
                float tongsp = rs.getFloat("TongSP");
                TongQuan tq = new TongQuan(tongdonhang, tongtienx, tongsp);
                lst.add(tq);
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<TongQuan> select_TongQuan_HomQua_THD_TTien() {
        //doanh thu ngày hôm qua tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_TTien_THD_hqua}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tongdonhang = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tongdonhang, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_HomQua() {
        // ngày hôm qua tổng số sản phẩm
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_soluongSP_hqua}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_DoanhThu_ThisMonth() {
        //doanh thu tháng này tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_month_THD_TT}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tonghoadon = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tonghoadon, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_ThisMonth() {
        //doanh thu tháng này tổng số lượng
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_lastmonth_SoLuong}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_DoanhThu_LastMonth() {
        //doanh thu tháng truoc tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_DoanhThu_LastMonth}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tonghoadon = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tonghoadon, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_LastMonth() {
        //doanh thu tháng này tổng số lượng
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_SoSP_LastMonth}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_DoanhThu_ThisYear() {
        //doanh thu nam nay tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_DoanhThu_ThisYear}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tonghoadon = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tonghoadon, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_ThisYear() {
        //doanh thu nam này tổng số lượng
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_SoSP_ThisYear}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_DoanhThu_LastYear() {
        //doanh thu nam nay tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_DoanhThu_LastYear}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tonghoadon = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tonghoadon, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_LastYear() {
        //doanh thu nam này tổng số lượng
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_SoSP_LastYear}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    //trong 1 phạm vi
    public ArrayList<TongQuan> select_DoanhThu_PhamVi(TongQuan ts) {
        //doanh thu trong 1 Pham Vi tổng hoá đơn, tổng tiền
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            //đặt điều kiện ngày tháng để select
            //String sql = "{CALL select_DoanhThu_PhaMVi(?,?)}";
            String sql = "select count(MaHoaDon)as TongHoaDon,sum(TongTien)as TongTien from ChiTietHoaDon\n"
                    + "where NgayLapCTHD >= ? and NgayLapCTHD<= ?";
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, ts.getDatestart());
            cs.setString(2, ts.getDateend());
            int row = cs.executeUpdate();
            if (row > 0) {
                System.out.println("phamj vi doanh thu thanh cong");
            } else {
                System.out.println("phamj vi doanh thu that bai");
            }
            //lấy ra giá trị trong bảng
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongTien");
                float tonghoadon = rs.getFloat("TongHoaDon");
                TongQuan tq = new TongQuan(tonghoadon, tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    public ArrayList<TongQuan> select_SoLuong_PhamVi() {
        //doanh thu trong 1 phạm vi tổng số lượng
        ArrayList<TongQuan> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_SoLuong_PhamVi(?,?)}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                float tongtienx = rs.getFloat("TongSoLuong");
                TongQuan tq = new TongQuan(tongtienx);
                lst.add(tq);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return lst;
    }

    //Lấy list Hoá đơn từ ngày------------ đến ngày
    public List<HoaDon> GetHoaDonRange(String dates, String datee) {
        //doanh thu trong 1 phạm vi tổng số lượng
        List<HoaDon> list = new ArrayList<>();
        try {
            String sql = "Select * from HoaDon where NgayLapHoaDon BETWEEN ? AND ?";

            PreparedStatement pstt = conn.prepareStatement(sql);
            pstt.setString(1, dates);
            pstt.setString(2, datee);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt("MaHoaDon"), rs.getDate("NgayLapHoaDon"), rs.getFloat("TongTien"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return list;
    }
     public List<ChiTietHoaDon> GetCTHoaDonRange(int MaHoaDon) {
        //doanh thu trong 1 phạm vi tổng số lượng
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            String sql = "Select * from ChiTietHoaDon where MaHoaDon = ?";
            PreparedStatement pstt = conn.prepareStatement(sql);
            pstt.setInt(1, MaHoaDon);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon(rs.getInt("SoLuong"));
                list.add(cthd);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi hiển thị dữ liệu tổng quan: " + ex);
            ex.printStackTrace();
        }
        return list;
    }

}
