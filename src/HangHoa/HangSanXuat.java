/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangHoa;

/**
 *
 * @author Phong
 */
public class HangSanXuat {
    private int MaHangSanXuat;
    private String TenHangSanXuat;

    public HangSanXuat() {
    }

    public HangSanXuat(int MaHangSanXuat, String TenHangSanXuat) {
        this.MaHangSanXuat = MaHangSanXuat;
        this.TenHangSanXuat = TenHangSanXuat;
    }

    public HangSanXuat(String TenHangSanXuat) {
        this.TenHangSanXuat = TenHangSanXuat;
    }

    public int getMaHangSanXuat() {
        return MaHangSanXuat;
    }

    public void setMaHangSanXuat(int MaHangSanXuat) {
        this.MaHangSanXuat = MaHangSanXuat;
    }

    public String getTenHangSanXuat() {
        return TenHangSanXuat;
    }

    public void setTenHangSanXuat(String TenHangSanXuat) {
        this.TenHangSanXuat = TenHangSanXuat;
    }

    @Override
    public String toString() {
        return this.TenHangSanXuat;
    }
    
}
