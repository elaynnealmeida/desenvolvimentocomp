package control;

import dao.SitePerfilDAO;
import dao.SitePerfilUsuarioDAO;
import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SitePerfil;
import model.SitePerfilUsuario;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class SitePerfilUsuarioController implements Serializable {

    private SitePerfilUsuario sitePerfilUsuario;
    private List<SitePerfilUsuario> sitePerfilUsuarios;
    private List<SelectItem> perfis;
    private List<TbUsersystem> usuarios;
    private SitePerfilUsuarioDAO siteperfilusuarioDao;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.sitePerfilUsuario = new SitePerfilUsuario();
        this.siteperfilusuarioDao = new SitePerfilUsuarioDAO();
        this.isEdit = false;
        sitePerfilUsuarios = listar();
    }

    public void limpar() {
        this.sitePerfilUsuario = new SitePerfilUsuario();
        this.isEdit = false;
        listar();
    }

    public List<SitePerfilUsuario> listar() {
        this.sitePerfilUsuarios = this.siteperfilusuarioDao.listarTodosAtivos();
        return this.sitePerfilUsuarios;
    }

    public void onRowSelect(SelectEvent event) {
        this.sitePerfilUsuario = ((SitePerfilUsuario) event.getObject());
        this.isEdit = true;
    }

    public void salvar() {
        try {
            System.out.println("usuario: "+sitePerfilUsuario.getUsuarioId().getNomecompleto());
            System.out.println("perfil: "+sitePerfilUsuario.getPerfilId().getNome());
            sitePerfilUsuario.setAtivo(true);
            siteperfilusuarioDao.salvar(sitePerfilUsuario);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            System.out.println("ERRO: "+e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
            siteperfilusuarioDao.atualizar(sitePerfilUsuario);
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
            sitePerfilUsuario.setAtivo(false);
            siteperfilusuarioDao.atualizar(sitePerfilUsuario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

  /*  public List<TbUsersystem> buscaUsuario(String q) {
        System.out.println("a ser pesquisado: " + q);
        List<TbUsersystem> results = new ArrayList<TbUsersystem>();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        results = usuarioDao.listarTodosAtivos(q);
        System.out.println("lista: " + results.size());
        return results;
    }

    public List<SelectItem> getPerfil() {
        System.out.println("entrou no controlador");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<SitePerfil> result = new ArrayList<SitePerfil>();
        SitePerfilDAO perfilDao = new SitePerfilDAO();
        result = perfilDao.listarTodosAtivos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome()));
            System.out.println("perfil: " + result.get(i).getNome());
        }

        return toReturn;
    }*/

    public SitePerfilUsuario getSitePerfilUsuario() {
        return sitePerfilUsuario;
    }

    public void setSitePerfilUsuario(SitePerfilUsuario sitePerfilUsuario) {
        this.sitePerfilUsuario = sitePerfilUsuario;
    }

    public List<SelectItem> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<SelectItem> perfis) {
        this.perfis = perfis;
    }

    public List<TbUsersystem> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUsersystem> usuarios) {
        this.usuarios = usuarios;
    }

    public SitePerfilUsuarioDAO getSiteperfilusuarioDao() {
        return siteperfilusuarioDao;
    }

    public void setSiteperfilusuarioDao(SitePerfilUsuarioDAO siteperfilusuarioDao) {
        this.siteperfilusuarioDao = siteperfilusuarioDao;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SitePerfilUsuario> getSitePerfilUsuarios() {
        return sitePerfilUsuarios;
    }

    public void setSitePerfilUsuarios(List<SitePerfilUsuario> sitePerfilUsuarios) {
        this.sitePerfilUsuarios = sitePerfilUsuarios;
    }

    
}
