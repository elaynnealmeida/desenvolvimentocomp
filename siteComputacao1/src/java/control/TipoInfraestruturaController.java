
package control;

import dao.TipoInfraestruturaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteTipoInfraestrutura;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class TipoInfraestruturaController implements Serializable {

    private SiteTipoInfraestrutura tipoInfra;
    private TipoInfraestruturaDAO tipoInfraDao;
    private List<SiteTipoInfraestrutura> tiposInfras;
    private List<SiteTipoInfraestrutura> tiposInfrasFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.tipoInfra = new SiteTipoInfraestrutura();
        this.tipoInfraDao = new TipoInfraestruturaDAO();
        this.isEdit = false;
        tiposInfras = listar();
    }
    
   public void limpar() {
        this.tipoInfra = new SiteTipoInfraestrutura();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            tipoInfraDao.salvar(tipoInfra);
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
        tipoInfraDao.atualizar(tipoInfra);
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
        tipoInfraDao.deletar(tipoInfra);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteTipoInfraestrutura> listar() {
        this.tiposInfras = tipoInfraDao.listarTodos();
        return this.tiposInfras;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.tipoInfra = ((SiteTipoInfraestrutura) event.getObject());
        this.isEdit = true;
    }

    public SiteTipoInfraestrutura getTipoInfra() {
        return tipoInfra;
    }

    public void setTipoInfra(SiteTipoInfraestrutura tipoInfra) {
        this.tipoInfra = tipoInfra;
    }

    public List<SiteTipoInfraestrutura> getTiposInfras() {
        return tiposInfras;
    }

    public void setTiposInfras(List<SiteTipoInfraestrutura> tiposInfras) {
        this.tiposInfras = tiposInfras;
    }

    public List<SiteTipoInfraestrutura> getTiposInfrasFiltrados() {
        return tiposInfrasFiltrados;
    }

    public void setTiposInfrasFiltrados(List<SiteTipoInfraestrutura> tiposInfrasFiltrados) {
        this.tiposInfrasFiltrados = tiposInfrasFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    
}
