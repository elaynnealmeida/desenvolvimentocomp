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
@Table(name = "tb_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDepartamento.findAll", query = "SELECT t FROM TbDepartamento t"),
    @NamedQuery(name = "TbDepartamento.findById", query = "SELECT t FROM TbDepartamento t WHERE t.id = :id"),
    @NamedQuery(name = "TbDepartamento.findByDescricao", query = "SELECT t FROM TbDepartamento t WHERE t.descricao = :descricao")})
public class TbDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "departamentoId")
    private List<TbCurso> tbCursoList;
    @JoinColumn(name = "campus_id", referencedColumnName = "id")
    @ManyToOne
    private TbCampus campusId;
    @OneToMany(mappedBy = "departamentoSuperiorId")
    private List<TbDepartamento> tbDepartamentoList;
    @JoinColumn(name = "departamento_superior_id", referencedColumnName = "id")
    @ManyToOne
    private TbDepartamento departamentoSuperiorId;

    public TbDepartamento() {
    }

    public TbDepartamento(Long id) {
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

    @XmlTransient
    public List<TbCurso> getTbCursoList() {
        return tbCursoList;
    }

    public void setTbCursoList(List<TbCurso> tbCursoList) {
        this.tbCursoList = tbCursoList;
    }

    public TbCampus getCampusId() {
        return campusId;
    }

    public void setCampusId(TbCampus campusId) {
        this.campusId = campusId;
    }

    @XmlTransient
    public List<TbDepartamento> getTbDepartamentoList() {
        return tbDepartamentoList;
    }

    public void setTbDepartamentoList(List<TbDepartamento> tbDepartamentoList) {
        this.tbDepartamentoList = tbDepartamentoList;
    }

    public TbDepartamento getDepartamentoSuperiorId() {
        return departamentoSuperiorId;
    }

    public void setDepartamentoSuperiorId(TbDepartamento departamentoSuperiorId) {
        this.departamentoSuperiorId = departamentoSuperiorId;
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
        if (!(object instanceof TbDepartamento)) {
            return false;
        }
        TbDepartamento other = (TbDepartamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbDepartamento[ id=" + id + " ]";
    }
    
}
