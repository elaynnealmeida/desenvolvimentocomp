
package control;

import dao.TipoPublicacaoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteTipoPublicacao;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class TipoPublicacaoController implements Serializable {

    private SiteTipoPublicacao tipoPublicacao;
    private TipoPublicacaoDAO tipoDPublicacaoDao;
    private List<SiteTipoPublicacao> tiposPublicacoes;
    private List<SiteTipoPublicacao> tiposPublicacoesFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.tipoPublicacao = new SiteTipoPublicacao();
        this.tipoDPublicacaoDao = new TipoPublicacaoDAO();
        this.isEdit = false;
        tiposPublicacoes = listar();
    }
    
   public void limpar() {
        this.tipoPublicacao = new SiteTipoPublicacao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            tipoDPublicacaoDao.salvar(tipoPublicacao);
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
        tipoDPublicacaoDao.atualizar(tipoPublicacao);
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
        tipoDPublicacaoDao.deletar(tipoPublicacao);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
   
    public List<SiteTipoPublicacao> listar() {
        this.tiposPublicacoes = tipoDPublicacaoDao.listarTodos();
        return this.tiposPublicacoes;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.tipoPublicacao = ((SiteTipoPublicacao) event.getObject());
        this.isEdit = true;
    }

    public SiteTipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(SiteTipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public List<SiteTipoPublicacao> getTiposPublicacoes() {
        return tiposPublicacoes;
    }

    public void setTiposPublicacoes(List<SiteTipoPublicacao> tiposPublicacoes) {
        this.tiposPublicacoes = tiposPublicacoes;
    }

    public List<SiteTipoPublicacao> getTiposPublicacoesFiltrados() {
        return tiposPublicacoesFiltrados;
    }

    public void setTiposPublicacoesFiltrados(List<SiteTipoPublicacao> tiposPublicacoesFiltrados) {
        this.tiposPublicacoesFiltrados = tiposPublicacoesFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
