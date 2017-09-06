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
@Table(name = "site_marcar_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteMarcarHorario.findAll", query = "SELECT s FROM SiteMarcarHorario s")
    , @NamedQuery(name = "SiteMarcarHorario.findById", query = "SELECT s FROM SiteMarcarHorario s WHERE s.id = :id")
    , @NamedQuery(name = "SiteMarcarHorario.findByNome", query = "SELECT s FROM SiteMarcarHorario s WHERE s.nome = :nome")
    , @NamedQuery(name = "SiteMarcarHorario.findByEmail", query = "SELECT s FROM SiteMarcarHorario s WHERE s.email = :email")
    , @NamedQuery(name = "SiteMarcarHorario.findByPreviaDoAssunto", query = "SELECT s FROM SiteMarcarHorario s WHERE s.previaDoAssunto = :previaDoAssunto")
    , @NamedQuery(name = "SiteMarcarHorario.findByHorario", query = "SELECT s FROM SiteMarcarHorario s WHERE s.horario = :horario")})
public class SiteMarcarHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "previa do assunto")
    private String previaDoAssunto;
    @Size(max = 2147483647)
    @Column(name = "horario")
    private String horario;

    public SiteMarcarHorario() {
    }

    public SiteMarcarHorario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreviaDoAssunto() {
        return previaDoAssunto;
    }

    public void setPreviaDoAssunto(String previaDoAssunto) {
        this.previaDoAssunto = previaDoAssunto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        if (!(object instanceof SiteMarcarHorario)) {
            return false;
        }
        SiteMarcarHorario other = (SiteMarcarHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteMarcarHorario[ id=" + id + " ]";
    }
    
}
