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
@Table(name = "PhieuNhap")
@NamedQueries({
    @NamedQuery(name = "PhieuNhap.findAll", query = "SELECT p FROM PhieuNhap p")})
public class PhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    @Basic(optional = false)
    @Column(name = "NgayNhap")
    @Temporal(TemporalType.DATE)
    private Date ngayNhap;
    @Column(name = "ChuThich")
    private String chuThich;
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien")
    @ManyToOne(optional = false)
    private NhanVien nhanVien;
    @JoinColumn(name = "MaNhaPhanPhoi", referencedColumnName = "MaNhaPhanPhoi")
    @ManyToOne(optional = false)
    private NhaPhanPhoi nhaPhanPhoi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieuNhap")
    private Collection<ChiTietPhieuNhap> chiTietPhieuNhapCollection;

    public PhieuNhap() {
    }

    public PhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public PhieuNhap(Integer maPhieuNhap, BigDecimal tongTien, Date ngayNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
    }

    public Integer getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhaPhanPhoi getNhaPhanPhoi() {
        return nhaPhanPhoi;
    }

    public void setNhaPhanPhoi(NhaPhanPhoi nhaPhanPhoi) {
        this.nhaPhanPhoi = nhaPhanPhoi;
    }

    public Collection<ChiTietPhieuNhap> getChiTietPhieuNhapCollection() {
        return chiTietPhieuNhapCollection;
    }

    public void setChiTietPhieuNhapCollection(Collection<ChiTietPhieuNhap> chiTietPhieuNhapCollection) {
        this.chiTietPhieuNhapCollection = chiTietPhieuNhapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhieuNhap != null ? maPhieuNhap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhieuNhap)) {
            return false;
        }
        PhieuNhap other = (PhieuNhap) object;
        if ((this.maPhieuNhap == null && other.maPhieuNhap != null) || (this.maPhieuNhap != null && !this.maPhieuNhap.equals(other.maPhieuNhap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PhieuNhap[ maPhieuNhap=" + maPhieuNhap + " ]";
    }
    
}
