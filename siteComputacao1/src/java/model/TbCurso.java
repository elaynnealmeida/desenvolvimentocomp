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
@Table(name = "tb_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCurso.findAll", query = "SELECT t FROM TbCurso t"),
    @NamedQuery(name = "TbCurso.findById", query = "SELECT t FROM TbCurso t WHERE t.id = :id"),
    @NamedQuery(name = "TbCurso.findByDescricao", query = "SELECT t FROM TbCurso t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbCurso.findByAutorizacao", query = "SELECT t FROM TbCurso t WHERE t.autorizacao = :autorizacao"),
    @NamedQuery(name = "TbCurso.findByCargaHoraria", query = "SELECT t FROM TbCurso t WHERE t.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "TbCurso.findByReconhecimento", query = "SELECT t FROM TbCurso t WHERE t.reconhecimento = :reconhecimento"),
    @NamedQuery(name = "TbCurso.findByRenovacao", query = "SELECT t FROM TbCurso t WHERE t.renovacao = :renovacao"),
    @NamedQuery(name = "TbCurso.findByModalidade", query = "SELECT t FROM TbCurso t WHERE t.modalidade = :modalidade"),
    @NamedQuery(name = "TbCurso.findByTurno", query = "SELECT t FROM TbCurso t WHERE t.turno = :turno"),
    @NamedQuery(name = "TbCurso.findByVagas", query = "SELECT t FROM TbCurso t WHERE t.vagas = :vagas")})
public class TbCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "autorizacao")
    private String autorizacao;
    @Size(max = 2147483647)
    @Column(name = "carga_horaria")
    private String cargaHoraria;
    @Size(max = 2147483647)
    @Column(name = "reconhecimento")
    private String reconhecimento;
    @Size(max = 2147483647)
    @Column(name = "renovacao")
    private String renovacao;
    @Size(max = 255)
    @Column(name = "modalidade")
    private String modalidade;
    @Size(max = 255)
    @Column(name = "turno")
    private String turno;
    @Size(max = 2147483647)
    @Column(name = "vagas")
    private String vagas;
    @OneToMany(mappedBy = "cursoId")
    private List<TbMatrizCurricular> tbMatrizCurricularList;
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    @ManyToOne
    private TbDepartamento departamentoId;
    @JoinColumn(name = "ppc_id", referencedColumnName = "id")
    @ManyToOne
    private TbPpc ppcId;

    public TbCurso() {
    }

    public TbCurso(Long id) {
        this.id = id;
    }

    public TbCurso(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getReconhecimento() {
        return reconhecimento;
    }

    public void setReconhecimento(String reconhecimento) {
        this.reconhecimento = reconhecimento;
    }

    public String getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(String renovacao) {
        this.renovacao = renovacao;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    @XmlTransient
    public List<TbMatrizCurricular> getTbMatrizCurricularList() {
        return tbMatrizCurricularList;
    }

    public void setTbMatrizCurricularList(List<TbMatrizCurricular> tbMatrizCurricularList) {
        this.tbMatrizCurricularList = tbMatrizCurricularList;
    }

    public TbDepartamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(TbDepartamento departamentoId) {
        this.departamentoId = departamentoId;
    }

    public TbPpc getPpcId() {
        return ppcId;
    }

    public void setPpcId(TbPpc ppcId) {
        this.ppcId = ppcId;
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
        if (!(object instanceof TbCurso)) {
            return false;
        }
        TbCurso other = (TbCurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbCurso[ id=" + id + " ]";
    }
    
}
