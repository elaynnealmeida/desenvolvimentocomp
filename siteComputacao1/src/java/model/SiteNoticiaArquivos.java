
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "site_noticia_arquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteNoticiaArquivos.findAll", query = "SELECT s FROM SiteNoticiaArquivos s")
    , @NamedQuery(name = "SiteNoticiaArquivos.findById", query = "SELECT s FROM SiteNoticiaArquivos s WHERE s.id = :id")})
public class SiteNoticiaArquivos implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "extensao")
    private String extensao;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "noticia_id", referencedColumnName = "id")
    @ManyToOne
    private SiteNoticia noticiaId;

    public SiteNoticiaArquivos() {
    }

    public SiteNoticiaArquivos(Integer id) {
        this.id = id;
    }

    public SiteNoticiaArquivos(Integer id, byte[] arquivo) {
        this.id = id;
        this.arquivo = arquivo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SiteNoticia getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(SiteNoticia noticiaId) {
        this.noticiaId = noticiaId;
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
        if (!(object instanceof SiteNoticiaArquivos)) {
            return false;
        }
        SiteNoticiaArquivos other = (SiteNoticiaArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteNoticiaArquivos[ id=" + id + " ]";
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }
    
}
