/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "site_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteHorario.findAll", query = "SELECT s FROM SiteHorario s"),
    @NamedQuery(name = "SiteHorario.findById", query = "SELECT s FROM SiteHorario s WHERE s.id = :id"),
    @NamedQuery(name = "SiteHorario.findByHoraInicio", query = "SELECT s FROM SiteHorario s WHERE s.horaInicio = :horaInicio"),
    @NamedQuery(name = "SiteHorario.findByHoraFim", query = "SELECT s FROM SiteHorario s WHERE s.horaFim = :horaFim"),
    @NamedQuery(name = "SiteHorario.findByDiaSemana", query = "SELECT s FROM SiteHorario s WHERE s.diaSemana = :diaSemana"),
    @NamedQuery(name = "SiteHorario.findByAtivo", query = "SELECT s FROM SiteHorario s WHERE s.ativo = :ativo")})
public class SiteHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Size(max = 2147483647)
    @Column(name = "hora_fim")
    private String horaFim;
    @Size(max = 2147483647)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "ativo")
    private Boolean ativo;
    @JoinColumn(name = "estagiario_id", referencedColumnName = "id")
    @ManyToOne
    private SiteEstagiarios estagiarioId;
    @JoinColumn(name = "sala", referencedColumnName = "id")
    @ManyToOne
    private TbSala sala;

    public SiteHorario() {
    }

    public SiteHorario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public SiteEstagiarios getEstagiarioId() {
        return estagiarioId;
    }

    public void setEstagiarioId(SiteEstagiarios estagiarioId) {
        this.estagiarioId = estagiarioId;
    }

    public TbSala getSala() {
        return sala;
    }

    public void setSala(TbSala sala) {
        this.sala = sala;
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
        if (!(object instanceof SiteHorario)) {
            return false;
        }
        SiteHorario other = (SiteHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.diaSemana+" Bloco: "+this.sala.getBlocoId().getDescricao()+" Sala: "+this.sala.getNomeSala()+" das "+this.horaInicio+" as "+this.horaFim;
    }
    
}
