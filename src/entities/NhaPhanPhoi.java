/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "NhaPhanPhoi")
@NamedQueries({
    @NamedQuery(name = "NhaPhanPhoi.findAll", query = "SELECT n FROM NhaPhanPhoi n")})
public class NhaPhanPhoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNhaPhanPhoi")
    private Integer maNhaPhanPhoi;
    @Basic(optional = false)
    @Column(name = "TenNhaPhanPhoi")
    private String tenNhaPhanPhoi;
    @Basic(optional = false)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "ChuThich")
    private String chuThich;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaPhanPhoi")
    private Collection<PhieuNhap> phieuNhapCollection;

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(Integer maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public NhaPhanPhoi(Integer maNhaPhanPhoi, String tenNhaPhanPhoi, String diaChi, String sdt, String email) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public Integer getMaNhaPhanPhoi() {
        return maNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(Integer maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public String getTenNhaPhanPhoi() {
        return tenNhaPhanPhoi;
    }

    public void setTenNhaPhanPhoi(String tenNhaPhanPhoi) {
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
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
        hash += (maNhaPhanPhoi != null ? maNhaPhanPhoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaPhanPhoi)) {
            return false;
        }
        NhaPhanPhoi other = (NhaPhanPhoi) object;
        if ((this.maNhaPhanPhoi == null && other.maNhaPhanPhoi != null) || (this.maNhaPhanPhoi != null && !this.maNhaPhanPhoi.equals(other.maNhaPhanPhoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhaPhanPhoi[ maNhaPhanPhoi=" + maNhaPhanPhoi + " ]";
    }
    
}
