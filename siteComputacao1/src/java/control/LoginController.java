package control;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    @PostConstruct
    public void init() {
        this.user = new TbUsersystem();
        this.userDao = new UsuarioDAO();
        perfilSelecionado = new SitePerfil();
        this.isAdmin = false;
        this.isUser = false;
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
                perfilSelecionado = user.getSitePerfilUsuarioList().get(0).getPerfilId();
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("perfil", perfilSelecionado);
                this.isUser = true;
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
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

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
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

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

}
