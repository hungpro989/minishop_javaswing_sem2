/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangHoa;

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
 * @author Phong
 */
public class HangSanXuatDAO {
    Connect kn = new Connect();
            Connection conn = kn.connectDB();
    public ArrayList<HangSanXuat> read(){
        try {
            ArrayList<HangSanXuat> lst = new ArrayList<>();
            String sql = "Select * from HangSanXuat Order By TenHangSanXuat ASC";
//            ketnoi kn = new ketnoi();
//            Connection cnn = kn.ketNoiCSDL();
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            
           while (rs.next()) {
               int MaHangSanXuat = rs.getInt("MaHangSanXuat");
               String TenHangSanXuat = rs.getString("TenHangSanXuat");
             HangSanXuat ha = new HangSanXuat(MaHangSanXuat, TenHangSanXuat);
             lst.add(ha);
               
            }
           return lst;
        } catch (SQLException ex) {
            Logger.getLogger(HangSanXuat.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
         return null;
         
}
}
