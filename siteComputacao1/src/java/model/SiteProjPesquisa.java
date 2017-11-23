/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_proj_pesquisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteProjPesquisa.findAll", query = "SELECT s FROM SiteProjPesquisa s")
    , @NamedQuery(name = "SiteProjPesquisa.findById", query = "SELECT s FROM SiteProjPesquisa s WHERE s.id = :id")
    , @NamedQuery(name = "SiteProjPesquisa.findByNumRegistro", query = "SELECT s FROM SiteProjPesquisa s WHERE s.numRegistro = :numRegistro")
    , @NamedQuery(name = "SiteProjPesquisa.findByPesquisaCSeresHumanos", query = "SELECT s FROM SiteProjPesquisa s WHERE s.pesquisaCSeresHumanos = :pesquisaCSeresHumanos")
    , @NamedQuery(name = "SiteProjPesquisa.findByPesquisaCAnimais", query = "SELECT s FROM SiteProjPesquisa s WHERE s.pesquisaCAnimais = :pesquisaCAnimais")
    , @NamedQuery(name = "SiteProjPesquisa.findByTitulo", query = "SELECT s FROM SiteProjPesquisa s WHERE s.titulo = :titulo")
    , @NamedQuery(name = "SiteProjPesquisa.findByPalavrasChaves", query = "SELECT s FROM SiteProjPesquisa s WHERE s.palavrasChaves = :palavrasChaves")
    , @NamedQuery(name = "SiteProjPesquisa.findByAreaConhecimento", query = "SELECT s FROM SiteProjPesquisa s WHERE s.areaConhecimento = :areaConhecimento")
    , @NamedQuery(name = "SiteProjPesquisa.findBySubareas", query = "SELECT s FROM SiteProjPesquisa s WHERE s.subareas = :subareas")
    , @NamedQuery(name = "SiteProjPesquisa.findByLinhaDePesquisa", query = "SELECT s FROM SiteProjPesquisa s WHERE s.linhaDePesquisa = :linhaDePesquisa")
    , @NamedQuery(name = "SiteProjPesquisa.findByResumoObjetivos", query = "SELECT s FROM SiteProjPesquisa s WHERE s.resumoObjetivos = :resumoObjetivos")
    , @NamedQuery(name = "SiteProjPesquisa.findByLocalExecucao", query = "SELECT s FROM SiteProjPesquisa s WHERE s.localExecucao = :localExecucao")
    , @NamedQuery(name = "SiteProjPesquisa.findByDataInicio", query = "SELECT s FROM SiteProjPesquisa s WHERE s.dataInicio = :dataInicio")
    , @NamedQuery(name = "SiteProjPesquisa.findByDataFim", query = "SELECT s FROM SiteProjPesquisa s WHERE s.dataFim = :dataFim")
    , @NamedQuery(name = "SiteProjPesquisa.findByLocalSetor", query = "SELECT s FROM SiteProjPesquisa s WHERE s.localSetor = :localSetor")
    , @NamedQuery(name = "SiteProjPesquisa.findByAtivo", query = "SELECT s FROM SiteProjPesquisa s WHERE s.ativo = :ativo")
    , @NamedQuery(name = "SiteProjPesquisa.findByGrupoPesquisa", query = "SELECT s FROM SiteProjPesquisa s WHERE s.grupoPesquisa = :grupoPesquisa")})
public class SiteProjPesquisa implements Serializable {

