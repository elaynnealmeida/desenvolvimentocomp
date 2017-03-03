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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCampus.findAll", query = "SELECT t FROM TbCampus t"),
    @NamedQuery(name = "TbCampus.findById", query = "SELECT t FROM TbCampus t WHERE t.id = :id"),
    @NamedQuery(name = "TbCampus.findByDescricao", query = "SELECT t FROM TbCampus t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbCampus.findBySigla", query = "SELECT t FROM TbCampus t WHERE t.sigla = :sigla")})
public class TbCampus implements Serializable {

    @OneToMany(mappedBy = "campusId")
    private List<TbBloco> tbBlocoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 255)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "campusId")
    private List<TbDepartamento> tbDepartamentoList;
    @JoinColumn(name = "universidade_id", referencedColumnName = "id")
    @ManyToOne
    private TbUniversidade universidadeId;

    public TbCampus() {
    }

    public TbCampus(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @XmlTransient
    public List<TbDepartamento> getTbDepartamentoList() {
        return tbDepartamentoList;
    }

    public void setTbDepartamentoList(List<TbDepartamento> tbDepartamentoList) {
        this.tbDepartamentoList = tbDepartamentoList;
    }

    public TbUniversidade getUniversidadeId() {
        return universidadeId;
    }

    public void setUniversidadeId(TbUniversidade universidadeId) {
        this.universidadeId = universidadeId;
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
        if (!(object instanceof TbCampus)) {
            return false;
        }
        TbCampus other = (TbCampus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCampus[ id=" + id + " ]";
    }

    @XmlTransient
    public List<TbBloco> getTbBlocoList() {
        return tbBlocoList;
    }

    public void setTbBlocoList(List<TbBloco> tbBlocoList) {
        this.tbBlocoList = tbBlocoList;
    }
    
}
