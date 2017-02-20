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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_publicacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitePublicacao.findAll", query = "SELECT s FROM SitePublicacao s"),
    @NamedQuery(name = "SitePublicacao.findById", query = "SELECT s FROM SitePublicacao s WHERE s.id = :id"),
    @NamedQuery(name = "SitePublicacao.findByNumero", query = "SELECT s FROM SitePublicacao s WHERE s.numero = :numero"),
    @NamedQuery(name = "SitePublicacao.findByAno", query = "SELECT s FROM SitePublicacao s WHERE s.ano = :ano"),
    @NamedQuery(name = "SitePublicacao.findByData", query = "SELECT s FROM SitePublicacao s WHERE s.data = :data")})
public class SitePublicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "conselho_id", referencedColumnName = "id")
    @ManyToOne
    private SiteConselho conselhoId;
    @JoinColumn(name = "tipo_publicacao", referencedColumnName = "id")
    @ManyToOne
    private SiteTipoPublicacao tipoPublicacao;

    public SitePublicacao() {
    }

    public SitePublicacao(Integer id) {
        this.id = id;
    }

    public SitePublicacao(Integer id, int numero, int ano, String data) {
        this.id = id;
        this.numero = numero;
        this.ano = ano;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SiteConselho getConselhoId() {
        return conselhoId;
    }

    public void setConselhoId(SiteConselho conselhoId) {
        this.conselhoId = conselhoId;
    }

    public SiteTipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(SiteTipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
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
        if (!(object instanceof SitePublicacao)) {
            return false;
        }
        SitePublicacao other = (SitePublicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SitePublicacao[ id=" + id + " ]";
    }
    
}
