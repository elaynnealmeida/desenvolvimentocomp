
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
@Table(name = "site_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitePerfil.findAll", query = "SELECT s FROM SitePerfil s"),
    @NamedQuery(name = "SitePerfil.findById", query = "SELECT s FROM SitePerfil s WHERE s.id = :id"),
    @NamedQuery(name = "SitePerfil.findByNome", query = "SELECT s FROM SitePerfil s WHERE s.nome = :nome"),
    @NamedQuery(name = "SitePerfil.findByDescricao", query = "SELECT s FROM SitePerfil s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "SitePerfil.findByAtivo", query = "SELECT s FROM SitePerfil s WHERE s.ativo = :ativo")})
public class SitePerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ativo")
    private Boolean ativo;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(name="site_perfil_usuario", 
               joinColumns=  @JoinColumn( name = "perfil_id"), 
               inverseJoinColumns= @JoinColumn(name = "usuario_id") )
    private List<SitePerfilUsuario> sitePerfilUsuarioList;

    public SitePerfil() {
    }

    public SitePerfil(Integer id) {
        this.id = id;
    }

    public SitePerfil(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public List<SitePerfilUsuario> getSitePerfilUsuarioList() {
        return sitePerfilUsuarioList;
    }

    public void setSitePerfilUsuarioList(List<SitePerfilUsuario> sitePerfilUsuarioList) {
        this.sitePerfilUsuarioList = sitePerfilUsuarioList;
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
        if (!(object instanceof SitePerfil)) {
            return false;
        }
        SitePerfil other = (SitePerfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
