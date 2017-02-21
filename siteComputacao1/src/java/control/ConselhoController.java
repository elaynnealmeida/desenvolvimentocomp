
package control;

import dao.ConselhoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteConselho;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class ConselhoController implements Serializable {

    private SiteConselho conselho;
    private ConselhoDAO conselhoDao;
    private List<SiteConselho> conselhos;
    private List<SiteConselho> conselhosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.conselho = new SiteConselho();
        this.conselhoDao = new ConselhoDAO();
        this.isEdit = false;
        conselhos = listar();
    }
    
   public void limpar() {
        this.conselho = new SiteConselho();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            conselhoDao.salvar(conselho);
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
        conselhoDao.atualizar(conselho);
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
        conselhoDao.deletar(conselho);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteConselho> listar() {
        this.conselhos = conselhoDao.listarTodos();
        return this.conselhos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.conselho = ((SiteConselho) event.getObject());
        this.isEdit = true;
    }

    public SiteConselho getConselho() {
        return conselho;
    }

    public void setConselho(SiteConselho conselho) {
        this.conselho = conselho;
    }

    public List<SiteConselho> getConselhos() {
        return conselhos;
    }

    public void setConselhos(List<SiteConselho> conselhos) {
        this.conselhos = conselhos;
    }

    public List<SiteConselho> getConselhosFiltrados() {
        return conselhosFiltrados;
    }

    public void setConselhosFiltrados(List<SiteConselho> conselhosFiltrados) {
        this.conselhosFiltrados = conselhosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    
}
