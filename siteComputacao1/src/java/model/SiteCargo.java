
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteCargo.findAll", query = "SELECT s FROM SiteCargo s"),
    @NamedQuery(name = "SiteCargo.findById", query = "SELECT s FROM SiteCargo s WHERE s.id = :id"),
    @NamedQuery(name = "SiteCargo.findByDescricao", query = "SELECT s FROM SiteCargo s WHERE s.descricao = :descricao")})
public class SiteCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
   @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "cargoId")
    private List<SiteCargoProfessor> siteCargoProfessorList;

    public SiteCargo() {
    }

    public SiteCargo(Integer id) {
        this.id = id;
    }

    public SiteCargo(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    @XmlTransient
    public List<SiteCargoProfessor> getSiteCargoProfessorList() {
        return siteCargoProfessorList;
    }

    public void setSiteCargoProfessorList(List<SiteCargoProfessor> siteCargoProfessorList) {
        this.siteCargoProfessorList = siteCargoProfessorList;
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
        if (!(object instanceof SiteCargo)) {
            return false;
        }
        SiteCargo other = (SiteCargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteCargo[ id=" + id + " ]";
    }
    
}
