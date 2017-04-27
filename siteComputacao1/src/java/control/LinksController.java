
package control;

import dao.LinksDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.SiteLinks;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class LinksController implements Serializable {

    private SiteLinks link;
    private LinksDAO linkDao;
    private List<SiteLinks> links;
    private List<SiteLinks> linkssFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.link = new SiteLinks();
        this.linkDao = new LinksDAO();
        this.isEdit = false;
        links = listar();
    }
    
   public void limpar() {
        this.link = new SiteLinks();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            link.setUsuarioId((TbUsersystem) request.getSession().getAttribute("user"));
            linkDao.salvar(link);
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
        linkDao.atualizar(link);
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
        linkDao.deletar(link);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteLinks> listar() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        TbUsersystem user = (TbUsersystem) request.getSession().getAttribute("user");
        if(user.getSitePerfilUsuarioList().get(0).getId()==1){//coordenação
            this.links = linkDao.listarTodos();
        }
        else {
            this.links = linkDao.listarPorUsuario(user);
        }
        
        return this.links;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.link = ((SiteLinks) event.getObject());
        this.isEdit = true;
    }

    public SiteLinks getLink() {
        return link;
    }

    public void setLink(SiteLinks link) {
        this.link = link;
    }

    public List<SiteLinks> getLinks() {
        return links;
    }

    public void setLinks(List<SiteLinks> links) {
        this.links = links;
    }

    public List<SiteLinks> getLinkssFiltrados() {
        return linkssFiltrados;
    }

    public void setLinkssFiltrados(List<SiteLinks> linkssFiltrados) {
        this.linkssFiltrados = linkssFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
     
     
    
}
