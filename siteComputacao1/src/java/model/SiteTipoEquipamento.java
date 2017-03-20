
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "site_tipo_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTipoEquipamento.findAll", query = "SELECT s FROM SiteTipoEquipamento s"),
    @NamedQuery(name = "SiteTipoEquipamento.findById", query = "SELECT s FROM SiteTipoEquipamento s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTipoEquipamento.findByDescricao", query = "SELECT s FROM SiteTipoEquipamento s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "SiteTipoEquipamento.findByNaturezaDaDespeza", query = "SELECT s FROM SiteTipoEquipamento s WHERE s.naturezaDaDespeza = :naturezaDaDespeza")})
public class SiteTipoEquipamento implements Serializable {

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
    @Column(name = "natureza_da_despeza")
    private String naturezaDaDespeza;
    @OneToMany(mappedBy = "tipo")
    private List<SiteEquipamento> siteEquipamentoList;

    public SiteTipoEquipamento() {
    }

    public SiteTipoEquipamento(Integer id) {
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

    public String getNaturezaDaDespeza() {
        return naturezaDaDespeza;
    }

    public void setNaturezaDaDespeza(String naturezaDaDespeza) {
        this.naturezaDaDespeza = naturezaDaDespeza;
    }

    @XmlTransient
    public List<SiteEquipamento> getSiteEquipamentoList() {
        return siteEquipamentoList;
    }

    public void setSiteEquipamentoList(List<SiteEquipamento> siteEquipamentoList) {
        this.siteEquipamentoList = siteEquipamentoList;
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
        if (!(object instanceof SiteTipoEquipamento)) {
            return false;
        }
        SiteTipoEquipamento other = (SiteTipoEquipamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteTipoEquipamento[ id=" + id + " ]";
    }
    
}
