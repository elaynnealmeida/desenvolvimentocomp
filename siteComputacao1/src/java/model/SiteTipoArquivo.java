
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_tipo_arquivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTipoArquivo.findAll", query = "SELECT s FROM SiteTipoArquivo s"),
    @NamedQuery(name = "SiteTipoArquivo.findById", query = "SELECT s FROM SiteTipoArquivo s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTipoArquivo.findByDescricao", query = "SELECT s FROM SiteTipoArquivo s WHERE s.descricao = :descricao")})
public class SiteTipoArquivo implements Serializable {

    @OneToMany(mappedBy = "tipoDocumento")
    private List<SiteDocumento> siteDocumentoList;

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

    public SiteTipoArquivo() {
    }

    public SiteTipoArquivo(Integer id) {
        this.id = id;
    }

    public SiteTipoArquivo(Integer id, String descricao) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteTipoArquivo)) {
            return false;
        }
        SiteTipoArquivo other = (SiteTipoArquivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteTipoArquivo[ id=" + id + " ]";
    }

    @XmlTransient
    public List<SiteDocumento> getSiteDocumentoList() {
        return siteDocumentoList;
    }

    public void setSiteDocumentoList(List<SiteDocumento> siteDocumentoList) {
        this.siteDocumentoList = siteDocumentoList;
    }
    
}
