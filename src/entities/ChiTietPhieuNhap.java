/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "ChiTietPhieuNhap")
@NamedQueries({
    @NamedQuery(name = "ChiTietPhieuNhap.findAll", query = "SELECT c FROM ChiTietPhieuNhap c")})
public class ChiTietPhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaCTPN")
    private Integer maCTPN;
    @Basic(optional = false)
    @Column(name = "SoLuong")
    private int soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    @Column(name = "ChuThich")
    private String chuThich;
    @JoinColumn(name = "MaPhieuNhap", referencedColumnName = "MaPhieuNhap")
    @ManyToOne(optional = false)
    private PhieuNhap phieuNhap;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
    @ManyToOne(optional = false)
    private SanPham sanPham;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(Integer maCTPN) {
        this.maCTPN = maCTPN;
    }

    public ChiTietPhieuNhap(Integer maCTPN, int soLuong, BigDecimal tongTien) {
        this.maCTPN = maCTPN;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public Integer getMaCTPN() {
        return maCTPN;
    }

    public void setMaCTPN(Integer maCTPN) {
        this.maCTPN = maCTPN;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTPN != null ? maCTPN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietPhieuNhap)) {
            return false;
        }
        ChiTietPhieuNhap other = (ChiTietPhieuNhap) object;
        if ((this.maCTPN == null && other.maCTPN != null) || (this.maCTPN != null && !this.maCTPN.equals(other.maCTPN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChiTietPhieuNhap[ maCTPN=" + maCTPN + " ]";
    }
    
}
