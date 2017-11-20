package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "tb_professores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProfessores.findAll", query = "SELECT t FROM TbProfessores t"),
    @NamedQuery(name = "TbProfessores.findById", query = "SELECT t FROM TbProfessores t WHERE t.id = :id"),
    @NamedQuery(name = "TbProfessores.findByEmail", query = "SELECT t FROM TbProfessores t WHERE t.email = :email"),
    @NamedQuery(name = "TbProfessores.findByNome", query = "SELECT t FROM TbProfessores t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbProfessores.findByAtivo", query = "SELECT t FROM TbProfessores t WHERE t.ativo = :ativo")})
public class TbProfessores implements Serializable {

    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="site_pp_profpesquisador", 
               joinColumns=  @JoinColumn( name = "prof_pesquisador" ), 
               inverseJoinColumns= @JoinColumn(name = "pp") )
    private List<SitePpProfpesquisador> sitePpProfpesquisadorList;
    
    
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="site_pp_coordenador", 
               joinColumns=  @JoinColumn( name = "coordenador" ), 
               inverseJoinColumns= @JoinColumn(name = "pp") )
    private List<SitePpCoordenador> sitePpCoordenadorList;

    @OneToMany(mappedBy = "coordenador")
    private List<SiteIniciacaoCientifica> siteIniciacaoCientificaList;

    @OneToMany(mappedBy = "responsavel")
    private List<SiteInfraestrutura> siteInfraestruturaList;

    @OneToMany(mappedBy = "professorId")
    private List<SiteTurma> siteTurmaList;

    @OneToMany(mappedBy = "servidorId")
    private List<SiteHorarioServidor> siteHorarioServidorList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessor")
    private List<SiteProfDadosComplementares> siteProfDadosComplementaresList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "ativo")
    private Boolean ativo;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "professorId")
    private List<SiteCargoProfessor> siteCargoProfessorList;
    @OneToMany(mappedBy = "professorId")
    private List<SiteFuncaoProfessor> siteFuncaoProfessorList;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "site_funcao_professor",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "funcao_id"))
    private List<SiteFormacao> siteProfessorFormacaoList;

    public TbProfessores() {
    }

    public TbProfessores(Long id) {
        this.id = id;
    }

    public TbProfessores(Long id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public List<SiteCargoProfessor> getSiteCargoProfessorList() {
        return siteCargoProfessorList;
    }

    public void setSiteCargoProfessorList(List<SiteCargoProfessor> siteCargoProfessorList) {
        this.siteCargoProfessorList = siteCargoProfessorList;
    }

    @XmlTransient
    public List<SiteFuncaoProfessor> getSiteFuncaoProfessorList() {
        return siteFuncaoProfessorList;
    }

    public void setSiteFuncaoProfessorList(List<SiteFuncaoProfessor> siteFuncaoProfessorList) {
        this.siteFuncaoProfessorList = siteFuncaoProfessorList;
    }

    @XmlTransient
    public List<SiteFormacao> getSiteProfessorFormacaoList() {
        return siteProfessorFormacaoList;
    }

    public void setSiteProfessorFormacaoList(List<SiteFormacao> siteProfessorFormacaoList) {
        this.siteProfessorFormacaoList = siteProfessorFormacaoList;
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
        if (!(object instanceof TbProfessores)) {
            return false;
        }
        TbProfessores other = (TbProfessores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    @XmlTransient
    public List<SiteProfDadosComplementares> getSiteProfDadosComplementaresList() {
        return siteProfDadosComplementaresList;
    }

    public void setSiteProfDadosComplementaresList(List<SiteProfDadosComplementares> siteProfDadosComplementaresList) {
        this.siteProfDadosComplementaresList = siteProfDadosComplementaresList;
    }

    @XmlTransient
    public List<SiteHorarioServidor> getSiteHorarioServidorList() {
        return siteHorarioServidorList;
    }

    public void setSiteHorarioServidorList(List<SiteHorarioServidor> siteHorarioServidorList) {
        this.siteHorarioServidorList = siteHorarioServidorList;
    }

    @XmlTransient
    public List<SiteTurma> getSiteTurmaList() {
        return siteTurmaList;
    }

    public void setSiteTurmaList(List<SiteTurma> siteTurmaList) {
        this.siteTurmaList = siteTurmaList;
    }

    @XmlTransient
    public List<SiteInfraestrutura> getSiteInfraestruturaList() {
        return siteInfraestruturaList;
    }

    public void setSiteInfraestruturaList(List<SiteInfraestrutura> siteInfraestruturaList) {
        this.siteInfraestruturaList = siteInfraestruturaList;
    }

    @XmlTransient
    public List<SiteIniciacaoCientifica> getSiteIniciacaoCientificaList() {
        return siteIniciacaoCientificaList;
    }

    public void setSiteIniciacaoCientificaList(List<SiteIniciacaoCientifica> siteIniciacaoCientificaList) {
        this.siteIniciacaoCientificaList = siteIniciacaoCientificaList;
    }

    @XmlTransient
    public List<SitePpProfpesquisador> getSitePpProfpesquisadorList() {
        return sitePpProfpesquisadorList;
    }

    public void setSitePpProfpesquisadorList(List<SitePpProfpesquisador> sitePpProfpesquisadorList) {
        this.sitePpProfpesquisadorList = sitePpProfpesquisadorList;
    }

    @XmlTransient
    public List<SitePpCoordenador> getSitePpCoordenadorList() {
        return sitePpCoordenadorList;
    }

    public void setSitePpCoordenadorList(List<SitePpCoordenador> sitePpCoordenadorList) {
        this.sitePpCoordenadorList = sitePpCoordenadorList;
    }
    
}
