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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "tb_matriz_curricular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMatrizCurricular.findAll", query = "SELECT t FROM TbMatrizCurricular t"),
    @NamedQuery(name = "TbMatrizCurricular.findById", query = "SELECT t FROM TbMatrizCurricular t WHERE t.id = :id"),
    @NamedQuery(name = "TbMatrizCurricular.findByAno", query = "SELECT t FROM TbMatrizCurricular t WHERE t.ano = :ano"),
    @NamedQuery(name = "TbMatrizCurricular.findByDescricao", query = "SELECT t FROM TbMatrizCurricular t WHERE t.descricao = :descricao")})
public class TbMatrizCurricular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    @ManyToOne
    private TbCurso cursoId;
    @OneToMany(mappedBy = "matrizCurricularId")
    private List<TbDisciplina> tbDisciplinaList;

    public TbMatrizCurricular() {
    }

    public TbMatrizCurricular(Long id) {
        this.id = id;
    }

    public TbMatrizCurricular(Long id, int ano) {
        this.id = id;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TbCurso getCursoId() {
        return cursoId;
    }

    public void setCursoId(TbCurso cursoId) {
        this.cursoId = cursoId;
    }

    @XmlTransient
    public List<TbDisciplina> getTbDisciplinaList() {
        return tbDisciplinaList;
    }

    public void setTbDisciplinaList(List<TbDisciplina> tbDisciplinaList) {
        this.tbDisciplinaList = tbDisciplinaList;
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
        if (!(object instanceof TbMatrizCurricular)) {
            return false;
        }
        TbMatrizCurricular other = (TbMatrizCurricular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbMatrizCurricular[ id=" + id + " ]";
    }
    
}
