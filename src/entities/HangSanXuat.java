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
@Table(name = "HangSanXuat")
@NamedQueries({
    @NamedQuery(name = "HangSanXuat.findAll", query = "SELECT h FROM HangSanXuat h")})
public class HangSanXuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaHangSanXuat")
    private Integer maHangSanXuat;
    @Basic(optional = false)
    @Column(name = "TenHangSanXuat")
    private String tenHangSanXuat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hangSanXuat")
    private Collection<SanPham> sanPhamCollection;

    public HangSanXuat() {
    }

    public HangSanXuat(Integer maHangSanXuat) {
        this.maHangSanXuat = maHangSanXuat;
    }

    public HangSanXuat(Integer maHangSanXuat, String tenHangSanXuat) {
        this.maHangSanXuat = maHangSanXuat;
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public Integer getMaHangSanXuat() {
        return maHangSanXuat;
    }

    public void setMaHangSanXuat(Integer maHangSanXuat) {
        this.maHangSanXuat = maHangSanXuat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHangSanXuat != null ? maHangSanXuat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HangSanXuat)) {
            return false;
        }
        HangSanXuat other = (HangSanXuat) object;
        if ((this.maHangSanXuat == null && other.maHangSanXuat != null) || (this.maHangSanXuat != null && !this.maHangSanXuat.equals(other.maHangSanXuat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HangSanXuat[ maHangSanXuat=" + maHangSanXuat + " ]";
    }
    
}
