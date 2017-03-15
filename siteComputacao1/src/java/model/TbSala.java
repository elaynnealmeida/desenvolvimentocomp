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
@Table(name = "tb_sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSala.findAll", query = "SELECT t FROM TbSala t"),
    @NamedQuery(name = "TbSala.findById", query = "SELECT t FROM TbSala t WHERE t.id = :id"),
    @NamedQuery(name = "TbSala.findByNomeSala", query = "SELECT t FROM TbSala t WHERE t.nomeSala = :nomeSala"),
    @NamedQuery(name = "TbSala.findByTipoSala", query = "SELECT t FROM TbSala t WHERE t.tipoSala = :tipoSala")})
public class TbSala implements Serializable {

    @OneToMany(mappedBy = "salaId")
    private List<SiteHorarioAula> siteHorarioAulaList;

    @OneToMany(mappedBy = "sala")
    private List<SiteHorarioServidor> siteHorarioServidorList;

    @OneToMany(mappedBy = "sala")
    private List<SiteHorarioMonitor> siteHorarioMonitorList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "nome_sala")
    private String nomeSala;
    @Size(max = 255)
    @Column(name = "tipo_sala")
    private String tipoSala;
    @JoinColumn(name = "bloco_id", referencedColumnName = "id")
    @ManyToOne
    private TbBloco blocoId;
    @OneToMany(mappedBy = "sala")
    private List<SiteHorario> siteHorarioList;

    public TbSala() {
    }

    public TbSala(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public TbBloco getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(TbBloco blocoId) {
        this.blocoId = blocoId;
    }

    @XmlTransient
    public List<SiteHorario> getSiteHorarioList() {
        return siteHorarioList;
    }

    public void setSiteHorarioList(List<SiteHorario> siteHorarioList) {
        this.siteHorarioList = siteHorarioList;
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
        if (!(object instanceof TbSala)) {
            return false;
        }
        TbSala other = (TbSala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbSala[ id=" + id + " ]";
    }

    @XmlTransient
    public List<SiteHorarioMonitor> getSiteHorarioMonitorList() {
        return siteHorarioMonitorList;
    }

    public void setSiteHorarioMonitorList(List<SiteHorarioMonitor> siteHorarioMonitorList) {
        this.siteHorarioMonitorList = siteHorarioMonitorList;
    }

    @XmlTransient
    public List<SiteHorarioServidor> getSiteHorarioServidorList() {
        return siteHorarioServidorList;
    }

    public void setSiteHorarioServidorList(List<SiteHorarioServidor> siteHorarioServidorList) {
        this.siteHorarioServidorList = siteHorarioServidorList;
    }

    @XmlTransient
    public List<SiteHorarioAula> getSiteHorarioAulaList() {
        return siteHorarioAulaList;
    }

    public void setSiteHorarioAulaList(List<SiteHorarioAula> siteHorarioAulaList) {
        this.siteHorarioAulaList = siteHorarioAulaList;
    }
    
}
