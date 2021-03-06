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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_matriz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteMatriz.findAll", query = "SELECT s FROM SiteMatriz s"),
    @NamedQuery(name = "SiteMatriz.findById", query = "SELECT s FROM SiteMatriz s WHERE s.id = :id"),
    @NamedQuery(name = "SiteMatriz.findByPosicao", query = "SELECT s FROM SiteMatriz s WHERE s.posicao = :posicao"),
    @NamedQuery(name = "SiteMatriz.findByDescricao", query = "SELECT s FROM SiteMatriz s WHERE s.descricao = :descricao")})
public class SiteMatriz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "posicao")
    private Integer posicao;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    @ManyToOne
    private TbDisciplina idDisciplina;
    @Size(max = 16)
    @Column(name="apelido")
    private String apelido;

    public SiteMatriz() {
    }

    public SiteMatriz(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TbDisciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(TbDisciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
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
        if (!(object instanceof SiteMatriz)) {
            return false;
        }
        SiteMatriz other = (SiteMatriz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteMatriz[ id=" + id + " ]";
    }
    
}
