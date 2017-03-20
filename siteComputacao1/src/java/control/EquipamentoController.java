
package control;

import dao.EquipamentoDAO;
import dao.TipoEquipamentoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteEquipamento;
import model.SiteTipoEquipamento;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class EquipamentoController implements Serializable {
    private SiteEquipamento equipamento;
    private EquipamentoDAO equipamentoDao;
    private List<SiteEquipamento> equipamentos;
    private List<SiteEquipamento> equipamentosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.equipamento = new SiteEquipamento();
        this.equipamentoDao = new EquipamentoDAO();
        this.isEdit = false;
        equipamentos = listar();
    }
    
   public void limpar() {
        this.equipamento = new SiteEquipamento();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            equipamentoDao.salvar(equipamento);
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
        equipamentoDao.atualizar(equipamento);
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
        equipamentoDao.deletar(equipamento);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   
    public List<SiteEquipamento> listar() {
        this.equipamentos = equipamentoDao.listarTodos();
        return this.equipamentos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.equipamento = ((SiteEquipamento) event.getObject());
        this.isEdit = true;
    }
     
     public List<SelectItem> getTipoEquipamento() {
        System.out.println("entrou no listar tipo de equipamento: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TipoEquipamentoDAO tpdDao = new TipoEquipamentoDAO();
        List<SiteTipoEquipamento> result = new ArrayList<SiteTipoEquipamento>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public SiteEquipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(SiteEquipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<SiteEquipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<SiteEquipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<SiteEquipamento> getEquipamentosFiltrados() {
        return equipamentosFiltrados;
    }

    public void setEquipamentosFiltrados(List<SiteEquipamento> equipamentosFiltrados) {
        this.equipamentosFiltrados = equipamentosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
