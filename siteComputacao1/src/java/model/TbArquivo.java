/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "tb_arquivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbArquivo.findAll", query = "SELECT t FROM TbArquivo t"),
    @NamedQuery(name = "TbArquivo.findById", query = "SELECT t FROM TbArquivo t WHERE t.id = :id"),
    @NamedQuery(name = "TbArquivo.findByContenttype", query = "SELECT t FROM TbArquivo t WHERE t.contenttype = :contenttype"),
    @NamedQuery(name = "TbArquivo.findByNome", query = "SELECT t FROM TbArquivo t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbArquivo.findByTamanho", query = "SELECT t FROM TbArquivo t WHERE t.tamanho = :tamanho")})
public class TbArquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "contenttype")
    private String contenttype;
    @Lob
    @Column(name = "conteudo")
    private byte[] conteudo;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "tamanho")
    private BigInteger tamanho;
    @OneToMany(mappedBy = "imgId")
    private List<TbUsefulLink> tbUsefulLinkList;

    public TbArquivo() {
    }

    public TbArquivo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getTamanho() {
        return tamanho;
    }

    public void setTamanho(BigInteger tamanho) {
        this.tamanho = tamanho;
    }

    @XmlTransient
    public List<TbUsefulLink> getTbUsefulLinkList() {
        return tbUsefulLinkList;
    }

    public void setTbUsefulLinkList(List<TbUsefulLink> tbUsefulLinkList) {
        this.tbUsefulLinkList = tbUsefulLinkList;
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
        if (!(object instanceof TbArquivo)) {
            return false;
        }
        TbArquivo other = (TbArquivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbArquivo[ id=" + id + " ]";
    }
    
}
