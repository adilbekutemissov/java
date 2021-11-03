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
@Table(name = "smlouva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smlouva.findAll", query = "SELECT s FROM Smlouva s"),
    @NamedQuery(name = "Smlouva.findByNsmlouva", query = "SELECT s FROM Smlouva s WHERE s.nsmlouva = :nsmlouva"),
    @NamedQuery(name = "Smlouva.findByIcolekarna", query = "SELECT s FROM Smlouva s WHERE s.icolekarna = :icolekarna"),
    @NamedQuery(name = "Smlouva.findByIcofarmspol", query = "SELECT s FROM Smlouva s WHERE s.icofarmspol = :icofarmspol"),
    @NamedQuery(name = "Smlouva.findByPrijemce", query = "SELECT s FROM Smlouva s WHERE s.prijemce = :prijemce"),
    @NamedQuery(name = "Smlouva.findByDodavatel", query = "SELECT s FROM Smlouva s WHERE s.dodavatel = :dodavatel"),
    @NamedQuery(name = "Smlouva.findByZacatek", query = "SELECT s FROM Smlouva s WHERE s.zacatek = :zacatek"),
    @NamedQuery(name = "Smlouva.findByKonec", query = "SELECT s FROM Smlouva s WHERE s.konec = :konec")})
public class Smlouva implements Serializable {
    @JoinTable(name = "farmaceut_smlouva", joinColumns = {
        @JoinColumn(name = "nsmlouva", referencedColumnName = "nsmlouva")}, inverseJoinColumns = {
        @JoinColumn(name = "zamestnanecid", referencedColumnName = "zamestnanecid")})
    @ManyToMany
    private List<Farmaceut> farmaceutList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nsmlouva")
    private Integer nsmlouva;
    @Basic(optional = false)
    @Column(name = "icolekarna")
    private int icolekarna;
    @Basic(optional = false)
    @Column(name = "icofarmspol")
    private int icofarmspol;
    @Basic(optional = false)
    @Column(name = "prijemce")
    private String prijemce;
    @Basic(optional = false)
    @Column(name = "dodavatel")
    private String dodavatel;
    @Basic(optional = false)
    @Column(name = "zacatek")
    private String zacatek;
    @Basic(optional = false)
    @Column(name = "konec")
    private String konec;
    @ManyToMany( mappedBy="smlouvy",cascade=CascadeType.ALL )
    private List<Farmaceut> farmaceuti ;

    public Smlouva() {
    }

    public Smlouva(Integer nsmlouva) {
        this.nsmlouva = nsmlouva;
    }

    public Smlouva(Integer nsmlouva, int icolekarna, int icofarmspol, String prijemce, String dodavatel, String zacatek, String konec) {
        this.nsmlouva = nsmlouva;
        this.icolekarna = icolekarna;
        this.icofarmspol = icofarmspol;
        this.prijemce = prijemce;
        this.dodavatel = dodavatel;
        this.zacatek = zacatek;
        this.konec = konec;
    }

    public Integer getNsmlouva() {
        return nsmlouva;
    }

    public void setNsmlouva(Integer nsmlouva) {
        this.nsmlouva = nsmlouva;
    }

    public int getIcolekarna() {
        return icolekarna;
    }

    public void setIcolekarna(int icolekarna) {
        this.icolekarna = icolekarna;
    }

    public int getIcofarmspol() {
        return icofarmspol;
    }

    public void setIcofarmspol(int icofarmspol) {
        this.icofarmspol = icofarmspol;
    }

    public String getPrijemce() {
        return prijemce;
    }

    public void setPrijemce(String prijemce) {
        this.prijemce = prijemce;
    }

    public String getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(String dodavatel) {
        this.dodavatel = dodavatel;
    }

    public String getZacatek() {
        return zacatek;
    }

    public void setZacatek(String zacatek) {
        this.zacatek = zacatek;
    }

    public String getKonec() {
        return konec;
    }

    public void setKonec(String konec) {
        this.konec = konec;
    }
    
    public List<Farmaceut> getFarmaceuti() {
        return farmaceuti;
    }

    public void setAccounts(List<Farmaceut> farmaceuti) {
        this.farmaceuti = farmaceuti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nsmlouva != null ? nsmlouva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smlouva)) {
            return false;
        }
        Smlouva other = (Smlouva) object;
        if ((this.nsmlouva == null && other.nsmlouva != null) || (this.nsmlouva != null && !this.nsmlouva.equals(other.nsmlouva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBS.Smlouva[ nsmlouva=" + nsmlouva + " ]";
    }

    @XmlTransient
    public List<Farmaceut> getFarmaceutList() {
        return farmaceutList;
    }

    public void setFarmaceutList(List<Farmaceut> farmaceutList) {
        this.farmaceutList = farmaceutList;
    }
    
}
