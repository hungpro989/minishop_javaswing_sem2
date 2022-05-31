/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hung Dep Trai
 */
public class Connect {
    private final String URL = "jdbc:sqlserver://localhost\\DESKTOP-4SKK4PF\\HUNGDZ:1433;databaseName=QuanLySanPham";
    private final String USERNAME = "sa";
    private final String PASSWORD = "1234$";
    public Connection connectDB(){
        try {
            Connection conn;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Kết nối csdl thành công...");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Lỗi kết nối csdl..."+ex);
            ex.printStackTrace();
            return null;
        }
    }
}
