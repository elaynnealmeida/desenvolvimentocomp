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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "site_noticia_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteNoticiaTags.findAll", query = "SELECT s FROM SiteNoticiaTags s"),
    @NamedQuery(name = "SiteNoticiaTags.findById", query = "SELECT s FROM SiteNoticiaTags s WHERE s.id = :id")})
public class SiteNoticiaTags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "noticia_id", referencedColumnName = "id")
    @ManyToOne
    private SiteNoticia noticiaId;
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @ManyToOne
    private SiteTags tagId;

    public SiteNoticiaTags() {
    }

    public SiteNoticiaTags(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SiteNoticia getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(SiteNoticia noticiaId) {
        this.noticiaId = noticiaId;
    }

    public SiteTags getTagId() {
        return tagId;
    }

    public void setTagId(SiteTags tagId) {
        this.tagId = tagId;
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
        if (!(object instanceof SiteNoticiaTags)) {
            return false;
        }
        SiteNoticiaTags other = (SiteNoticiaTags) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteNoticiaTags[ id=" + id + " ]";
    }
    
}
