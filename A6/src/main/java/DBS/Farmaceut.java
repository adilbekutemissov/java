/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBS;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adilbek Utemissov
 */
@Entity
@Table(name = "farmaceut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Farmaceut.findAll", query = "SELECT f FROM Farmaceut f"),
    @NamedQuery(name = "Farmaceut.findByIcolekarna", query = "SELECT f FROM Farmaceut f WHERE f.icolekarna = :icolekarna"),
    @NamedQuery(name = "Farmaceut.findByJmeno", query = "SELECT f FROM Farmaceut f WHERE f.jmeno = :jmeno"),
    @NamedQuery(name = "Farmaceut.findByPrijmeni", query = "SELECT f FROM Farmaceut f WHERE f.prijmeni = :prijmeni"),
    @NamedQuery(name = "Farmaceut.findByEmail", query = "SELECT f FROM Farmaceut f WHERE f.email = :email"),
    @NamedQuery(name = "Farmaceut.findByHeslo", query = "SELECT f FROM Farmaceut f WHERE f.heslo = :heslo"),
    @NamedQuery(name = "Farmaceut.findByZamestnanecid", query = "SELECT f FROM Farmaceut f WHERE f.zamestnanecid = :zamestnanecid")})
public class Farmaceut implements Serializable {
    @ManyToMany(mappedBy = "farmaceutList")
    private List<Smlouva> smlouvaList;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "icolekarna")
    private int icolekarna;
    @Basic(optional = false)
    @Column(name = "jmeno")
    private String jmeno;
    @Basic(optional = false)
    @Column(name = "prijmeni")
    private String prijmeni;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "heslo")
    private String heslo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zamestnanecid")
    private Integer zamestnanecid;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        joinColumns={ @JoinColumn(name="zamestnanecid") },
        inverseJoinColumns={ @JoinColumn(name="nsmlouva") }
    )
    private List<Smlouva> smlouvy;

    public Farmaceut() {
    }

    public Farmaceut(Integer zamestnanecid) {
        this.zamestnanecid = zamestnanecid;
    }

    public Farmaceut(Integer zamestnanecid, int icolekarna, String jmeno, String prijmeni, String email, String heslo) {
        this.zamestnanecid = zamestnanecid;
        this.icolekarna = icolekarna;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.email = email;
        this.heslo = heslo;
    }

    public int getIcolekarna() {
        return icolekarna;
    }

    public void setIcolekarna(int icolekarna) {
        this.icolekarna = icolekarna;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public Integer getZamestnanecid() {
        return zamestnanecid;
    }

    public void setZamestnanecid(Integer zamestnanecid) {
        this.zamestnanecid = zamestnanecid;
    }
    
    public List<Smlouva> getSmlouvy() {
        return smlouvy;
    }

    public void setSmlouvy(List<Smlouva> smlouvy) {
        this.smlouvy = smlouvy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zamestnanecid != null ? zamestnanecid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmaceut)) {
            return false;
        }
        Farmaceut other = (Farmaceut) object;
        if ((this.zamestnanecid == null && other.zamestnanecid != null) || (this.zamestnanecid != null && !this.zamestnanecid.equals(other.zamestnanecid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBS.Farmaceut[ zamestnanecid=" + zamestnanecid + " ]";
    }

    @XmlTransient
    public List<Smlouva> getSmlouvaList() {
        return smlouvaList;
    }

    public void setSmlouvaList(List<Smlouva> smlouvaList) {
        this.smlouvaList = smlouvaList;
    }
    
}
