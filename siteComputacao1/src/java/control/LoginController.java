package control;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.SitePerfil;
import model.TbUsersystem;
import util.Servicos;

/**
 *
 * @author UFT
 */
@SessionScoped
@ManagedBean
public class LoginController implements Serializable {

    private TbUsersystem user;
    private UsuarioDAO userDao;
    private SitePerfil perfilSelecionado;
    private boolean isAdmin;
    private boolean isUser;
    private boolean multiploPerfil;
    private SitePerfil perfilDuplo;
    private SitePerfil perfilAtual;

    @PostConstruct
    public void init() {
        this.user = new TbUsersystem();
        this.userDao = new UsuarioDAO();
        perfilSelecionado = new SitePerfil();
        this.isAdmin = false;
        this.isUser = false;
        this.multiploPerfil = false;
        this.perfilAtual = null;
    }

    public void login() throws IOException {
        Servicos servicos = new Servicos();
        user.setPassword(servicos.criptografa(user.getPassword()));
        user = userDao.login(user);
        if (user != null) {
            if (user.getSitePerfilUsuarioList().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário sem Perfil, atribua um Perfil ao Usuário.", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                perfilSelecionado = user.getSitePerfilUsuarioList().get(0);
                this.perfilAtual = user.getSitePerfilUsuarioList().get(0);
                System.out.println("perfil selecionado: " + perfilSelecionado);
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("perfil", user.getSitePerfilUsuarioList().get(0));
                this.isUser = true;
                this.multiploPerfil = multiploPerfil();
                admin();
            }

        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifique login e senha!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            init();
        }
    }

    public void logout() throws IOException {
        this.isUser = false;
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                + "/faces/index.xhtml");

    }

    public void admin() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        TbUsersystem usuarioSession = (TbUsersystem) session.getAttribute("user");
        System.out.println("Usuario na Sessao: " + usuarioSession.getNomecompleto());
        if (user != null) {
            if (perfilSelecionado.getNome().equals("Coordenação")) {
                isAdmin = true;

            } else {
                isAdmin = false;
            }
        } else {
            isAdmin = false;
        }
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<SitePerfil> buscaPerfil(String q) {
        System.out.println("a ser pesquisado: " + q);
        List<SitePerfil> results = new ArrayList<SitePerfil>();
        if (user != null) {
            results = user.getSitePerfilUsuarioList();
        }
        //results = usuarioDao.listarTodosAtivos(q);
        System.out.println("lista: " + results.size());
        return results;
    }

    private boolean multiploPerfil() {
        List<SitePerfil> results = new ArrayList<SitePerfil>();
        if (user != null) {
            results = user.getSitePerfilUsuarioList();
            if (results.size() > 1) {
                this.perfilDuplo = results.get(1);
                return true;
            }
        }
        return false;
    }

    private void alternarPerfil() {
        List<SitePerfil> results = new ArrayList<SitePerfil>();
        if (user != null && this.multiploPerfil) {
            results = user.getSitePerfilUsuarioList();
            if (results.get(0) == this.perfilAtual) {
                this.perfilAtual = results.get(1);
                this.perfilDuplo = results.get(0);
            } else {
                this.perfilAtual = results.get(0);
                this.perfilDuplo = results.get(1);

            }
            this.perfilSelecionado = this.perfilAtual;
        }
    }

    public void confirmar() {
        alternarPerfil();
        System.out.println("Perfil Selecionado: " + this.perfilSelecionado);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        request.getSession().setAttribute("perfil", this.perfilDuplo);
    }

    public TbUsersystem getUser() {
        return user;
    }

    public void setUser(TbUsersystem user) {
        this.user = user;
    }

    public SitePerfil getPerfilSelecionado() {
        return perfilSelecionado;
    }

    public void setPerfilSelecionado(SitePerfil perfilSelecionado) {
        this.perfilSelecionado = perfilSelecionado;
    }

    public SitePerfil getPerfilDuplo() {
        return perfilDuplo;
    }

    public void setPerfilDuplo(SitePerfil perfilDuplo) {
        this.perfilDuplo = perfilDuplo;
    }

    public SitePerfil getPerfilAtual() {
        return perfilAtual;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public boolean isMultiploPerfil() {
        return multiploPerfil;
    }
}
