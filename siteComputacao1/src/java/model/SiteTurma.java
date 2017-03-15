
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTurma.findAll", query = "SELECT s FROM SiteTurma s"),
    @NamedQuery(name = "SiteTurma.findById", query = "SELECT s FROM SiteTurma s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTurma.findByAnoLetivo", query = "SELECT s FROM SiteTurma s WHERE s.anoLetivo = :anoLetivo"),
    @NamedQuery(name = "SiteTurma.findBySemestreLetivo", query = "SELECT s FROM SiteTurma s WHERE s.semestreLetivo = :semestreLetivo"),
    @NamedQuery(name = "SiteTurma.findByPeriodo", query = "SELECT s FROM SiteTurma s WHERE s.periodo = :periodo"),
    @NamedQuery(name = "SiteTurma.findByTurmaB", query = "SELECT s FROM SiteTurma s WHERE s.turmaB = :turmaB")})
public class SiteTurma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ano_letivo")
    private Integer anoLetivo;
    @Column(name = "semestre_letivo")
    private Integer semestreLetivo;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "turma_b")
    private Boolean turmaB;
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id")
    @ManyToOne
    private TbDisciplina disciplinaId;
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores professorId;
    @OneToMany(mappedBy = "turmaId",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<SiteHorarioAula> siteHorarioAulaList;

    public SiteTurma() {
    }

    public SiteTurma(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Integer getSemestreLetivo() {
        return semestreLetivo;
    }

    public void setSemestreLetivo(Integer semestreLetivo) {
        this.semestreLetivo = semestreLetivo;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Boolean getTurmaB() {
        return turmaB;
    }

    public void setTurmaB(Boolean turmaB) {
        this.turmaB = turmaB;
    }

    public TbDisciplina getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(TbDisciplina disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public TbProfessores getProfessorId() {
        return professorId;
    }

    public void setProfessorId(TbProfessores professorId) {
        this.professorId = professorId;
    }

    @XmlTransient
    public List<SiteHorarioAula> getSiteHorarioAulaList() {
        return siteHorarioAulaList;
    }

    public void setSiteHorarioAulaList(List<SiteHorarioAula> siteHorarioAulaList) {
        this.siteHorarioAulaList = siteHorarioAulaList;
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
        if (!(object instanceof SiteTurma)) {
            return false;
        }
        SiteTurma other = (SiteTurma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteTurma[ id=" + id + " ]";
    }
    
}
