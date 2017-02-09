
package control;

import dao.FormacaoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteFormacao;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class FormacaoController implements Serializable {

    private SiteFormacao formacao;
    private FormacaoDAO formacaoDao;
    private List<SiteFormacao> formacoes;
    private List<SiteFormacao> formacoesFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.formacao = new SiteFormacao();
        this.formacaoDao = new FormacaoDAO();
        this.isEdit = false;
        formacoes = listar();
    }
    
   public void limpar() {
        this.formacao = new SiteFormacao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            formacaoDao.salvar(formacao);
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
        formacaoDao.atualizar(formacao);
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
        formacaoDao.deletar(formacao);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteFormacao> listar() {
        this.formacoes = formacaoDao.listarTodos();
        return this.formacoes;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.formacao = ((SiteFormacao) event.getObject());
        this.isEdit = true;
    }

    public SiteFormacao getFormacao() {
        return formacao;
    }

    public void setFormacao(SiteFormacao formacao) {
        this.formacao = formacao;
    }

    public List<SiteFormacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<SiteFormacao> formacoes) {
        this.formacoes = formacoes;
    }

    public List<SiteFormacao> getFormacoesFiltrados() {
        return formacoesFiltrados;
    }

    public void setFormacoesFiltrados(List<SiteFormacao> formacoesFiltrados) {
        this.formacoesFiltrados = formacoesFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    
}
