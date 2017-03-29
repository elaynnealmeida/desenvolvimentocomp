
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "site_equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteEquipamento.findAll", query = "SELECT s FROM SiteEquipamento s"),
    @NamedQuery(name = "SiteEquipamento.findById", query = "SELECT s FROM SiteEquipamento s WHERE s.id = :id"),
    @NamedQuery(name = "SiteEquipamento.findByNumPatrimonio", query = "SELECT s FROM SiteEquipamento s WHERE s.numPatrimonio = :numPatrimonio"),
    @NamedQuery(name = "SiteEquipamento.findByNome", query = "SELECT s FROM SiteEquipamento s WHERE s.nome = :nome"),
    @NamedQuery(name = "SiteEquipamento.findByDescricao", query = "SELECT s FROM SiteEquipamento s WHERE s.descricao = :descricao")})
public class SiteEquipamento implements Serializable {

   // @OneToMany(mappedBy = "equipamentoId")
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="site_infra_equipamentos", 
               joinColumns=  @JoinColumn( name = "equipamento_id" ), 
               inverseJoinColumns= @JoinColumn(name = "infraestrutura_id") )
    private List<SiteInfraEquipamentos> siteInfraEquipamentosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "num_patrimonio")
    private String numPatrimonio;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private SiteTipoEquipamento tipo;

    public SiteEquipamento() {
    }

    public SiteEquipamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(String numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SiteTipoEquipamento getTipo() {
        return tipo;
    }

    public void setTipo(SiteTipoEquipamento tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof SiteEquipamento)) {
            return false;
        }
        SiteEquipamento other = (SiteEquipamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteEquipamento[ id=" + id + " ]";
    }

    @XmlTransient
    public List<SiteInfraEquipamentos> getSiteInfraEquipamentosList() {
        return siteInfraEquipamentosList;
    }

    public void setSiteInfraEquipamentosList(List<SiteInfraEquipamentos> siteInfraEquipamentosList) {
        this.siteInfraEquipamentosList = siteInfraEquipamentosList;
    }
    
}
