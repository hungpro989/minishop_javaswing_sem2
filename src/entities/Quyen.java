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
@Table(name = "Quyen")
@NamedQueries({
    @NamedQuery(name = "Quyen.findAll", query = "SELECT q FROM Quyen q")})
public class Quyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaQuyen")
    private Integer maQuyen;
    @Basic(optional = false)
    @Column(name = "TenQuyen")
    private String tenQuyen;
    @Column(name = "ChuThich")
    private String chuThich;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quyen")
    private Collection<Users> usersCollection;

    public Quyen() {
    }

    public Quyen(Integer maQuyen) {
        this.maQuyen = maQuyen;
    }

    public Quyen(Integer maQuyen, String tenQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
    }

    public Integer getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(Integer maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQuyen != null ? maQuyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quyen)) {
            return false;
        }
        Quyen other = (Quyen) object;
        if ((this.maQuyen == null && other.maQuyen != null) || (this.maQuyen != null && !this.maQuyen.equals(other.maQuyen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Quyen[ maQuyen=" + maQuyen + " ]";
    }
    
}
