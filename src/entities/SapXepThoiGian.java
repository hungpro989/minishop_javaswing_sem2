/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hung Dep Trai
 */
@Entity
@Table(name = "SapXepThoiGian")
@NamedQueries({
    @NamedQuery(name = "SapXepThoiGian.findAll", query = "SELECT s FROM SapXepThoiGian s")})
public class SapXepThoiGian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaSXTG")
    private Integer maSXTG;
    @Column(name = "ThoiGian")
    private String thoiGian;

    public SapXepThoiGian() {
    }

    public SapXepThoiGian(Integer maSXTG) {
        this.maSXTG = maSXTG;
    }

    public Integer getMaSXTG() {
        return maSXTG;
    }

    public void setMaSXTG(Integer maSXTG) {
        this.maSXTG = maSXTG;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSXTG != null ? maSXTG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SapXepThoiGian)) {
            return false;
        }
        SapXepThoiGian other = (SapXepThoiGian) object;
        if ((this.maSXTG == null && other.maSXTG != null) || (this.maSXTG != null && !this.maSXTG.equals(other.maSXTG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SapXepThoiGian[ maSXTG=" + maSXTG + " ]";
    }
    
}
