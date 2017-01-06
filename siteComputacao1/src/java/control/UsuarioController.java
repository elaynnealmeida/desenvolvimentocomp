package control;

import dao.SiteCargoDAO;
import dao.SitePerfilDAO;
import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteCargo;
import model.SitePerfil;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;
import util.Servicos;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
//@SessionScoped
public class UsuarioController implements Serializable {

    private TbUsersystem usuario;
    private UsuarioDAO usuarioDao;
    private List<TbUsersystem> usuarios;
    private List<TbUsersystem> usuariosFiltrados;
    private List<SelectItem> cargos;
    private SiteCargo cargo;
    private List<SitePerfil> selectedPerfis;
    private List<SelectItem> perfis;
    private SitePerfilDAO perfilDao;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.usuario = new TbUsersystem();
        this.usuarioDao = new UsuarioDAO();
        this.cargo = new SiteCargo();
        this.perfilDao = new SitePerfilDAO();
        this.selectedPerfis = new ArrayList<SitePerfil>();
        this.isEdit = false;
        perfis = listarPerfis();
        listar();
    }

    public void limpar() {
        this.usuario = new TbUsersystem();
        this.isEdit = false;
        this.usuarios = listar();
        this.selectedPerfis = new ArrayList<SitePerfil>();
        listarPerfis();
    }

    public void salvar() {
        Servicos servico = new Servicos();
        try {
            usuario.setReceberemail(true);
            usuario.setShowemail(true);
            usuario.setShowphone(true);
            usuario.setPassword(servico.criptografa(usuario.getPassword()));
            usuario.setStatus("ATIVO");
            //for (int i = 0; i < selectedPerfis.size(); i++) {
            //    usuario.getSitePerfilUsuarioList().get(i).setAtivo(true);
           // }
            usuario.setSitePerfilUsuarioList(selectedPerfis);
            usuarioDao.salvar(usuario);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            System.out.println("ERRO: " + e.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        Servicos servico = new Servicos();
        try {
           // for (int i = 0; i < selectedPerfis.size(); i++) {
           //     usuario.getSitePerfilUsuarioList().get(i).setAtivo(true);
          //  }
            usuario.setSitePerfilUsuarioList(selectedPerfis);
            usuario.setPassword(servico.criptografa(usuario.getPassword()));
            usuarioDao.atualizar(usuario);
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar editar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try {
            usuario.setStatus("DESATIVADO");
            usuario.setSitePerfilUsuarioList(selectedPerfis);
            usuarioDao.atualizar(usuario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteCargo> selectCargo(String q) {
        List<SiteCargo> results = new ArrayList<SiteCargo>();
        SiteCargoDAO cargoDao = new SiteCargoDAO();
        results = cargoDao.listarTodos();
        return results;
    }

    public List<SelectItem> listarPerfis() {
        //System.out.println("entrou no listar perfis: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<SitePerfil> result = new ArrayList<SitePerfil>();
        result = perfilDao.listarTodosAtivos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public List<TbUsersystem> listar() {
        this.usuarios = usuarioDao.listarTodosAtivos2();
        return this.usuarios;
    }

    public void onRowSelect(SelectEvent event) {
        this.usuario = ((TbUsersystem) event.getObject());
        this.selectedPerfis = usuario.getSitePerfilUsuarioList();
        this.isEdit = true;
    }

    public TbUsersystem getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUsersystem usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<TbUsersystem> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUsersystem> usuarios) {
        this.usuarios = usuarios;
    }

    public List<TbUsersystem> getUsuariosFiltrados() {
        return usuariosFiltrados;
    }

    public void setUsuariosFiltrados(List<TbUsersystem> usuariosFiltrados) {
        this.usuariosFiltrados = usuariosFiltrados;
    }

    public List<SelectItem> getCargos() {
        return cargos;
    }

    public void setCargos(List<SelectItem> cargos) {
        this.cargos = cargos;
    }

    public SiteCargo getCargo() {
        return cargo;
    }

    public void setCargo(SiteCargo cargo) {
        this.cargo = cargo;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SitePerfil> getSelectedPerfis() {
        return selectedPerfis;
    }

    public void setSelectedPerfis(List<SitePerfil> selectedPerfis) {
        this.selectedPerfis = selectedPerfis;
    }

    public List<SelectItem> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<SelectItem> perfis) {
        this.perfis = perfis;
    }

}
