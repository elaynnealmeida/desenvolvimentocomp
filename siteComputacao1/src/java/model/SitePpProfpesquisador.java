/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_pp_profpesquisador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitePpProfpesquisador.findAll", query = "SELECT s FROM SitePpProfpesquisador s")
    , @NamedQuery(name = "SitePpProfpesquisador.findById", query = "SELECT s FROM SitePpProfpesquisador s WHERE s.id = :id")})
public class SitePpProfpesquisador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "pp", referencedColumnName = "id")
    @ManyToOne
    private SiteProjPesquisa pp;
    @JoinColumn(name = "prof_pesquisador", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores profPesquisador;

    public SitePpProfpesquisador() {
    }

    public SitePpProfpesquisador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SiteProjPesquisa getPp() {
        return pp;
    }

    public void setPp(SiteProjPesquisa pp) {
        this.pp = pp;
    }

    public TbProfessores getProfPesquisador() {
        return profPesquisador;
    }

    public void setProfPesquisador(TbProfessores profPesquisador) {
        this.profPesquisador = profPesquisador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitePpProfpesquisador)) {
            return false;
        }
        SitePpProfpesquisador other = (SitePpProfpesquisador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SitePpProfpesquisador[ id=" + id + " ]";
    }
    
}
