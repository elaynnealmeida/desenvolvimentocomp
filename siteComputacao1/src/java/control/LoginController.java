package control;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.SitePerfil;
import model.TbUsersystem;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import util.Servicos;

/**
 *
 * @author UFT
 */
@SessionScoped
@ManagedBean
public class LoginController implements Serializable {

    private TbUsersystem user;
    private TbUsersystem user2;
    private TbUsersystem user3;
    private UsuarioDAO userDao;
    private SitePerfil perfilSelecionado;
    private boolean isAdmin;
    private boolean isUser;
    private boolean multiploPerfil;
    private SitePerfil perfilDuplo;
    private SitePerfil perfilAtual;
    private FacesMessage message2;
    private String mensagem;
    private FacesContext context;
    private String currentPage;
    private Servicos servicos;

    @PostConstruct
    public void init() {
        this.user = new TbUsersystem();
        this.user2 = new TbUsersystem();
        this.user3 = new TbUsersystem();
        this.userDao = new UsuarioDAO();
        this.servicos = new Servicos();
        perfilSelecionado = new SitePerfil();
        this.isAdmin = false;
        this.isUser = false;
        this.multiploPerfil = false;
        this.perfilAtual = null;
        this.message2 = new FacesMessage();
        this.mensagem = new String();
        context = FacesContext.getCurrentInstance();
        currentPage = new String();
        currentPage = context.getViewRoot().getViewId();
    }

    public void login() throws IOException {
        //Servicos servicos = new Servicos();
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
            System.out.println("Verifique login e senha! ");
            this.mensagem = "Verifique login e senha! ";
            System.out.println(this.mensagem);
            //FacesMessage 
            message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifique login e senha!", null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
            init();
        }
    }

    public void alteraSenha() throws IOException {
        System.out.println("entrou no altera senha! ");

        user2.setPassword(servicos.criptografa(user2.getPassword()));
        String senha = new String();
        senha = user.getPassword();
        user.setPassword(servicos.criptografa(user.getPassword()));
        user2 = userDao.login(user2);
        if (user2 != null) {
            System.out.println("entrou no if ");
            System.out.println("encontrou o user! ");
            this.user.setEmail(user2.getEmail());
            userDao.atualizar(user);
            user.setPassword(senha);
            login();
        } else {
            System.out.println("entoru no else ");
            System.out.println("Verifique login e senha! ");
            this.mensagem = "Login ou senha incorreto! ";
            System.out.println(this.mensagem);
            //FacesMessage 
            message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha incorreto! ", null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
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

    public void refresh() {
        System.out.println("entrou no refresh: ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        Enumeration<String> parametros = request.getParameterNames();
        // String url[] = request.getParameterNames();
        FacesContext context = FacesContext.getCurrentInstance();
        String currentPage = context.getViewRoot().getViewId();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        System.out.println("parametros: " + parametros.nextElement());
        context.renderResponse();
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

        request.getSession().setAttribute("perfil", this.perfilSelecionado);
        refresh();
    }

    public void recuperasenha() throws EmailException {
        System.out.println("Entrou no enviar, email: " + user3.getEmail());
        SimpleEmail email = new SimpleEmail();
        //email.setHostName("mail.myserver.com"); // o servidor SMTP para envio do e-mail
        user3 = userDao.buscaEmail(user3);
        if (user3 == null) {
            this.mensagem = "Email não encontrado! ";
            System.out.println(this.mensagem);
            //FacesMessage 
            this.user3 = new TbUsersystem();
            message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email não encontrado! ", null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        } else {
            String senha = new String();
            senha = Gerador_de_Senhas();
            user3.setPassword(servicos.criptografa(senha));
            try {
                userDao.atualizar(user3);
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(587);
                email.setAuthenticator(new DefaultAuthenticator("coordenacaocomputacaouft@gmail.com", "sitecomputacaouft"));
                email.setTLS(true);
                email.addTo(user3.getEmail(), user3.getNomecompleto()); //destinatário
                email.setFrom("coordenacaocomputacaouft@gmail.com", "Computação"); // remetente
                email.setSubject("Senha de acesso ao site"); // assunto do e-mail
                email.setMsg("Sua nova senha de acesso ao site é: " + senha + " \nAltere em: https://palmas.uft.edu.br/grad/ccomp/cienciacomputacao/"); //conteudo do e-mail
                email.send();
                this.mensagem = "Nova senha enviada para o email informado! ";
                System.out.println(this.mensagem);
                //FacesMessage 
                message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova senha enviada para o email informado! ", null);
                FacesContext.getCurrentInstance().addMessage(null, message2);
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar alterar senha! ", null);
                FacesContext.getCurrentInstance().addMessage(null, message2);
            }

        }

    }

    public String Gerador_de_Senhas() {
        Random ran = new Random();
        String[] letras = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String b = "";
        for (int i = 0; i < 6; i++) {
            int a = ran.nextInt(letras.length);
            b += letras[a];
        }
        System.out.print("Senha gerada: " + b);
        return b;

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

    public FacesMessage getMessage2() {
        return message2;
    }

    public void setMessage2(FacesMessage message2) {
        this.message2 = message2;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TbUsersystem getUser2() {
        return user2;
    }

    public void setUser2(TbUsersystem user2) {
        this.user2 = user2;
    }

    public TbUsersystem getUser3() {
        return user3;
    }

    public void setUser3(TbUsersystem user3) {
        this.user3 = user3;
    }

}
