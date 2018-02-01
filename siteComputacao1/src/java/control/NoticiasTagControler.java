package control;

import dao.SiteNoticiaDAO;
import dao.SiteTagDAO;
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
import model.SiteTags;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
//@ViewScoped
@SessionScoped
public class NoticiasTagControler implements Serializable {

    private SiteNoticiaDAO noticiaDao;
    private SiteTagDAO tagDao;
    private List<SiteNoticia> noticiasTag;
    private List<SiteNoticia> noticiasFiltradas;
    private SiteTags tag;

    @PostConstruct
    public void init() {
        this.noticiaDao = new SiteNoticiaDAO();
        this.tagDao = new SiteTagDAO();
        this.tag = new SiteTags();
        System.out.println("tag init: " + tag.getDescricao());
        noticiasTag = listarPorTag();
    }

    public List<SiteNoticia> listarPorTag() {
        System.out.println("entrou no listar por tag");
        FacesContext context = FacesContext.getCurrentInstance();
        String id = context.getExternalContext().getRequestParameterMap().get("tag");
        System.out.println("id: " + id);
        if (tag == null) {
            System.out.println("entrou no listar pelo parametro");
            if (id != null) {
                tag = tagDao.buscaPorID(Integer.parseInt(id));
            }
            this.noticiasTag = noticiaDao.listarNoticiaPorTag(tag);
            return this.noticiasTag;
        } else {
            System.out.println("entrou no ids iguais");
            //comentario.setNoticiaId(noticiaDao.buscaPorID(Integer.parseInt(id)));
            //comentario.setNoticiaId(noticiaDao.buscaPorID(comentario.getNoticiaId().getId()));
            //this.comentarios = comentariosDao.listaPorNoticia(comentario.getNoticiaId());
            tag = tagDao.buscaPorID(Integer.parseInt(id));
            this.noticiasTag = noticiaDao.listarNoticiaPorTag(tag);
            return this.noticiasTag;
        }
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

    public void paginaTags() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entrou no redirecionamento de pagina noticia por tag");
        String id = context.getExternalContext().getRequestParameterMap().get("tag");
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/tagsrelacionadas.xhtml?tag=" + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SiteNoticia> getNoticiasTag() {
        return noticiasTag;
    }

    public void setNoticiasTag(List<SiteNoticia> noticiasTag) {
        this.noticiasTag = noticiasTag;
    }

    public List<SiteNoticia> getNoticiasFiltradas() {
        return noticiasFiltradas;
    }

    public void setNoticiasFiltradas(List<SiteNoticia> noticiasFiltradas) {
        this.noticiasFiltradas = noticiasFiltradas;
    }

    public SiteTags getTag() {
        return tag;
    }

    public void setTag(SiteTags tag) {
        this.tag = tag;
    }

}
