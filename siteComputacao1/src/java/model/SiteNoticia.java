package model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Lob;
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
@Table(name = "site_noticia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteNoticia.findAll", query = "SELECT s FROM SiteNoticia s"),
    @NamedQuery(name = "SiteNoticia.findById", query = "SELECT s FROM SiteNoticia s WHERE s.id = :id"),
    @NamedQuery(name = "SiteNoticia.findByTitulo", query = "SELECT s FROM SiteNoticia s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "SiteNoticia.findByData", query = "SELECT s FROM SiteNoticia s WHERE s.data = :data"),
    @NamedQuery(name = "SiteNoticia.findByHora", query = "SELECT s FROM SiteNoticia s WHERE s.hora = :hora"),
    @NamedQuery(name = "SiteNoticia.findByConteudo", query = "SELECT s FROM SiteNoticia s WHERE s.conteudo = :conteudo"),
    @NamedQuery(name = "SiteNoticia.findByHora2", query = "SELECT s FROM SiteNoticia s WHERE s.hora2 = :hora2")})
public class SiteNoticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "img_capa")
    private byte[] imgCapa;
    @Size(max = 2147483647)
    @Column(name = "data")
    private String data;
    @Size(max = 2147483647)
    @Column(name = "hora")
    private String hora;
    @Size(max = 2147483647)
    @Column(name = "conteudo")
    private String conteudo;
    @OneToMany(mappedBy = "noticiaId",cascade=CascadeType.REMOVE)
    private List<SiteComentarios> siteComentariosList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private TbUsersystem usuarioId;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinTable(name="site_noticia_tags", 
               joinColumns=  @JoinColumn( name = "noticia_id"), 
               inverseJoinColumns= @JoinColumn(name = "tag_id") )
    private List<SiteTags> siteNoticiaTagsList;
    
    @Column(name = "hora2")
    private BigInteger hora2;
    

    public SiteNoticia() {
    }

    public SiteNoticia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getImgCapa() {
        return imgCapa;
    }

    public void setImgCapa(byte[] imgCapa) {
        this.imgCapa = imgCapa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public BigInteger getHora2() {
        return hora2;
    }

    public void setHora2(BigInteger hora2) {
        this.hora2 = hora2;
    }

    public TbUsersystem getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(TbUsersystem usuarioId) {
        this.usuarioId = usuarioId;
    }
    public List<SiteComentarios> getSiteComentariosList() {
        return siteComentariosList;
    }

    public void setSiteComentariosList(List<SiteComentarios> siteComentariosList) {
        this.siteComentariosList = siteComentariosList;
    }

    @XmlTransient
    public List<SiteTags> getSiteNoticiaTagsList() {
        return siteNoticiaTagsList;
    }

    public void setSiteNoticiaTagsList(List<SiteTags> siteNoticiaTagsList) {
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
        if (!(object instanceof SiteNoticia)) {
            return false;
        }
        SiteNoticia other = (SiteNoticia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteNoticia[ id=" + id + " ]";
    }

    
    
}
