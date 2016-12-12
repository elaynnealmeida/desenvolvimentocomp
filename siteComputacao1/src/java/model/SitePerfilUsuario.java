
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_perfil_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitePerfilUsuario.findAll", query = "SELECT s FROM SitePerfilUsuario s"),
    @NamedQuery(name = "SitePerfilUsuario.findById", query = "SELECT s FROM SitePerfilUsuario s WHERE s.id = :id"),
    @NamedQuery(name = "SitePerfilUsuario.findByAtivo", query = "SELECT s FROM SitePerfilUsuario s WHERE s.ativo = :ativo")})
public class SitePerfilUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SitePerfil perfilId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbUsersystem usuarioId;

    public SitePerfilUsuario() {
    }

    public SitePerfilUsuario(Integer id) {
        this.id = id;
    }

    public SitePerfilUsuario(Integer id, boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public SitePerfil getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(SitePerfil perfilId) {
        this.perfilId = perfilId;
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
        if (!(object instanceof SitePerfilUsuario)) {
            return false;
        }
        SitePerfilUsuario other = (SitePerfilUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SitePerfilUsuario[ id=" + id + " ]";
    }
    
}
