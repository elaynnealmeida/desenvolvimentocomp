
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
@Table(name = "site_links")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteLinks.findAll", query = "SELECT s FROM SiteLinks s"),
    @NamedQuery(name = "SiteLinks.findById", query = "SELECT s FROM SiteLinks s WHERE s.id = :id"),
    @NamedQuery(name = "SiteLinks.findByDescricao", query = "SELECT s FROM SiteLinks s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "SiteLinks.findByLink", query = "SELECT s FROM SiteLinks s WHERE s.link = :link")})
public class SiteLinks implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "link")
    private String link;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private TbUsersystem usuarioId;

    public SiteLinks() {
    }

    public SiteLinks(Integer id) {
        this.id = id;
    }

    public SiteLinks(Integer id, String descricao, String link) {
        this.id = id;
        this.descricao = descricao;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TbUsersystem getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(TbUsersystem usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof SiteLinks)) {
            return false;
        }
        SiteLinks other = (SiteLinks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteLinks[ id=" + id + " ]";
    }
    
}
