
package control;

import dao.ConselhoDAO;
import dao.PublicacaoDAO;
import dao.TipoPublicacaoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteConselho;
import model.SitePublicacao;
import model.SiteTipoPublicacao;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class PublicacaoController implements Serializable {
     private SitePublicacao publicacao;
    private PublicacaoDAO publicacaoDao;
    private List<SitePublicacao> publicacoes;
    private List<SitePublicacao> publicacoesFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.publicacao = new SitePublicacao();
        this.publicacaoDao = new PublicacaoDAO();
        this.isEdit = false;
        publicacoes = listar();
    }
    
   public void limpar() {
        this.publicacao = new SitePublicacao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            publicacaoDao.salvar(publicacao);
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
        publicacaoDao.atualizar(publicacao);
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
        publicacaoDao.deletar(publicacao);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   
    public List<SitePublicacao> listar() {
        this.publicacoes = publicacaoDao.listarTodos();
        return this.publicacoes;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.publicacao = ((SitePublicacao) event.getObject());
        this.isEdit = true;
    }
     
     public List<SelectItem> getConselho() {
        System.out.println("entrou no listar conselho: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        ConselhoDAO tpdDao = new ConselhoDAO();
        List<SiteConselho> result = new ArrayList<SiteConselho>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getSigla()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    
     public List<SelectItem> getTpPublicacao() {
        System.out.println("entrou no listar tp publicacao: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TipoPublicacaoDAO tpdDao = new TipoPublicacaoDAO();
        List<SiteTipoPublicacao> result = new ArrayList<SiteTipoPublicacao>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public SitePublicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(SitePublicacao publicacao) {
        this.publicacao = publicacao;
    }

    public List<SitePublicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<SitePublicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public List<SitePublicacao> getPublicacoesFiltrados() {
        return publicacoesFiltrados;
    }

    public void setPublicacoesFiltrados(List<SitePublicacao> publicacoesFiltrados) {
        this.publicacoesFiltrados = publicacoesFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
     
     
}
