
package control;

import dao.EstagiarioDAO;
import dao.HorarioAulaDAO;
import dao.HorarioServidorDAO;
import dao.MonitorDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.SiteEstagiarios;
import model.SiteHorarioAula;
import model.SiteHorarioServidor;
import model.SiteMonitor;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class HorariosHelper implements Serializable {

    private MonitorDAO monitorDao;
    private EstagiarioDAO estagiarioDao;
    private HorarioServidorDAO servidorDao;
    private HorarioAulaDAO aulaDao;
    private List<SiteHorarioServidor> servidores;
    private List<SiteHorarioServidor> docentes;
    private List<SiteHorarioAula> aulas;
    private List<SiteMonitor> monitores;
    private List<SiteEstagiarios> estagiarios;
    private String tamanhoAula;

    @PostConstruct
    public void init() {
        this.servidorDao = new HorarioServidorDAO();
        this.estagiarioDao = new EstagiarioDAO();
        this.monitorDao = new MonitorDAO();
        this.aulaDao = new HorarioAulaDAO();
        this.servidores = listarTecnicos();
        this.docentes = listarProfessores();
        this.monitores = listarMonitores();
        this.estagiarios = listarEstagiarios();
        this.aulas = listarAulas();
        this.tamanhoAula = String.valueOf(this.aulas.size());
    }
    
     public List<SiteHorarioServidor> listarTecnicos() {
        this.servidores = servidorDao.listarTecnicos();
        return this.servidores;
    }
     
     public List<SiteHorarioServidor> listarProfessores() {
        this.docentes = servidorDao.listarProfessores();
        return this.docentes;
    }
     
      public List<SiteHorarioAula> listarAulas() {
        this.aulas = aulaDao.listarHorarioAtual();        
        return this.aulas;
    }
     
     public List<SiteMonitor> listarMonitores() {
        this.monitores = monitorDao.listarTodosAtivos();
        return this.monitores;
    }
     
      public List<SiteEstagiarios> listarEstagiarios() {
        this.estagiarios = estagiarioDao.listarTodosAtivos();
        return this.estagiarios;
    }

    public List<SiteHorarioServidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<SiteHorarioServidor> servidores) {
        this.servidores = servidores;
    }

    public List<SiteHorarioAula> getAulas() {
        return aulas;
    }

    public void setAulas(List<SiteHorarioAula> aulas) {
        this.aulas = aulas;
    }

    public List<SiteMonitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<SiteMonitor> monitores) {
        this.monitores = monitores;
    }

    public List<SiteEstagiarios> getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(List<SiteEstagiarios> estagiarios) {
        this.estagiarios = estagiarios;
    }

    public String getTamanhoAula() {
        return tamanhoAula;
    }

    public void setTamanhoAula(String tamanhoAula) {
        this.tamanhoAula = tamanhoAula;
    }

    public List<SiteHorarioServidor> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<SiteHorarioServidor> docentes) {
        this.docentes = docentes;
    }
    
}
