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
@Table(name = "LoaiSanPham")
@NamedQueries({
    @NamedQuery(name = "LoaiSanPham.findAll", query = "SELECT l FROM LoaiSanPham l")})
public class LoaiSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiSanPham")
    private Integer maLoaiSanPham;
    @Basic(optional = false)
    @Column(name = "TenLoaiSanPham")
    private String tenLoaiSanPham;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiSanPham")
    private Collection<SanPham> sanPhamCollection;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public LoaiSanPham(Integer maLoaiSanPham, String tenLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public Integer getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(Integer maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
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
        hash += (maLoaiSanPham != null ? maLoaiSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiSanPham)) {
            return false;
        }
        LoaiSanPham other = (LoaiSanPham) object;
        if ((this.maLoaiSanPham == null && other.maLoaiSanPham != null) || (this.maLoaiSanPham != null && !this.maLoaiSanPham.equals(other.maLoaiSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoaiSanPham[ maLoaiSanPham=" + maLoaiSanPham + " ]";
    }
    
}
