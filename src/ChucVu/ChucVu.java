/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucVu;

/**
 *
 * @author Phong
 */
public class ChucVu {
    private int MaChucVu;
    private String TenChucVu;
    private String GhiChu;

    public ChucVu() {
    }

    public ChucVu(int MaChucVu, String TenChucVu, String GhiChu) {
        this.MaChucVu = MaChucVu;
        this.TenChucVu = TenChucVu;
        this.GhiChu = GhiChu;
    }

    public ChucVu(String TenChucVu, String GhiChu) {
        this.TenChucVu = TenChucVu;
        this.GhiChu = GhiChu;
    }

    public int getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(int MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return this.TenChucVu; //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
