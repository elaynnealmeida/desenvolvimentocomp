
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
@Table(name = "site_monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteMonitor.findAll", query = "SELECT s FROM SiteMonitor s"),
    @NamedQuery(name = "SiteMonitor.findById", query = "SELECT s FROM SiteMonitor s WHERE s.id = :id"),
    @NamedQuery(name = "SiteMonitor.findByNome", query = "SELECT s FROM SiteMonitor s WHERE s.nome = :nome"),
    @NamedQuery(name = "SiteMonitor.findByMatricula", query = "SELECT s FROM SiteMonitor s WHERE s.matricula = :matricula"),
    @NamedQuery(name = "SiteMonitor.findByDataInicio", query = "SELECT s FROM SiteMonitor s WHERE s.dataInicio = :dataInicio"),
    @NamedQuery(name = "SiteMonitor.findByDataFim", query = "SELECT s FROM SiteMonitor s WHERE s.dataFim = :dataFim"),
    @NamedQuery(name = "SiteMonitor.findByEmail", query = "SELECT s FROM SiteMonitor s WHERE s.email = :email"),
    @NamedQuery(name = "SiteMonitor.findByAtivo", query = "SELECT s FROM SiteMonitor s WHERE s.ativo = :ativo")})
public class SiteMonitor implements Serializable {

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
    @Size(max = 2147483647)
    @Column(name = "data_inicio")
    private String dataInicio;
    @Size(max = 2147483647)
    @Column(name = "data_fim")
    private String dataFim;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Column(name = "ativo")
    private Boolean ativo;
    @JoinColumn(name = "disciplina", referencedColumnName = "id")
    @ManyToOne
    private TbDisciplina disciplina;
    @OneToMany(mappedBy = "monitor",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<SiteHorarioMonitor> siteHorarioMonitorList;

    public SiteMonitor() {
    }

    public SiteMonitor(Integer id) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public TbDisciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(TbDisciplina disciplina) {
        this.disciplina = disciplina;
    }

    @XmlTransient
    public List<SiteHorarioMonitor> getSiteHorarioMonitorList() {
        return siteHorarioMonitorList;
    }

    public void setSiteHorarioMonitorList(List<SiteHorarioMonitor> siteHorarioMonitorList) {
        this.siteHorarioMonitorList = siteHorarioMonitorList;
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
        if (!(object instanceof SiteMonitor)) {
            return false;
        }
        SiteMonitor other = (SiteMonitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SiteMonitor[ id=" + id + " ]";
    }
    
}
