/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TongQuan;

/**
 *
 * @author Hung Dep Trai
 */
public class ThoiGian {
    private int MaSXTG;
    private String ThoiGian;
    private String datestart;
    private String dateend;
    public ThoiGian() {
    }

    public ThoiGian(String datestart, String dateend) {
        this.datestart = datestart;
        this.dateend = dateend;
    }
    
    public ThoiGian(int MaSXTG, String ThoiGian) {
        this.MaSXTG = MaSXTG;
        this.ThoiGian = ThoiGian;
    }

    public ThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public int getMaSXTG() {
        return MaSXTG;
    }

    public void setMaSXTG(int MaSXTG) {
        this.MaSXTG = MaSXTG;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    @Override
    public String toString() {
        return this.ThoiGian;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public String getDateend() {
        return dateend;
    }

    public void setDateend(String dateend) {
        this.dateend = dateend;
    }
    
}
