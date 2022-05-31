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
@Table(name = "NhanVien")
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;
    @Basic(optional = false)
    @Column(name = "TenNhanVien")
    private String tenNhanVien;
    @Basic(optional = false)
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Basic(optional = false)
    @Column(name = "GioiTinh")
    private boolean gioiTinh;
    @Basic(optional = false)
    @Column(name = "NgayVaoLam")
    @Temporal(TemporalType.DATE)
    private Date ngayVaoLam;
    @Basic(optional = false)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @Column(name = "SoDT")
    private String soDT;
    @Column(name = "GhiChu")
    private String ghiChu;
    @JoinColumn(name = "ChucVu", referencedColumnName = "MaChucVu")
    @ManyToOne(optional = false)
    private ChucVu chucVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private Collection<HoaDon> hoaDonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private Collection<PhieuNhap> phieuNhapCollection;

    public NhanVien() {
    }

    public NhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien(Integer maNhanVien, String tenNhanVien, Date ngaySinh, boolean gioiTinh, Date ngayVaoLam, String diaChi, String soDT) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.ngayVaoLam = ngayVaoLam;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    public Collection<PhieuNhap> getPhieuNhapCollection() {
        return phieuNhapCollection;
    }

    public void setPhieuNhapCollection(Collection<PhieuNhap> phieuNhapCollection) {
        this.phieuNhapCollection = phieuNhapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhanVien != null ? maNhanVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNhanVien == null && other.maNhanVien != null) || (this.maNhanVien != null && !this.maNhanVien.equals(other.maNhanVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhanVien[ maNhanVien=" + maNhanVien + " ]";
    }
    
}
