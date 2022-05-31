/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TongQuan;

import connectDB.Connect;
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
public class ThoiGianCRUD {
    Connection conn = new Connect().connectDB();
    public ArrayList<ThoiGian> selectThoiGian(){
        ArrayList<ThoiGian> lst = new ArrayList<>();
        try {
            String sql = "{CALL select_ThoiGian}";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String ThoiGian=rs.getString(2);
                ThoiGian tg= new ThoiGian(id, ThoiGian);
                lst.add(tg);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi select thời gian "+ex);
            ex.printStackTrace();
        }
        return lst;
    } 
}
