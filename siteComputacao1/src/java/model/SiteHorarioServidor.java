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
@Table(name = "site_horario_servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteHorarioServidor.findAll", query = "SELECT s FROM SiteHorarioServidor s"),
    @NamedQuery(name = "SiteHorarioServidor.findById", query = "SELECT s FROM SiteHorarioServidor s WHERE s.id = :id"),
    @NamedQuery(name = "SiteHorarioServidor.findByHoraInicio", query = "SELECT s FROM SiteHorarioServidor s WHERE s.horaInicio = :horaInicio"),
    @NamedQuery(name = "SiteHorarioServidor.findByHoraFim", query = "SELECT s FROM SiteHorarioServidor s WHERE s.horaFim = :horaFim"),
    @NamedQuery(name = "SiteHorarioServidor.findByDiaSemana", query = "SELECT s FROM SiteHorarioServidor s WHERE s.diaSemana = :diaSemana"),
    @NamedQuery(name = "SiteHorarioServidor.findByAtivo", query = "SELECT s FROM SiteHorarioServidor s WHERE s.ativo = :ativo"),
    @NamedQuery(name = "SiteHorarioServidor.findBySemestre", query = "SELECT s FROM SiteHorarioServidor s WHERE s.semestre = :semestre"),
    @NamedQuery(name = "SiteHorarioServidor.findByAno", query = "SELECT s FROM SiteHorarioServidor s WHERE s.ano = :ano"),
    @NamedQuery(name = "SiteHorarioServidor.findByDia", query = "SELECT s FROM SiteHorarioServidor s WHERE s.dia = :dia")})
public class SiteHorarioServidor implements Serializable {

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
    @Column(name = "semestre")
    private Integer semestre;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "dia")
    private Integer dia;
    @JoinColumn(name = "servidor_id", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores servidorId;
    @JoinColumn(name = "sala", referencedColumnName = "id")
    @ManyToOne
    private TbSala sala;

    public SiteHorarioServidor() {
    }

    public SiteHorarioServidor(Integer id) {
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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public TbProfessores getServidorId() {
        return servidorId;
    }

    public void setServidorId(TbProfessores servidorId) {
        this.servidorId = servidorId;
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
        if (!(object instanceof SiteHorarioServidor)) {
            return false;
        }
        SiteHorarioServidor other = (SiteHorarioServidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteHorarioServidor[ id=" + id + " ]";
    }
    
}
