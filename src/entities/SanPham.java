/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "SanPham")
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaSanPham")
    private Integer maSanPham;
    @Basic(optional = false)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Basic(optional = false)
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    @Basic(optional = false)
    @Column(name = "TonKho")
    private int tonKho;
    @Basic(optional = false)
    @Column(name = "TrangThai")
    private boolean trangThai;
    @Column(name = "Image")
    private String image;
    @Column(name = "ChuThich")
    private String chuThich;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private Collection<ChiTietHoaDon> chiTietHoaDonCollection;
    @JoinColumn(name = "HangSanXuat", referencedColumnName = "MaHangSanXuat")
    @ManyToOne(optional = false)
    private HangSanXuat hangSanXuat;
    @JoinColumn(name = "LoaiSanPham", referencedColumnName = "MaLoaiSanPham")
    @ManyToOne(optional = false)
    private LoaiSanPham loaiSanPham;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private Collection<ChiTietPhieuNhap> chiTietPhieuNhapCollection;

    public SanPham() {
    }

    public SanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public SanPham(Integer maSanPham, String tenSanPham, BigDecimal giaNhap, BigDecimal giaBan, int tonKho, boolean trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tonKho = tonKho;
        this.trangThai = trangThai;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public Collection<ChiTietHoaDon> getChiTietHoaDonCollection() {
        return chiTietHoaDonCollection;
    }

    public void setChiTietHoaDonCollection(Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
        this.chiTietHoaDonCollection = chiTietHoaDonCollection;
    }

    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
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
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SanPham[ maSanPham=" + maSanPham + " ]";
    }
    
}
