/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "site_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteAluno.findAll", query = "SELECT s FROM SiteAluno s")
    , @NamedQuery(name = "SiteAluno.findById", query = "SELECT s FROM SiteAluno s WHERE s.id = :id")
    , @NamedQuery(name = "SiteAluno.findByNome", query = "SELECT s FROM SiteAluno s WHERE s.nome = :nome")
    , @NamedQuery(name = "SiteAluno.findByMatricula", query = "SELECT s FROM SiteAluno s WHERE s.matricula = :matricula")})
public class SiteAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "formacao", referencedColumnName = "id")
    @ManyToOne
    private SiteFormacao formacao;
    @OneToMany(mappedBy = "aluno")
    private List<SitePpAlunos> sitePpAlunosList;

    public SiteAluno() {
    }

    public SiteAluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public SiteFormacao getFormacao() {
        return formacao;
    }

    public void setFormacao(SiteFormacao formacao) {
        this.formacao = formacao;
    }

    @XmlTransient
    public List<SitePpAlunos> getSitePpAlunosList() {
        return sitePpAlunosList;
    }

    public void setSitePpAlunosList(List<SitePpAlunos> sitePpAlunosList) {
        this.sitePpAlunosList = sitePpAlunosList;
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
        if (!(object instanceof SiteAluno)) {
            return false;
        }
        SiteAluno other = (SiteAluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " - " +matricula;
    }
    
}
