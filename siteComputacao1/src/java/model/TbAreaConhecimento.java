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
@Table(name = "tb_area_conhecimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAreaConhecimento.findAll", query = "SELECT t FROM TbAreaConhecimento t"),
    @NamedQuery(name = "TbAreaConhecimento.findById", query = "SELECT t FROM TbAreaConhecimento t WHERE t.id = :id"),
    @NamedQuery(name = "TbAreaConhecimento.findByDescricao", query = "SELECT t FROM TbAreaConhecimento t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbAreaConhecimento.findByCor", query = "SELECT t FROM TbAreaConhecimento t WHERE t.cor = :cor")})
public class TbAreaConhecimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "cor")
    private String cor;
    @OneToMany(mappedBy = "areaConhecimentoId")
    private List<TbDisciplina> tbDisciplinaList;

    public TbAreaConhecimento() {
    }

    public TbAreaConhecimento(Long id) {
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
        if (!(object instanceof TbAreaConhecimento)) {
            return false;
        }
        TbAreaConhecimento other = (TbAreaConhecimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbAreaConhecimento[ id=" + id + " ]";
    }
    
}
