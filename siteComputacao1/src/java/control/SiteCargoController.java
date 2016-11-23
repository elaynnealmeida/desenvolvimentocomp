
package control;

import dao.SiteCargoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.SiteCargo;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class SiteCargoController implements Serializable {

    private SiteCargo cargo;
    private SiteCargoDAO cargoDao;
    private List<SiteCargo> cargos;
    private List<SiteCargo> cargosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.cargo = new SiteCargo();
        this.cargoDao = new SiteCargoDAO();
        this.isEdit = false;
        cargos = listar();
    }
    
   public void limpar() {
        this.cargo = new SiteCargo();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            cargoDao.salvar(cargo);
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
        cargoDao.atualizar(cargo);
        FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try{
        cargoDao.deletar(cargo);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteCargo> selectCargo(String query) {
        List<SiteCargo> results = new ArrayList<SiteCargo>();
        List<SiteCargo> result = new ArrayList<SiteCargo>();
        SiteCargoDAO cargoDao = new SiteCargoDAO();
        results = cargoDao.listarTodos();       
        for(int c = 0;c<results.size();c++){
            result.add(results.get(c));
        }
        return results;
    }

    public List<SiteCargo> listar() {
        this.cargos = cargoDao.listarTodos();
        return this.cargos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.cargo = ((SiteCargo) event.getObject());
        this.isEdit = true;
    }

    public SiteCargo getCargo() {
        return cargo;
    }

    public void setCargo(SiteCargo cargo) {
        this.cargo = cargo;
    }

    public List<SiteCargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<SiteCargo> cargos) {
        this.cargos = cargos;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SiteCargo> getCargosFiltrados() {
        return cargosFiltrados;
    }

    public void setCargosFiltrados(List<SiteCargo> cargosFiltrados) {
        this.cargosFiltrados = cargosFiltrados;
    }
     
}

