/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTac;

/**
 *
 * @author Phong
 */
public class Doitac {
    private int MaNhaPhanPhoi;
    private String TenNhaPhanPhoi;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String ChuThich;

    public Doitac() {
    }

    public Doitac(String TenNhaPhanPhoi, String DiaChi, String SDT, String Email, String ChuThich) {
        this.TenNhaPhanPhoi = TenNhaPhanPhoi;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.ChuThich = ChuThich;
    }

    public Doitac(int MaNhaPhanPhoi, String TenNhaPhanPhoi, String DiaChi, String SDT, String Email, String ChuThich) {
        this.MaNhaPhanPhoi = MaNhaPhanPhoi;
        this.TenNhaPhanPhoi = TenNhaPhanPhoi;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.ChuThich = ChuThich;
    }

    public int getMaNhaPhanPhoi() {
        return MaNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(int MaNhaPhanPhoi) {
        this.MaNhaPhanPhoi = MaNhaPhanPhoi;
    }

    public String getTenNhaPhanPhoi() {
        return TenNhaPhanPhoi;
    }

    public void setTenNhaPhanPhoi(String TenNhaPhanPhoi) {
        this.TenNhaPhanPhoi = TenNhaPhanPhoi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    @Override
    public String toString() {
        return this.TenNhaPhanPhoi; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
