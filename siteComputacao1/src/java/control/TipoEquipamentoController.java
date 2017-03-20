
package control;

import dao.TipoEquipamentoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteTipoEquipamento;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class TipoEquipamentoController implements Serializable {

    private SiteTipoEquipamento tipoEquipamento;
    private TipoEquipamentoDAO tipoEquipamentoDao;
    private List<SiteTipoEquipamento> tipoEquipamentos;
    private List<SiteTipoEquipamento> tipoEquipamentosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.tipoEquipamento = new SiteTipoEquipamento();
        this.tipoEquipamentoDao = new TipoEquipamentoDAO();
        this.isEdit = false;
        tipoEquipamentos = listar();
    }
    
   public void limpar() {
        this.tipoEquipamento = new SiteTipoEquipamento();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            tipoEquipamentoDao.salvar(tipoEquipamento);
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
        tipoEquipamentoDao.atualizar(tipoEquipamento);
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
        tipoEquipamentoDao.deletar(tipoEquipamento);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteTipoEquipamento> listar() {
        this.tipoEquipamentos = tipoEquipamentoDao.listarTodos();
        return this.tipoEquipamentos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.tipoEquipamento = ((SiteTipoEquipamento) event.getObject());
        this.isEdit = true;
    }

    public SiteTipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(SiteTipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public List<SiteTipoEquipamento> getTipoEquipamentos() {
        return tipoEquipamentos;
    }

    public void setTipoEquipamentos(List<SiteTipoEquipamento> tipoEquipamentos) {
        this.tipoEquipamentos = tipoEquipamentos;
    }

    public List<SiteTipoEquipamento> getTipoEquipamentosFiltrados() {
        return tipoEquipamentosFiltrados;
    }

    public void setTipoEquipamentosFiltrados(List<SiteTipoEquipamento> tipoEquipamentosFiltrados) {
        this.tipoEquipamentosFiltrados = tipoEquipamentosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
