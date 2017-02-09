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
@Table(name = "tb_ppc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPpc.findAll", query = "SELECT t FROM TbPpc t"),
    @NamedQuery(name = "TbPpc.findById", query = "SELECT t FROM TbPpc t WHERE t.id = :id"),
    @NamedQuery(name = "TbPpc.findByDataFim", query = "SELECT t FROM TbPpc t WHERE t.dataFim = :dataFim"),
    @NamedQuery(name = "TbPpc.findByDataInicio", query = "SELECT t FROM TbPpc t WHERE t.dataInicio = :dataInicio"),
    @NamedQuery(name = "TbPpc.findByDescricao", query = "SELECT t FROM TbPpc t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbPpc.findByDuracaoMaxima", query = "SELECT t FROM TbPpc t WHERE t.duracaoMaxima = :duracaoMaxima"),
    @NamedQuery(name = "TbPpc.findByDuracaoMinima", query = "SELECT t FROM TbPpc t WHERE t.duracaoMinima = :duracaoMinima")})
public class TbPpc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "data_fim")
    private String dataFim;
    @Size(max = 2147483647)
    @Column(name = "data_inicio")
    private String dataInicio;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "duracao_maxima")
    private String duracaoMaxima;
    @Size(max = 2147483647)
    @Column(name = "duracao_minima")
    private String duracaoMinima;
    @OneToMany(mappedBy = "ppcId")
    private List<TbCurso> tbCursoList;

    public TbPpc() {
    }

    public TbPpc(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(String duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public String getDuracaoMinima() {
        return duracaoMinima;
    }

    public void setDuracaoMinima(String duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    @XmlTransient
    public List<TbCurso> getTbCursoList() {
        return tbCursoList;
    }

    public void setTbCursoList(List<TbCurso> tbCursoList) {
        this.tbCursoList = tbCursoList;
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
        if (!(object instanceof TbPpc)) {
            return false;
        }
        TbPpc other = (TbPpc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbPpc[ id=" + id + " ]";
    }
    
}
