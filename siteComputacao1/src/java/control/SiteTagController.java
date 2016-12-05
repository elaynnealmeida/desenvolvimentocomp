
package control;

import dao.SiteTagDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.SiteTags;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class SiteTagController implements Serializable {

    private SiteTags tag;
    private SiteTagDAO tagDao;
    private List<SiteTags> tags;
    private List<SiteTags> tagsFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.tag = new SiteTags();
        this.tagDao = new SiteTagDAO();
        this.isEdit = false;
        tags = listar();
    }
    
   public void limpar() {
        this.tag = new SiteTags();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            tagDao.salvar(tag);
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
        tagDao.atualizar(tag);
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
        tagDao.deletar(tag);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteTags> listar() {
        this.tags = tagDao.listarTodos();
        return this.tags;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.tag = ((SiteTags) event.getObject());
        this.isEdit = true;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public SiteTags getTag() {
        return tag;
    }

    public void setTag(SiteTags tag) {
        this.tag = tag;
    }

    public List<SiteTags> getTags() {
        return tags;
    }

    public void setTags(List<SiteTags> tags) {
        this.tags = tags;
    }

    public List<SiteTags> getTagsFiltradas() {
        return tagsFiltradas;
    }

    public void setTagsFiltradas(List<SiteTags> tagsFiltradas) {
        this.tagsFiltradas = tagsFiltradas;
    }

}
