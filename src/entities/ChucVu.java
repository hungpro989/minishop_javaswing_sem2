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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "ChucVu")
@NamedQueries({
    @NamedQuery(name = "ChucVu.findAll", query = "SELECT c FROM ChucVu c")})
public class ChucVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaChucVu")
    private Integer maChucVu;
    @Basic(optional = false)
    @Column(name = "TenChucVu")
    private String tenChucVu;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucVu")
    private Collection<NhanVien> nhanVienCollection;

    public ChucVu() {
    }

    public ChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public ChucVu(Integer maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public Integer getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Collection<NhanVien> getNhanVienCollection() {
        return nhanVienCollection;
    }

    public void setNhanVienCollection(Collection<NhanVien> nhanVienCollection) {
        this.nhanVienCollection = nhanVienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChucVu != null ? maChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChucVu)) {
            return false;
        }
        ChucVu other = (ChucVu) object;
        if ((this.maChucVu == null && other.maChucVu != null) || (this.maChucVu != null && !this.maChucVu.equals(other.maChucVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChucVu[ maChucVu=" + maChucVu + " ]";
    }
    
}
