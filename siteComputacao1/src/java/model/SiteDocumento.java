
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "site_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteDocumento.findAll", query = "SELECT s FROM SiteDocumento s"),
    @NamedQuery(name = "SiteDocumento.findById", query = "SELECT s FROM SiteDocumento s WHERE s.id = :id"),
    @NamedQuery(name = "SiteDocumento.findByTamanhoDoArquivo", query = "SELECT s FROM SiteDocumento s WHERE s.tamanhoDoArquivo = :tamanhoDoArquivo"),
    @NamedQuery(name = "SiteDocumento.findByDataInclusao", query = "SELECT s FROM SiteDocumento s WHERE s.dataInclusao = :dataInclusao"),
    @NamedQuery(name = "SiteDocumento.findByAtivo", query = "SELECT s FROM SiteDocumento s WHERE s.ativo = :ativo"),
    @NamedQuery(name = "SiteDocumento.findByHora", query = "SELECT s FROM SiteDocumento s WHERE s.hora = :hora"),
    @NamedQuery(name = "SiteDocumento.findByTitulo", query = "SELECT s FROM SiteDocumento s WHERE s.titulo = :titulo")})
public class SiteDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Column(name = "tamanho_do_arquivo")
    private BigInteger tamanhoDoArquivo;
    @Size(max = 2147483647)
    @Column(name = "data_inclusao")
    private String dataInclusao;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "hora")
    private BigInteger hora;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "usuario_inclusao", referencedColumnName = "id")
    @ManyToOne
    private TbUsersystem usuarioInclusao;

    public SiteDocumento() {
    }

    public SiteDocumento(Integer id) {
        this.id = id;
    }

    public SiteDocumento(Integer id, byte[] arquivo) {
        this.id = id;
        this.arquivo = arquivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public BigInteger getTamanhoDoArquivo() {
        return tamanhoDoArquivo;
    }

    public void setTamanhoDoArquivo(BigInteger tamanhoDoArquivo) {
        this.tamanhoDoArquivo = tamanhoDoArquivo;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BigInteger getHora() {
        return hora;
    }

    public void setHora(BigInteger hora) {
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TbUsersystem getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(TbUsersystem usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
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
        if (!(object instanceof SiteDocumento)) {
            return false;
        }
        SiteDocumento other = (SiteDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteDocumento[ id=" + id + " ]";
    }
    
}
