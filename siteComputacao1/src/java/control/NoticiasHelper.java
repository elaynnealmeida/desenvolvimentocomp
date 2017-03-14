package control;

import dao.SiteNoticiaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;  
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import model.SiteNoticia;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
//@ViewScoped
@SessionScoped
public class NoticiasHelper implements Serializable {

     private SiteNoticiaDAO noticiaDao;
    private List<SiteNoticia> noticias;
    private List<SiteNoticia> noticiasFiltradas;
    
    @PostConstruct
    public void init() {
        this.noticiaDao = new SiteNoticiaDAO();
        noticias = listar();
    }

    public List<SiteNoticia> listar() {
        this.noticias = noticiaDao.listarPorData();
        return this.noticias;
    }

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("noticia");
            SiteNoticia i = noticiaDao.buscaPorID(Integer.parseInt(id));
            System.out.println("Id: " + id);
            if (i.getImgCapa() != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(i.getImgCapa()));
            } else {
                return new DefaultStreamedContent();
            }

        }
    }

    public void pagina() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entrou no redirecionamento de pagina");
        String id = context.getExternalContext().getRequestParameterMap().get("noticia");
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/comentarios.xhtml?noticia=" + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SiteNoticia> getNoticias() {
        return noticias;
    }

    
    public String limitarTitulo(SiteNoticia not) {
        String retorno;
        String conteudo = not.getTitulo();
        if (conteudo.length() <= 30) {
            retorno = conteudo;
        } else {
            String novaString = conteudo.substring(0, 30);
            novaString += " ...";
            retorno = novaString;
        }
        return retorno;
    }

    public void setNoticias(List<SiteNoticia> noticias) {
        this.noticias = noticias;
    }

    public List<SiteNoticia> getNoticiasFiltradas() {
        return noticiasFiltradas;
    }

    public void setNoticiasFiltradas(List<SiteNoticia> noticiasFiltradas) {
        this.noticiasFiltradas = noticiasFiltradas;
    }
   
    
}
