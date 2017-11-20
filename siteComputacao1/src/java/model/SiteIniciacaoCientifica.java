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
@Table(name = "site_iniciacao_cientifica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteIniciacaoCientifica.findAll", query = "SELECT s FROM SiteIniciacaoCientifica s")
    , @NamedQuery(name = "SiteIniciacaoCientifica.findById", query = "SELECT s FROM SiteIniciacaoCientifica s WHERE s.id = :id")
    , @NamedQuery(name = "SiteIniciacaoCientifica.findByDescricao", query = "SELECT s FROM SiteIniciacaoCientifica s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "SiteIniciacaoCientifica.findByDtInicio", query = "SELECT s FROM SiteIniciacaoCientifica s WHERE s.dtInicio = :dtInicio")
    , @NamedQuery(name = "SiteIniciacaoCientifica.findByDtFim", query = "SELECT s FROM SiteIniciacaoCientifica s WHERE s.dtFim = :dtFim")
    , @NamedQuery(name = "SiteIniciacaoCientifica.findByTitulo", query = "SELECT s FROM SiteIniciacaoCientifica s WHERE s.titulo = :titulo")})
public class SiteIniciacaoCientifica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 2147483647)
    @Column(name = "dt_inicio")
    private String dtInicio;
    @Size(max = 2147483647)
    @Column(name = "dt_fim")
    private String dtFim;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "academico", referencedColumnName = "id")
    @ManyToOne
    private SiteAluno academico;
    @JoinColumn(name = "modal", referencedColumnName = "id")
    @ManyToOne
    private SiteModulo modal;
    @JoinColumn(name = "coordenador", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores coordenador;

    public SiteIniciacaoCientifica() {
    }

    public SiteIniciacaoCientifica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDtFim() {
        return dtFim;
    }

    public void setDtFim(String dtFim) {
        this.dtFim = dtFim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public SiteAluno getAcademico() {
        return academico;
    }

    public void setAcademico(SiteAluno academico) {
        this.academico = academico;
    }

    public SiteModulo getModal() {
        return modal;
    }

    public void setModal(SiteModulo modal) {
        this.modal = modal;
    }

    public TbProfessores getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(TbProfessores coordenador) {
        this.coordenador = coordenador;
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
        if (!(object instanceof SiteIniciacaoCientifica)) {
            return false;
        }
        SiteIniciacaoCientifica other = (SiteIniciacaoCientifica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteIniciacaoCientifica[ id=" + id + " ]";
    }
    
}
