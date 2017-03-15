
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
@Table(name = "site_horario_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteHorarioAula.findAll", query = "SELECT s FROM SiteHorarioAula s"),
    @NamedQuery(name = "SiteHorarioAula.findById", query = "SELECT s FROM SiteHorarioAula s WHERE s.id = :id"),
    @NamedQuery(name = "SiteHorarioAula.findByHoraInicio", query = "SELECT s FROM SiteHorarioAula s WHERE s.horaInicio = :horaInicio"),
    @NamedQuery(name = "SiteHorarioAula.findByHoraFim", query = "SELECT s FROM SiteHorarioAula s WHERE s.horaFim = :horaFim"),
    @NamedQuery(name = "SiteHorarioAula.findByDia", query = "SELECT s FROM SiteHorarioAula s WHERE s.dia = :dia"),
    @NamedQuery(name = "SiteHorarioAula.findByDiaSemana", query = "SELECT s FROM SiteHorarioAula s WHERE s.diaSemana = :diaSemana"),
    @NamedQuery(name = "SiteHorarioAula.findByAtivo", query = "SELECT s FROM SiteHorarioAula s WHERE s.ativo = :ativo")})
public class SiteHorarioAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Size(max = 2147483647)
    @Column(name = "hora_fim")
    private String horaFim;
    @Column(name = "dia")
    private Integer dia;
    @Size(max = 2147483647)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "ativo")
    private Boolean ativo;
    @JoinColumn(name = "turma_id", referencedColumnName = "id")
    @ManyToOne
    private SiteTurma turmaId;
    @JoinColumn(name = "sala_id", referencedColumnName = "id")
    @ManyToOne
    private TbSala salaId;

    public SiteHorarioAula() {
    }

    public SiteHorarioAula(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
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

    public SiteTurma getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(SiteTurma turmaId) {
        this.turmaId = turmaId;
    }

    public TbSala getSalaId() {
        return salaId;
    }

    public void setSalaId(TbSala salaId) {
        this.salaId = salaId;
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
        if (!(object instanceof SiteHorarioAula)) {
            return false;
        }
        SiteHorarioAula other = (SiteHorarioAula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteHorarioAula[ id=" + id + " ]";
    }
    
}
