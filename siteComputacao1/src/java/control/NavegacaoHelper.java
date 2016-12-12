package control;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author UFT
 */
@ManagedBean
public class NavegacaoHelper {

    public void paginaUsuario() throws IOException {
        //FacesContext context = FacesContext.getCurrentInstance();
        // System.out.println("entrou no redirecionamento para usuario");
        // context.getExternalContext().redirect(url);
        // FacesContext.getCurrentInstance().getExternalContext().redirect("pages/usuario.xhtml");
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/usuario.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaPerfil() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/perfil.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // FacesContext context = FacesContext.getCurrentInstance();
        // System.out.println("entrou no redirecionamento para perfil");
        // FacesContext.getCurrentInstance().getExternalContext().redirect("pages/perfil.xhtml");
    }

    public void paginaProfessor() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/professor.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaCargo() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/sitecargo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaFuncao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/sitefuncao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaTag() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/tags.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaAssociarPerfil() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/usuarioperfil.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaNoticias() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/professores/noticias.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void inicio() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
