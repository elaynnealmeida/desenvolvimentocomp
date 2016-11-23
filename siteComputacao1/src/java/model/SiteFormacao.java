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
@Table(name = "site_formacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteFormacao.findAll", query = "SELECT s FROM SiteFormacao s"),
    @NamedQuery(name = "SiteFormacao.findById", query = "SELECT s FROM SiteFormacao s WHERE s.id = :id"),
    @NamedQuery(name = "SiteFormacao.findByDescricao", query = "SELECT s FROM SiteFormacao s WHERE s.descricao = :descricao")})
public class SiteFormacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "formacaoId")
    private List<SiteProfessorFormacao> siteProfessorFormacaoList;

    public SiteFormacao() {
    }

    public SiteFormacao(Integer id) {
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
    public List<SiteProfessorFormacao> getSiteProfessorFormacaoList() {
        return siteProfessorFormacaoList;
    }

    public void setSiteProfessorFormacaoList(List<SiteProfessorFormacao> siteProfessorFormacaoList) {
        this.siteProfessorFormacaoList = siteProfessorFormacaoList;
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
        if (!(object instanceof SiteFormacao)) {
            return false;
        }
        SiteFormacao other = (SiteFormacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteFormacao[ id=" + id + " ]";
    }
    
}
