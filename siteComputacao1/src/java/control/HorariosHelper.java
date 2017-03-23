
package control;

import dao.EstagiarioDAO;
import dao.HorarioAulaDAO;
import dao.HorarioMonitorDAO;
import dao.HorarioServidorDAO;
import dao.MonitorDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.SiteEstagiarios;
import model.SiteHorarioAula;
import model.SiteHorarioMonitor;
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
    private List<SiteHorarioAula> aulas2;
    private List<SiteHorarioAula> aulas3;
    private List<SiteHorarioAula> aulas4;
    private List<SiteHorarioAula> aulas5;
    private List<SiteHorarioAula> aulas6;
    private List<SiteHorarioAula> aulas7;
    private List<SiteHorarioAula> aulas8;
    private List<SiteHorarioAula> aulas9;
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
        this.aulas2 = listarAulas2();
        this.aulas3 = listarAulas3();
        this.aulas4 = listarAulas4();
        this.aulas5 = listarAulas5();
        this.aulas6 = listarAulas6();
        this.aulas7 = listarAulas7();
        this.aulas8 = listarAulas8();
        this.aulas9 = listarAulas9();
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
        this.aulas = aulaDao.listarHorarioAtual(1);        
        return this.aulas;
    }
      public List<SiteHorarioAula> listarAulas2() {
        this.aulas2 = aulaDao.listarHorarioAtual(2);        
        return this.aulas2;
    }
      public List<SiteHorarioAula> listarAulas3() {
        this.aulas3 = aulaDao.listarHorarioAtual(3);        
        return this.aulas3;
    }
      public List<SiteHorarioAula> listarAulas4() {
        this.aulas4 = aulaDao.listarHorarioAtual(4);        
        return this.aulas4;
    }
      public List<SiteHorarioAula> listarAulas5() {
        this.aulas5 = aulaDao.listarHorarioAtual(5);        
        return this.aulas5;
    }
      public List<SiteHorarioAula> listarAulas6() {
        this.aulas6 = aulaDao.listarHorarioAtual(6);        
        return this.aulas6;
    }
      public List<SiteHorarioAula> listarAulas7() {
        this.aulas7 = aulaDao.listarHorarioAtual(7);        
        return this.aulas7;
    }
      public List<SiteHorarioAula> listarAulas8() {
        this.aulas8 = aulaDao.listarHorarioAtual(8);        
        return this.aulas8;
    }
      public List<SiteHorarioAula> listarAulas9() {
        this.aulas9 = aulaDao.listarHorarioAtual(0);        
        return this.aulas9;
    }
     
     public List<SiteMonitor> listarMonitores() {
        this.monitores = monitorDao.listarTodosAtivos();
        return this.monitores;
    }    
     
      public List<SiteEstagiarios> listarEstagiarios() {
        this.estagiarios = estagiarioDao.listarHorarioAtual();
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

    public List<SiteHorarioAula> getAulas2() {
        return aulas2;
    }

    public void setAulas2(List<SiteHorarioAula> aulas2) {
        this.aulas2 = aulas2;
    }

    public List<SiteHorarioAula> getAulas3() {
        return aulas3;
    }

    public void setAulas3(List<SiteHorarioAula> aulas3) {
        this.aulas3 = aulas3;
    }

    public List<SiteHorarioAula> getAulas4() {
        return aulas4;
    }

    public void setAulas4(List<SiteHorarioAula> aulas4) {
        this.aulas4 = aulas4;
    }

    public List<SiteHorarioAula> getAulas5() {
        return aulas5;
    }

    public void setAulas5(List<SiteHorarioAula> aulas5) {
        this.aulas5 = aulas5;
    }

    public List<SiteHorarioAula> getAulas6() {
        return aulas6;
    }

    public void setAulas6(List<SiteHorarioAula> aulas6) {
        this.aulas6 = aulas6;
    }

    public List<SiteHorarioAula> getAulas7() {
        return aulas7;
    }

    public void setAulas7(List<SiteHorarioAula> aulas7) {
        this.aulas7 = aulas7;
    }

    public List<SiteHorarioAula> getAulas8() {
        return aulas8;
    }

    public void setAulas8(List<SiteHorarioAula> aulas8) {
        this.aulas8 = aulas8;
    }

    public List<SiteHorarioAula> getAulas9() {
        return aulas9;
    }

    public void setAulas9(List<SiteHorarioAula> aulas9) {
        this.aulas9 = aulas9;
    }

}
