/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteComentarios.findAll", query = "SELECT s FROM SiteComentarios s"),
    @NamedQuery(name = "SiteComentarios.findById", query = "SELECT s FROM SiteComentarios s WHERE s.id = :id"),
    @NamedQuery(name = "SiteComentarios.findByTexto", query = "SELECT s FROM SiteComentarios s WHERE s.texto = :texto"),
    @NamedQuery(name = "SiteComentarios.findByEmail", query = "SELECT s FROM SiteComentarios s WHERE s.email = :email")})
public class SiteComentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "texto")
    private String texto;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "noticia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SiteNoticia noticiaId;

    public SiteComentarios() {
    }

    public SiteComentarios(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof SiteComentarios)) {
            return false;
        }
        SiteComentarios other = (SiteComentarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteComentarios[ id=" + id + " ]";
    }
    
}
