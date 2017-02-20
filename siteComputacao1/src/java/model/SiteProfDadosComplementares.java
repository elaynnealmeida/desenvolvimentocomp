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
import javax.persistence.Lob;
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
@Table(name = "site_prof_dados_complementares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteProfDadosComplementares.findAll", query = "SELECT s FROM SiteProfDadosComplementares s"),
    @NamedQuery(name = "SiteProfDadosComplementares.findById", query = "SELECT s FROM SiteProfDadosComplementares s WHERE s.id = :id"),
    @NamedQuery(name = "SiteProfDadosComplementares.findByLattes", query = "SELECT s FROM SiteProfDadosComplementares s WHERE s.lattes = :lattes"),
    @NamedQuery(name = "SiteProfDadosComplementares.findByEnderecoProfissional", query = "SELECT s FROM SiteProfDadosComplementares s WHERE s.enderecoProfissional = :enderecoProfissional"),
    @NamedQuery(name = "SiteProfDadosComplementares.findByTelefoneProfissional", query = "SELECT s FROM SiteProfDadosComplementares s WHERE s.telefoneProfissional = :telefoneProfissional"),
    @NamedQuery(name = "SiteProfDadosComplementares.findByAreaAtuacao", query = "SELECT s FROM SiteProfDadosComplementares s WHERE s.areaAtuacao = :areaAtuacao")})
public class SiteProfDadosComplementares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "lattes")
    private String lattes;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 2147483647)
    @Column(name = "endereco_profissional")
    private String enderecoProfissional;
    @Size(max = 2147483647)
    @Column(name = "telefone_profissional")
    private String telefoneProfissional;
    @Size(max = 2147483647)
    @Column(name = "area_atuacao")
    private String areaAtuacao;
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbProfessores idProfessor;

    public SiteProfDadosComplementares() {
    }

    public SiteProfDadosComplementares(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEnderecoProfissional() {
        return enderecoProfissional;
    }

    public void setEnderecoProfissional(String enderecoProfissional) {
        this.enderecoProfissional = enderecoProfissional;
    }

    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }

    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public TbProfessores getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(TbProfessores idProfessor) {
        this.idProfessor = idProfessor;
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
        if (!(object instanceof SiteProfDadosComplementares)) {
            return false;
        }
        SiteProfDadosComplementares other = (SiteProfDadosComplementares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteProfDadosComplementares[ id=" + id + " ]";
    }
    
}
