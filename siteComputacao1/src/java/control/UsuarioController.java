package control;

import dao.SiteCargoDAO;
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
import model.SiteCargo;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;
import util.Servicos;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{

    private TbUsersystem usuario;    
    private UsuarioDAO usuarioDao;
    private List<TbUsersystem> usuarios;
    private List<TbUsersystem> usuariosFiltrados;
    private List<SelectItem> cargos;
    private SiteCargo cargo;
    private boolean isEdit;
    
    @PostConstruct
    public void init() {
        this.usuario = new TbUsersystem();
        this.usuarioDao = new UsuarioDAO();
        this.cargo = new SiteCargo();
        this.isEdit = false;  
        listar();
    }
    
    public void limpar() {
        this.usuario = new TbUsersystem();
        this.isEdit = false;
        this.usuarios = listar();
    }
    
    public void salvar() {
        Servicos servico = new Servicos();
        try {
            usuario.setReceberemail(true);
            usuario.setShowemail(true);
            usuario.setShowphone(true);
            usuario.setPassword(servico.criptografa(usuario.getPassword()));
            usuario.setStatus("ATIVO");
            usuarioDao.salvar(usuario);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            System.out.println("ERRO: "+e.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
    
    public void atualizar() {
        Servicos servico = new Servicos();
        try {
            usuario.setPassword(servico.criptografa(usuario.getPassword()));
            usuarioDao.atualizar(usuario);
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
            usuario.setStatus("DESATIVADO");
            usuarioDao.atualizar(usuario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteCargo> selectCargo(String q) {
        List<SiteCargo> results = new ArrayList<SiteCargo>();
        SiteCargoDAO cargoDao = new SiteCargoDAO();
        results = cargoDao.listarTodos();
        return results;
    }
    
    public List<TbUsersystem> listar() {
        this.usuarios = usuarioDao.listarTodos();
        return this.usuarios;
    }
    
    public void onRowSelect(SelectEvent event) {
        this.usuario = ((TbUsersystem) event.getObject());
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
    
}
