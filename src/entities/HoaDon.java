/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "HoaDon")
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;
    @Basic(optional = false)
    @Column(name = "NgayLapHoaDon")
    @Temporal(TemporalType.DATE)
    private Date ngayLapHoaDon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TongTien")
    private float tongTien;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private Collection<ChiTietHoaDon> chiTietHoaDonCollection;
    @JoinColumn(name = "MaKhachHang", referencedColumnName = "MaKhachHang")
    @ManyToOne(optional = false)
    private KhachHang khachHang;
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien")
    @ManyToOne(optional = false)
    private NhanVien nhanVien;

    public HoaDon() {
    }

    public HoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public HoaDon(Integer maHoaDon, Date ngayLapHoaDon, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Collection<ChiTietHoaDon> getChiTietHoaDonCollection() {
        return chiTietHoaDonCollection;
    }

    public void setChiTietHoaDonCollection(Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
        this.chiTietHoaDonCollection = chiTietHoaDonCollection;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HoaDon[ maHoaDon=" + maHoaDon + " ]";
    }
    
}
