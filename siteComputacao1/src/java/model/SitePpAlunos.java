
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_pp_alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitePpAlunos.findAll", query = "SELECT s FROM SitePpAlunos s")
    , @NamedQuery(name = "SitePpAlunos.findById", query = "SELECT s FROM SitePpAlunos s WHERE s.id = :id")})
public class SitePpAlunos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "aluno", referencedColumnName = "id")
    @ManyToOne
    private SiteAluno aluno;
    @JoinColumn(name = "pp", referencedColumnName = "id")
    @ManyToOne
    private SiteProjPesquisa pp;

    public SitePpAlunos() {
    }

    public SitePpAlunos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SiteAluno getAluno() {
        return aluno;
    }

    public void setAluno(SiteAluno aluno) {
        this.aluno = aluno;
    }

    public SiteProjPesquisa getPp() {
        return pp;
    }

    public void setPp(SiteProjPesquisa pp) {
        this.pp = pp;
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
        if (!(object instanceof SitePpAlunos)) {
            return false;
        }
        SitePpAlunos other = (SitePpAlunos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SitePpAlunos[ id=" + id + " ]";
    }
    
}
