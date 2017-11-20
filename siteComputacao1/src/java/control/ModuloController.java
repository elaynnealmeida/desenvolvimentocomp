
package control;

import dao.SiteModuloDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteModulo;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class ModuloController implements Serializable {

    private SiteModulo modulo;
    private SiteModuloDAO moduloDao;
    private List<SiteModulo> modulos;
    private List<SiteModulo> modulosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.modulo = new SiteModulo();
        this.moduloDao = new SiteModuloDAO();
        this.isEdit = false;
        modulos = listar();
    }
    
   public void limpar() {
        this.modulo = new SiteModulo();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            moduloDao.salvar(modulo);
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
        moduloDao.atualizar(modulo);
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
        moduloDao.deletar(modulo);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteModulo> listar() {
        this.modulos = moduloDao.listarTodos();
        return this.modulos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.modulo = ((SiteModulo) event.getObject());
        this.isEdit = true;
    }

    public SiteModulo getModulo() {
        return modulo;
    }

    public void setModulo(SiteModulo modulo) {
        this.modulo = modulo;
    }

    public List<SiteModulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<SiteModulo> modulos) {
        this.modulos = modulos;
    }

    public List<SiteModulo> getModulosFiltrados() {
        return modulosFiltrados;
    }

    public void setModulosFiltrados(List<SiteModulo> modulosFiltrados) {
        this.modulosFiltrados = modulosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    
}
