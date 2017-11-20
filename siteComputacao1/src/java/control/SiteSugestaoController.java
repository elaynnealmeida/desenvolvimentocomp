
package control;

import dao.SiteSugestaoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteSugestao;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class SiteSugestaoController implements Serializable {

    private SiteSugestao sugestao;
    private SiteSugestaoDAO sugestaoDao;
    private List<SiteSugestao> sugestoes;
    private List<SiteSugestao> sugestoesFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.sugestao = new SiteSugestao();
        this.sugestaoDao = new SiteSugestaoDAO();
        this.isEdit = false;
        sugestoes = listar();
    }
    
   public void limpar() {
        this.sugestao = new SiteSugestao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            sugestaoDao.salvar(sugestao);
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
        sugestaoDao.atualizar(sugestao);
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
        sugestaoDao.deletar(sugestao);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteSugestao> listar() {
        this.sugestoes = sugestaoDao.listarTodos();
        return this.sugestoes;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.sugestao = ((SiteSugestao) event.getObject());
        this.isEdit = true;
    }
    
}
