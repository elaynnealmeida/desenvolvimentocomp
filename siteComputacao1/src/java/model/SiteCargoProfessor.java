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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_cargo_professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteCargoProfessor.findAll", query = "SELECT s FROM SiteCargoProfessor s"),
    @NamedQuery(name = "SiteCargoProfessor.findById", query = "SELECT s FROM SiteCargoProfessor s WHERE s.id = :id"),
    @NamedQuery(name = "SiteCargoProfessor.findByDtInicio", query = "SELECT s FROM SiteCargoProfessor s WHERE s.dtInicio = :dtInicio"),
    @NamedQuery(name = "SiteCargoProfessor.findByDtFim", query = "SELECT s FROM SiteCargoProfessor s WHERE s.dtFim = :dtFim")})
public class SiteCargoProfessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dt_inicio")
    private String dtInicio;
    @Size(max = 2147483647)
    @Column(name = "dt_fim")
    private String dtFim;
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SiteCargo cargoId;
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbProfessores professorId;

    public SiteCargoProfessor() {
    }

    public SiteCargoProfessor(Integer id) {
        this.id = id;
    }

    public SiteCargoProfessor(Integer id, String dtInicio) {
        this.id = id;
        this.dtInicio = dtInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public SiteCargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(SiteCargo cargoId) {
        this.cargoId = cargoId;
    }

    public TbProfessores getProfessorId() {
        return professorId;
    }

    public void setProfessorId(TbProfessores professorId) {
        this.professorId = professorId;
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
        if (!(object instanceof SiteCargoProfessor)) {
            return false;
        }
        SiteCargoProfessor other = (SiteCargoProfessor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteCargoProfessor[ id=" + id + " ]";
    }
    
}
