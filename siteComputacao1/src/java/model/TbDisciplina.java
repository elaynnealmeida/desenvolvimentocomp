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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDisciplina.findAll", query = "SELECT t FROM TbDisciplina t"),
    @NamedQuery(name = "TbDisciplina.findById", query = "SELECT t FROM TbDisciplina t WHERE t.id = :id"),
    @NamedQuery(name = "TbDisciplina.findByChPratica", query = "SELECT t FROM TbDisciplina t WHERE t.chPratica = :chPratica"),
    @NamedQuery(name = "TbDisciplina.findByChTeorica", query = "SELECT t FROM TbDisciplina t WHERE t.chTeorica = :chTeorica"),
    @NamedQuery(name = "TbDisciplina.findByDescricao", query = "SELECT t FROM TbDisciplina t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TbDisciplina.findByEmenta", query = "SELECT t FROM TbDisciplina t WHERE t.ementa = :ementa"),
    @NamedQuery(name = "TbDisciplina.findByObjetivoEspecifico", query = "SELECT t FROM TbDisciplina t WHERE t.objetivoEspecifico = :objetivoEspecifico"),
    @NamedQuery(name = "TbDisciplina.findByObjetivoGeral", query = "SELECT t FROM TbDisciplina t WHERE t.objetivoGeral = :objetivoGeral"),
    @NamedQuery(name = "TbDisciplina.findByPeriodoIdeal", query = "SELECT t FROM TbDisciplina t WHERE t.periodoIdeal = :periodoIdeal"),
    @NamedQuery(name = "TbDisciplina.findByCredito", query = "SELECT t FROM TbDisciplina t WHERE t.credito = :credito"),
    @NamedQuery(name = "TbDisciplina.findByTipoDisciplina", query = "SELECT t FROM TbDisciplina t WHERE t.tipoDisciplina = :tipoDisciplina"),
    @NamedQuery(name = "TbDisciplina.findByCodigoSie", query = "SELECT t FROM TbDisciplina t WHERE t.codigoSie = :codigoSie"),
    @NamedQuery(name = "TbDisciplina.findByPosicao", query = "SELECT t FROM TbDisciplina t WHERE t.posicao = :posicao")})
public class TbDisciplina implements Serializable {

    @OneToMany(mappedBy = "disciplinaId")
    private List<SiteTurma> siteTurmaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ch_pratica")
    private Integer chPratica;
    @Column(name = "ch_teorica")
    private Integer chTeorica;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "ementa")
    private String ementa;
    @Size(max = 2147483647)
    @Column(name = "objetivo_especifico")
    private String objetivoEspecifico;
    @Size(max = 2147483647)
    @Column(name = "objetivo_geral")
    private String objetivoGeral;
    @Column(name = "periodo_ideal")
    private Integer periodoIdeal;
    @Column(name = "credito")
    private Integer credito;
    @Size(max = 255)
    @Column(name = "tipo_disciplina")
    private String tipoDisciplina;
    @Size(max = 255)
    @Column(name = "codigo_sie")
    private String codigoSie;
    @Column(name = "posicao")
    private Integer posicao;
    @JoinTable(name = "tb_disciplina_pre_requisito", joinColumns = {
        @JoinColumn(name = "disciplina_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "disciplina_pre_requisito_id", referencedColumnName = "id")})
    @ManyToMany
    private List<TbDisciplina> tbDisciplinaList;
    @ManyToMany(mappedBy = "tbDisciplinaList")
    private List<TbDisciplina> tbDisciplinaList1;
    @OneToMany(mappedBy = "disciplina")
    private List<SiteMonitor> siteMonitorList;
    @JoinColumn(name = "area_conhecimento_id", referencedColumnName = "id")
    @ManyToOne
    private TbAreaConhecimento areaConhecimentoId;
    @JoinColumn(name = "matriz_curricular_id", referencedColumnName = "id")
    @ManyToOne
    private TbMatrizCurricular matrizCurricularId;

    public TbDisciplina() {
    }

    public TbDisciplina(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChPratica() {
        return chPratica;
    }

    public void setChPratica(Integer chPratica) {
        this.chPratica = chPratica;
    }

    public Integer getChTeorica() {
        return chTeorica;
    }

    public void setChTeorica(Integer chTeorica) {
        this.chTeorica = chTeorica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getObjetivoGeral() {
        return objetivoGeral;
    }

    public void setObjetivoGeral(String objetivoGeral) {
        this.objetivoGeral = objetivoGeral;
    }

    public Integer getPeriodoIdeal() {
        return periodoIdeal;
    }

    public void setPeriodoIdeal(Integer periodoIdeal) {
        this.periodoIdeal = periodoIdeal;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(String tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    public String getCodigoSie() {
        return codigoSie;
    }

    public void setCodigoSie(String codigoSie) {
        this.codigoSie = codigoSie;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @XmlTransient
    public List<TbDisciplina> getTbDisciplinaList() {
        return tbDisciplinaList;
    }

    public void setTbDisciplinaList(List<TbDisciplina> tbDisciplinaList) {
        this.tbDisciplinaList = tbDisciplinaList;
    }

    @XmlTransient
    public List<TbDisciplina> getTbDisciplinaList1() {
        return tbDisciplinaList1;
    }

    public void setTbDisciplinaList1(List<TbDisciplina> tbDisciplinaList1) {
        this.tbDisciplinaList1 = tbDisciplinaList1;
    }

    @XmlTransient
    public List<SiteMonitor> getSiteMonitorList() {
        return siteMonitorList;
    }

    public void setSiteMonitorList(List<SiteMonitor> siteMonitorList) {
        this.siteMonitorList = siteMonitorList;
    }

    public TbAreaConhecimento getAreaConhecimentoId() {
        return areaConhecimentoId;
    }

    public void setAreaConhecimentoId(TbAreaConhecimento areaConhecimentoId) {
        this.areaConhecimentoId = areaConhecimentoId;
    }

    public TbMatrizCurricular getMatrizCurricularId() {
        return matrizCurricularId;
    }

    public void setMatrizCurricularId(TbMatrizCurricular matrizCurricularId) {
        this.matrizCurricularId = matrizCurricularId;
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
        if (!(object instanceof TbDisciplina)) {
            return false;
        }
        TbDisciplina other = (TbDisciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbDisciplina[ id=" + id + " ]";
    }

    @XmlTransient
    public List<SiteTurma> getSiteTurmaList() {
        return siteTurmaList;
    }

    public void setSiteTurmaList(List<SiteTurma> siteTurmaList) {
        this.siteTurmaList = siteTurmaList;
    }
    
}
