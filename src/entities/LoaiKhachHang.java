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
@Table(name = "LoaiKhachHang")
@NamedQueries({
    @NamedQuery(name = "LoaiKhachHang.findAll", query = "SELECT l FROM LoaiKhachHang l")})
public class LoaiKhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiKhachHang")
    private Integer maLoaiKhachHang;
    @Basic(optional = false)
    @Column(name = "TenLoaiKhachHang")
    private String tenLoaiKhachHang;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiKhachHang")
    private Collection<KhachHang> khachHangCollection;

    public LoaiKhachHang() {
    }

    public LoaiKhachHang(Integer maLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public LoaiKhachHang(Integer maLoaiKhachHang, String tenLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    public Integer getMaLoaiKhachHang() {
        return maLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(Integer maLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public String getTenLoaiKhachHang() {
        return tenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String tenLoaiKhachHang) {
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Collection<KhachHang> getKhachHangCollection() {
        return khachHangCollection;
    }

    public void setKhachHangCollection(Collection<KhachHang> khachHangCollection) {
        this.khachHangCollection = khachHangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiKhachHang != null ? maLoaiKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiKhachHang)) {
            return false;
        }
        LoaiKhachHang other = (LoaiKhachHang) object;
        if ((this.maLoaiKhachHang == null && other.maLoaiKhachHang != null) || (this.maLoaiKhachHang != null && !this.maLoaiKhachHang.equals(other.maLoaiKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoaiKhachHang[ maLoaiKhachHang=" + maLoaiKhachHang + " ]";
    }
    
}
