/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "KhachHang")
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaKhachHang")
    private Integer maKhachHang;
    @Basic(optional = false)
    @Column(name = "TenKhachHang")
    private String tenKhachHang;
    @Basic(optional = false)
    @Column(name = "Ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Basic(optional = false)
    @Column(name = "GioiTinh")
    private boolean gioiTinh;
    @Basic(optional = false)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private Collection<HoaDon> hoaDonCollection;
    @JoinColumn(name = "LoaiKhachHang", referencedColumnName = "MaLoaiKhachHang")
    @ManyToOne(optional = false)
    private LoaiKhachHang loaiKhachHang;

    public KhachHang() {
    }

    public KhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang(Integer maKhachHang, String tenKhachHang, Date ngaysinh, boolean gioiTinh, String diaChi, String sdt) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaysinh = ngaysinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.KhachHang[ maKhachHang=" + maKhachHang + " ]";
    }
    
}
