
package control;

import dao.EstagiarioDAO;
import dao.HorarioServidorDAO;
import dao.MonitorDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.SiteEstagiarios;
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
    private List<SiteHorarioServidor> servidores;
    private List<SiteMonitor> monitores;
    private List<SiteEstagiarios> estagiarios;

    @PostConstruct
    public void init() {
        this.servidorDao = new HorarioServidorDAO();
        this.estagiarioDao = new EstagiarioDAO();
        this.monitorDao = new MonitorDAO();
        this.servidores = listarServidores();
        this.monitores = listarMonitores();
        this.estagiarios = listarEstagiarios();
    }
    
     public List<SiteHorarioServidor> listarServidores() {
        this.servidores = servidorDao.listarTodosAtivos();
        return this.servidores;
    }
     
     public List<SiteMonitor> listarMonitores() {
        this.monitores = monitorDao.listarTodosAtivos();
        return this.monitores;
    }
     
      public List<SiteEstagiarios> listarEstagiarios() {
        this.estagiarios = estagiarioDao.listarTodosAtivos();
        return this.estagiarios;
    }
    
}
