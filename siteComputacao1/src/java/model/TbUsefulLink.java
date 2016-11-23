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
@Table(name = "tb_useful_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsefulLink.findAll", query = "SELECT t FROM TbUsefulLink t"),
    @NamedQuery(name = "TbUsefulLink.findById", query = "SELECT t FROM TbUsefulLink t WHERE t.id = :id"),
    @NamedQuery(name = "TbUsefulLink.findByLink", query = "SELECT t FROM TbUsefulLink t WHERE t.link = :link"),
    @NamedQuery(name = "TbUsefulLink.findByTitle", query = "SELECT t FROM TbUsefulLink t WHERE t.title = :title")})
public class TbUsefulLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "link")
    private String link;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "img_id", referencedColumnName = "id")
    @ManyToOne
    private TbArquivo imgId;

    public TbUsefulLink() {
    }

    public TbUsefulLink(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TbArquivo getImgId() {
        return imgId;
    }

    public void setImgId(TbArquivo imgId) {
        this.imgId = imgId;
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
        if (!(object instanceof TbUsefulLink)) {
            return false;
        }
        TbUsefulLink other = (TbUsefulLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUsefulLink[ id=" + id + " ]";
    }
    
}
