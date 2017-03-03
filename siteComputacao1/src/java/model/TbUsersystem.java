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
@Table(name = "tb_usersystem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsersystem.findAll", query = "SELECT t FROM TbUsersystem t"),
    @NamedQuery(name = "TbUsersystem.findById", query = "SELECT t FROM TbUsersystem t WHERE t.id = :id"),
    @NamedQuery(name = "TbUsersystem.findByEmail", query = "SELECT t FROM TbUsersystem t WHERE t.email = :email"),
    @NamedQuery(name = "TbUsersystem.findByMatricula", query = "SELECT t FROM TbUsersystem t WHERE t.matricula = :matricula"),
    @NamedQuery(name = "TbUsersystem.findByNomecompleto", query = "SELECT t FROM TbUsersystem t WHERE t.nomecompleto = :nomecompleto"),
    @NamedQuery(name = "TbUsersystem.findByPassword", query = "SELECT t FROM TbUsersystem t WHERE t.password = :password"),
    @NamedQuery(name = "TbUsersystem.findByReceberemail", query = "SELECT t FROM TbUsersystem t WHERE t.receberemail = :receberemail"),
    @NamedQuery(name = "TbUsersystem.findByRoles", query = "SELECT t FROM TbUsersystem t WHERE t.roles = :roles"),
    @NamedQuery(name = "TbUsersystem.findByShowemail", query = "SELECT t FROM TbUsersystem t WHERE t.showemail = :showemail"),
    @NamedQuery(name = "TbUsersystem.findByShowphone", query = "SELECT t FROM TbUsersystem t WHERE t.showphone = :showphone"),
    @NamedQuery(name = "TbUsersystem.findByStatus", query = "SELECT t FROM TbUsersystem t WHERE t.status = :status"),
    @NamedQuery(name = "TbUsersystem.findByTelefone", query = "SELECT t FROM TbUsersystem t WHERE t.telefone = :telefone")})
public class TbUsersystem implements Serializable {
    
    @OneToMany(mappedBy = "usuarioInclusao")
    private List<SiteDocumento> siteDocumentoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomecompleto")
    private String nomecompleto;
    @Size(max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receberemail")
    private boolean receberemail;
    @Size(max = 255)
    @Column(name = "roles")
    private String roles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showemail")
    private boolean showemail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showphone")
    private boolean showphone;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "usuarioId")
    private List<SiteNoticia> siteNoticiaList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "site_perfil_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private List<SitePerfil> sitePerfilUsuarioList;
    

    public TbUsersystem() {
    }

    public TbUsersystem(Long id) {
        this.id = id;
    }

    public TbUsersystem(Long id, String email, String nomecompleto, boolean receberemail, boolean showemail, boolean showphone, String telefone) {
        this.id = id;
        this.email = email;
        this.nomecompleto = nomecompleto;
        this.receberemail = receberemail;
        this.showemail = showemail;
        this.showphone = showphone;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getReceberemail() {
        return receberemail;
    }

    public void setReceberemail(boolean receberemail) {
        this.receberemail = receberemail;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean getShowemail() {
        return showemail;
    }

    public void setShowemail(boolean showemail) {
        this.showemail = showemail;
    }

    public boolean getShowphone() {
        return showphone;
    }

    public void setShowphone(boolean showphone) {
        this.showphone = showphone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<SiteNoticia> getSiteNoticiaList() {
        return siteNoticiaList;
    }

    public void setSiteNoticiaList(List<SiteNoticia> siteNoticiaList) {
        this.siteNoticiaList = siteNoticiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @XmlTransient
    public List<SitePerfil> getSitePerfilUsuarioList() {
        return sitePerfilUsuarioList;
    }

    public void setSitePerfilUsuarioList(List<SitePerfil> sitePerfilUsuarioList) {
        this.sitePerfilUsuarioList = sitePerfilUsuarioList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsersystem)) {
            return false;
        }
        TbUsersystem other = (TbUsersystem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUsersystem[ id=" + id + " ]";
    }

    @XmlTransient
    public List<SiteDocumento> getSiteDocumentoList() {
        return siteDocumentoList;
    }

    public void setSiteDocumentoList(List<SiteDocumento> siteDocumentoList) {
        this.siteDocumentoList = siteDocumentoList;
    }

    
}
