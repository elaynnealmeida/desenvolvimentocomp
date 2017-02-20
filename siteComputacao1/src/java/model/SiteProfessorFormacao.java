
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
@Table(name = "site_professor_formacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteProfessorFormacao.findAll", query = "SELECT s FROM SiteProfessorFormacao s"),
    @NamedQuery(name = "SiteProfessorFormacao.findById", query = "SELECT s FROM SiteProfessorFormacao s WHERE s.id = :id"),
    @NamedQuery(name = "SiteProfessorFormacao.findByDescricao", query = "SELECT s FROM SiteProfessorFormacao s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "SiteProfessorFormacao.findByDtInicio", query = "SELECT s FROM SiteProfessorFormacao s WHERE s.dtInicio = :dtInicio"),
    @NamedQuery(name = "SiteProfessorFormacao.findByDtFim", query = "SELECT s FROM SiteProfessorFormacao s WHERE s.dtFim = :dtFim")})
public class SiteProfessorFormacao implements Serializable {

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
    @Column(name = "dt_fim2")
    private int dtFim2;
    @JoinColumn(name = "formacao_id", referencedColumnName = "id")
    @ManyToOne
    private SiteFormacao formacaoId;
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @ManyToOne
    private TbProfessores professorId;

    public SiteProfessorFormacao() {
    }

    public SiteProfessorFormacao(Integer id) {
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

    public int getDtFim2() {
        return dtFim2;
    }

    public void setDtFim2(int dtFim2) {
        this.dtFim2 = dtFim2;
    }

    public SiteFormacao getFormacaoId() {
        return formacaoId;
    }

    public void setFormacaoId(SiteFormacao formacaoId) {
        this.formacaoId = formacaoId;
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
        if (!(object instanceof SiteProfessorFormacao)) {
            return false;
        }
        SiteProfessorFormacao other = (SiteProfessorFormacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteProfessorFormacao[ id=" + id + " ]";
    }
    
}
