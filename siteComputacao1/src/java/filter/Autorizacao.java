package filter;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import model.SitePerfil;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
public class Autorizacao implements PhaseListener {

    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
//adiquirindo o FacesContext.
        String currentPage = facesContext.getViewRoot().getViewId();
        
//armazenando a página que fez a requisição. (a string da pág. atual ex: "/pag.jsf")
        boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1);
//fazendo a verificação mais básica de todas... se é a página de login.
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

//adquirindo a sessão (essa mesma onde você deverá guardar seu usuário no nível de sessão com descritor currentUser).
        TbUsersystem user = (TbUsersystem) session.getAttribute("user");
        SitePerfil perfil = (SitePerfil) session.getAttribute("perfil");
//apenas recuperando o valor da sessão.
        if (!isLoginPage && user == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "loginPage");
//bem, se não está logado redireciona pra lógica que (navigatio rule) atende a loginPage
        } else if (user != null) {//verificar se o usuario atual tem acesso a página atual.
            // boolean temAcesso = currentPage.contains("pages");
            if (currentPage.contains("pages") && !perfil.getNome().equals("Coordenação")) {
                System.out.println("entrou: " + perfil.getNome());
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, "loginPage");
            }
        }

//caso contrário o jsf passa tranquilamente por aqui!!!
    }

    public void beforePhase(PhaseEvent event) {
//poderia ter sido escrito nesse evento antes da "fase" (lembra do básico do jsf, o ciclo de vida e as fases...
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
