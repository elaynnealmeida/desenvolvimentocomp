package control;

import dao.SitePerfilDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.SitePerfil;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class SitePerfilController implements Serializable {

    private SitePerfil sitePerfil;
    private boolean isEdit;
    private SitePerfilDAO sitePerfilDao;
    private List<SitePerfil> perfis;
    private List<SitePerfil> perfisFiltrados;

    @PostConstruct
    public void init() {
        this.sitePerfil = new SitePerfil();
        this.isEdit = false;
        this.sitePerfilDao = new SitePerfilDAO();
        perfis = listar();
    }
    
    public void limpar() {
        this.sitePerfil = new SitePerfil();
        this.isEdit = false;
        listar();
    }
    
    public void salvar() {
        try {
            sitePerfil.setAtivo(true);
            sitePerfilDao.salvar(sitePerfil);
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
        try {
            sitePerfilDao.atualizar(sitePerfil);
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
        try {
            sitePerfil.setAtivo(false);
            sitePerfilDao.atualizar(sitePerfil);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public List<SitePerfil> listar() {
        this.perfis = sitePerfilDao.listarTodosAtivos();
        return this.perfis;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.sitePerfil = ((SitePerfil) event.getObject());
        this.isEdit = true;
    }
    

    public SitePerfil getSitePerfil() {
        return sitePerfil;
    }

    public void setSitePerfil(SitePerfil sitePerfil) {
        this.sitePerfil = sitePerfil;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public SitePerfilDAO getSitePerfilDao() {
        return sitePerfilDao;
    }

    public void setSitePerfilDao(SitePerfilDAO sitePerfilDao) {
        this.sitePerfilDao = sitePerfilDao;
    }

    public List<SitePerfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<SitePerfil> perfis) {
        this.perfis = perfis;
    }

    public List<SitePerfil> getPerfisFiltrados() {
        return perfisFiltrados;
    }

    public void setPerfisFiltrados(List<SitePerfil> perfisFiltrados) {
        this.perfisFiltrados = perfisFiltrados;
    }

}
