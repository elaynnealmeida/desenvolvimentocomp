
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
@Table(name = "site_funcao_professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteFuncaoProfessor.findAll", query = "SELECT s FROM SiteFuncaoProfessor s"),
    @NamedQuery(name = "SiteFuncaoProfessor.findById", query = "SELECT s FROM SiteFuncaoProfessor s WHERE s.id = :id"),
    @NamedQuery(name = "SiteFuncaoProfessor.findByDtInicio", query = "SELECT s FROM SiteFuncaoProfessor s WHERE s.dtInicio = :dtInicio"),
    @NamedQuery(name = "SiteFuncaoProfessor.findByDtFim", query = "SELECT s FROM SiteFuncaoProfessor s WHERE s.dtFim = :dtFim")})
public class SiteFuncaoProfessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "dt_inicio")
    private String dtInicio;
    @Size(max = 2147483647)
    @Column(name = "dt_fim")
    private String dtFim;
    @JoinColumn(name = "funcao_id", referencedColumnName = "id")
    @ManyToOne
    private SiteFuncao funcaoId;
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores professorId;

    public SiteFuncaoProfessor() {
    }

    public SiteFuncaoProfessor(Integer id) {
        this.id = id;
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

    public SiteFuncao getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(SiteFuncao funcaoId) {
        this.funcaoId = funcaoId;
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
        if (!(object instanceof SiteFuncaoProfessor)) {
            return false;
        }
        SiteFuncaoProfessor other = (SiteFuncaoProfessor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteFuncaoProfessor[ id=" + id + " ]";
    }
    
}
