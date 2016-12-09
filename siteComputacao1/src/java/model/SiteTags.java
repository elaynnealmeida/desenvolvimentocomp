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
@Table(name = "site_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteTags.findAll", query = "SELECT s FROM SiteTags s"),
    @NamedQuery(name = "SiteTags.findById", query = "SELECT s FROM SiteTags s WHERE s.id = :id"),
    @NamedQuery(name = "SiteTags.findByDescricao", query = "SELECT s FROM SiteTags s WHERE s.descricao = :descricao")})
public class SiteTags implements Serializable {

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
   @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="site_noticia_tags", 
               joinColumns=  @JoinColumn( name = "tag_id" ), 
               inverseJoinColumns= @JoinColumn(name = "noticia_id") )
    private List<SiteNoticiaTags> siteNoticiaTagsList;

    public SiteTags() {
    }

    public SiteTags(Integer id) {
        this.id = id;
    }

    public SiteTags(Integer id, String descricao) {
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
    public List<SiteNoticiaTags> getSiteNoticiaTagsList() {
        return siteNoticiaTagsList;
    }

    public void setSiteNoticiaTagsList(List<SiteNoticiaTags> siteNoticiaTagsList) {
        this.siteNoticiaTagsList = siteNoticiaTagsList;
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
        if (!(object instanceof SiteTags)) {
            return false;
        }
        SiteTags other = (SiteTags) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao ;
    }
    
}
