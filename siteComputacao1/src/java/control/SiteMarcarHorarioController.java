
package control;

import dao.SiteMarcarHorarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteMarcarHorario;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class SiteMarcarHorarioController implements Serializable {

    private SiteMarcarHorario siteMarcarHorario;
    private SiteMarcarHorarioDAO siteMarcarHorarioDao;
    private List<SiteMarcarHorario> siteMarcarHorarios;
    private List<SiteMarcarHorario> siteMarcarHorariosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.siteMarcarHorario = new SiteMarcarHorario();
        this.siteMarcarHorarioDao = new SiteMarcarHorarioDAO();
        this.isEdit = false;
        siteMarcarHorarios = listar();
    }
    
   public void limpar() {
        this.siteMarcarHorario = new SiteMarcarHorario();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            siteMarcarHorarioDao.salvar(siteMarcarHorario);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try{
        siteMarcarHorarioDao.atualizar(siteMarcarHorario);
        FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar atualizar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try{
        siteMarcarHorarioDao.deletar(siteMarcarHorario);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteMarcarHorario> listar() {
        this.siteMarcarHorarios = siteMarcarHorarioDao.listarTodos();
        return this.siteMarcarHorarios;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.siteMarcarHorario = ((SiteMarcarHorario) event.getObject());
        this.isEdit = true;
    }

    public SiteMarcarHorario getSiteMarcarHorario() {
        return siteMarcarHorario;
    }

    public void setSiteMarcarHorario(SiteMarcarHorario siteMarcarHorario) {
        this.siteMarcarHorario = siteMarcarHorario;
    }

    public SiteMarcarHorarioDAO getSiteMarcarHorarioDao() {
        return siteMarcarHorarioDao;
    }

    public void setSiteMarcarHorarioDao(SiteMarcarHorarioDAO siteMarcarHorarioDao) {
        this.siteMarcarHorarioDao = siteMarcarHorarioDao;
    }

    public List<SiteMarcarHorario> getSiteMarcarHorarios() {
        return siteMarcarHorarios;
    }

    public void setSiteMarcarHorarios(List<SiteMarcarHorario> siteMarcarHorarios) {
        this.siteMarcarHorarios = siteMarcarHorarios;
    }

    public List<SiteMarcarHorario> getSiteMarcarHorariosFiltrados() {
        return siteMarcarHorariosFiltrados;
    }

    public void setSiteMarcarHorariosFiltrados(List<SiteMarcarHorario> siteMarcarHorariosFiltrados) {
        this.siteMarcarHorariosFiltrados = siteMarcarHorariosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
