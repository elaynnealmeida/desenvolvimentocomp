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
@Table(name = "tb_universidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUniversidade.findAll", query = "SELECT t FROM TbUniversidade t"),
    @NamedQuery(name = "TbUniversidade.findById", query = "SELECT t FROM TbUniversidade t WHERE t.id = :id"),
    @NamedQuery(name = "TbUniversidade.findByNome", query = "SELECT t FROM TbUniversidade t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbUniversidade.findBySigla", query = "SELECT t FROM TbUniversidade t WHERE t.sigla = :sigla")})
public class TbUniversidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "universidadeId")
    private List<TbCampus> tbCampusList;

    public TbUniversidade() {
    }

    public TbUniversidade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public List<TbCampus> getTbCampusList() {
        return tbCampusList;
    }

    public void setTbCampusList(List<TbCampus> tbCampusList) {
        this.tbCampusList = tbCampusList;
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
        if (!(object instanceof TbUniversidade)) {
            return false;
        }
        TbUniversidade other = (TbUniversidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUniversidade[ id=" + id + " ]";
    }
    
}
