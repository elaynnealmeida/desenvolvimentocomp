/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteModulo.findAll", query = "SELECT s FROM SiteModulo s")
    , @NamedQuery(name = "SiteModulo.findById", query = "SELECT s FROM SiteModulo s WHERE s.id = :id")
    , @NamedQuery(name = "SiteModulo.findByDescricao", query = "SELECT s FROM SiteModulo s WHERE s.descricao = :descricao")})
public class SiteModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "modal")
    private List<SiteIniciacaoCientifica> siteIniciacaoCientificaList;

    public SiteModulo() {
    }

    public SiteModulo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<SiteIniciacaoCientifica> getSiteIniciacaoCientificaList() {
        return siteIniciacaoCientificaList;
    }

    public void setSiteIniciacaoCientificaList(List<SiteIniciacaoCientifica> siteIniciacaoCientificaList) {
        this.siteIniciacaoCientificaList = siteIniciacaoCientificaList;
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
        if (!(object instanceof SiteModulo)) {
            return false;
        }
        SiteModulo other = (SiteModulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteModulo[ id=" + id + " ]";
    }
    
}