    @Size(max = 2147483647)
    @Column(name = "financiamento")
    private String financiamento;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "num_registro")
    private String numRegistro;
    @Column(name = "pesquisa_c_seres_humanos")
    private Boolean pesquisaCSeresHumanos;
    @Column(name = "pesquisa_c_animais")
    private Boolean pesquisaCAnimais;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "palavras_chaves")
    private String palavrasChaves;
    @Size(max = 2147483647)
    @Column(name = "area_conhecimento")
    private String areaConhecimento;
    @Size(max = 2147483647)
    @Column(name = "subareas")
    private String subareas;
    @Size(max = 2147483647)
    @Column(name = "linha_de_pesquisa")
    private String linhaDePesquisa;
    @Size(max = 2147483647)
    @Column(name = "resumo_objetivos")
    private String resumoObjetivos;
    @Size(max = 2147483647)
    @Column(name = "local_execucao")
    private String localExecucao;
    @Size(max = 2147483647)
    @Column(name = "data_inicio")
    private String dataInicio;
    @Size(max = 2147483647)
    @Column(name = "data_fim")
    private String dataFim;
    @Size(max = 2147483647)
    @Column(name = "local_setor")
    private String localSetor;
    @Column(name = "ativo")
    private Boolean ativo;
    @Size(max = 2147483647)
    @Column(name = "grupo_pesquisa")
    private String grupoPesquisa;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "site_pp_alunos",
            joinColumns = @JoinColumn(name = "pp"),
            inverseJoinColumns = @JoinColumn(name = "aluno"))
    private List<SiteAluno> sitePpAlunosList;
   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "site_pp_profpesquisador",
            joinColumns = @JoinColumn(name = "pp"),
            inverseJoinColumns = @JoinColumn(name = "prof_pesquisador"))
    private List<TbProfessores> sitePpProfpesquisadorList;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "site_pp_coordenador",
            joinColumns = @JoinColumn(name = "pp"),
            inverseJoinColumns = @JoinColumn(name = "coordenador"))
    private List<TbProfessores> sitePpCoordenadorList;

    public SiteProjPesquisa() {
    }

    public SiteProjPesquisa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public Boolean getPesquisaCSeresHumanos() {
        return pesquisaCSeresHumanos;
    }

    public void setPesquisaCSeresHumanos(Boolean pesquisaCSeresHumanos) {
        this.pesquisaCSeresHumanos = pesquisaCSeresHumanos;
    }

    public Boolean getPesquisaCAnimais() {
        return pesquisaCAnimais;
    }

    public void setPesquisaCAnimais(Boolean pesquisaCAnimais) {
        this.pesquisaCAnimais = pesquisaCAnimais;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public String getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public String getSubareas() {
        return subareas;
    }

    public void setSubareas(String subareas) {
        this.subareas = subareas;
    }

    public String getLinhaDePesquisa() {
        return linhaDePesquisa;
    }

    public void setLinhaDePesquisa(String linhaDePesquisa) {
        this.linhaDePesquisa = linhaDePesquisa;
    }

    public String getResumoObjetivos() {
        return resumoObjetivos;
    }

    public void setResumoObjetivos(String resumoObjetivos) {
        this.resumoObjetivos = resumoObjetivos;
    }

    public String getLocalExecucao() {
        return localExecucao;
    }

    public void setLocalExecucao(String localExecucao) {
        this.localExecucao = localExecucao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocalSetor() {
        return localSetor;
    }

    public void setLocalSetor(String localSetor) {
        this.localSetor = localSetor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getGrupoPesquisa() {
        return grupoPesquisa;
    }

    public void setGrupoPesquisa(String grupoPesquisa) {
        this.grupoPesquisa = grupoPesquisa;
    }

    @XmlTransient
    public List<SiteAluno> getSitePpAlunosList() {
        return sitePpAlunosList;
    }

    public void setSitePpAlunosList(List<SiteAluno> sitePpAlunosList) {
        this.sitePpAlunosList = sitePpAlunosList;
    }
    @XmlTransient
    public List<TbProfessores> getSitePpProfpesquisadorList() {
        return sitePpProfpesquisadorList;
    }

    public void setSitePpProfpesquisadorList(List<TbProfessores> sitePpProfpesquisadorList) {
        this.sitePpProfpesquisadorList = sitePpProfpesquisadorList;
    }

    @XmlTransient
    public List<TbProfessores> getSitePpCoordenadorList() {
        return sitePpCoordenadorList;
    }

    public void setSitePpCoordenadorList(List<TbProfessores> sitePpCoordenadorList) {
        this.sitePpCoordenadorList = sitePpCoordenadorList;
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
        if (!(object instanceof SiteProjPesquisa)) {
            return false;
        }
        SiteProjPesquisa other = (SiteProjPesquisa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteProjPesquisa[ id=" + id + " ]";
    }

    public String getFinanciamento() {
        return financiamento;
    }

    public void setFinanciamento(String financiamento) {
        this.financiamento = financiamento;
    }
    
}
