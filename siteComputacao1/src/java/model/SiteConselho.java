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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_conselho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteConselho.findAll", query = "SELECT s FROM SiteConselho s"),
    @NamedQuery(name = "SiteConselho.findById", query = "SELECT s FROM SiteConselho s WHERE s.id = :id"),
    @NamedQuery(name = "SiteConselho.findByNome", query = "SELECT s FROM SiteConselho s WHERE s.nome = :nome"),
    @NamedQuery(name = "SiteConselho.findBySigla", query = "SELECT s FROM SiteConselho s WHERE s.sigla = :sigla")})
public class SiteConselho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "conselhoId")
    private List<SitePublicacao> sitePublicacaoList;

    public SiteConselho() {
    }

    public SiteConselho(Integer id) {
        this.id = id;
    }

    public SiteConselho(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @XmlTransient
    public List<SitePublicacao> getSitePublicacaoList() {
        return sitePublicacaoList;
    }

    public void setSitePublicacaoList(List<SitePublicacao> sitePublicacaoList) {
        this.sitePublicacaoList = sitePublicacaoList;
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
        if (!(object instanceof SiteConselho)) {
            return false;
        }
        SiteConselho other = (SiteConselho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteConselho[ id=" + id + " ]";
    }
    
}
