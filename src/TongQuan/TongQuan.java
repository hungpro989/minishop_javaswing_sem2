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
public class TongQuan {
    
    private float tongdonhang;
    private float tongtienx;
    private float soluongsp;
    private String datestart;
    private String dateend;
    public TongQuan() {
    }

    public TongQuan(String datestart, String dateend) {
        this.datestart = datestart;
        this.dateend = dateend;
    }

    public TongQuan(float tongdonhang, float tongtienx, float soluongsp) {
        this.tongdonhang = tongdonhang;
        this.tongtienx = tongtienx;
        this.soluongsp = soluongsp;
    }

    public TongQuan(float tongdonhang, float tongtienx) {
        this.tongdonhang = tongdonhang;
        this.tongtienx = tongtienx;
    }

    public TongQuan(float soluongsp) {
        this.soluongsp = soluongsp;
    }

    public float getTongdonhang() {
        return tongdonhang;
    }

    public void setTongdonhang(float tongdonhang) {
        this.tongdonhang = tongdonhang;
    }

    public float getTongtienx() {
        return tongtienx;
    }

    public void setTongtienx(float tongtienx) {
        this.tongtienx = tongtienx;
    }

    public float getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(float soluongsp) {
        this.soluongsp = soluongsp;
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
