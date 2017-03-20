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
@Table(name = "site_infraestrutura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteInfraestrutura.findAll", query = "SELECT s FROM SiteInfraestrutura s"),
    @NamedQuery(name = "SiteInfraestrutura.findById", query = "SELECT s FROM SiteInfraestrutura s WHERE s.id = :id"),
    @NamedQuery(name = "SiteInfraestrutura.findByPavimento", query = "SELECT s FROM SiteInfraestrutura s WHERE s.pavimento = :pavimento"),
    @NamedQuery(name = "SiteInfraestrutura.findByLargura", query = "SELECT s FROM SiteInfraestrutura s WHERE s.largura = :largura"),
    @NamedQuery(name = "SiteInfraestrutura.findByComprimento", query = "SELECT s FROM SiteInfraestrutura s WHERE s.comprimento = :comprimento"),
    @NamedQuery(name = "SiteInfraestrutura.findByNome", query = "SELECT s FROM SiteInfraestrutura s WHERE s.nome = :nome"),
    @NamedQuery(name = "SiteInfraestrutura.findByNumero", query = "SELECT s FROM SiteInfraestrutura s WHERE s.numero = :numero")})
public class SiteInfraestrutura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "pavimento")
    private String pavimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "largura")
    private Double largura;
    @Column(name = "comprimento")
    private Double comprimento;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "sala", referencedColumnName = "id")
    @ManyToOne
    private TbSala sala;

    public SiteInfraestrutura() {
    }

    public SiteInfraestrutura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavimento() {
        return pavimento;
    }

    public void setPavimento(String pavimento) {
        this.pavimento = pavimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TbSala getSala() {
        return sala;
    }

    public void setSala(TbSala sala) {
        this.sala = sala;
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
        if (!(object instanceof SiteInfraestrutura)) {
            return false;
        }
        SiteInfraestrutura other = (SiteInfraestrutura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteInfraestrutura[ id=" + id + " ]";
    }
    
}
