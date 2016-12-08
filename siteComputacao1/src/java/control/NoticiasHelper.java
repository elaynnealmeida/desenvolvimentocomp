package control;

import dao.SiteNoticiaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@SessionScoped
public class NoticiasHelper implements Serializable {

    private SiteNoticia noticia;
    private SiteNoticiaDAO noticiaDao;
    private List<SiteNoticia> noticias;

    @PostConstruct
    public void init() {
        this.noticia = new SiteNoticia();
        this.noticiaDao = new SiteNoticiaDAO();
        noticias = listar();
    }

    public SiteNoticia getNoticia() {
        return noticia;
    }

    public void setNoticia(SiteNoticia noticia) {
        this.noticia = noticia;
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
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/comentarios.xhtml");
    }

    public List<SiteNoticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<SiteNoticia> noticias) {
        this.noticias = noticias;
    }

}
