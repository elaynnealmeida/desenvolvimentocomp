package control;

import dao.SiteComentariosDAO;
import dao.SiteNoticiaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import model.SiteComentarios;
import model.SiteNoticia;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
//@SessionScoped
public class SiteComentariosController implements Serializable {

    private SiteComentarios comentario;
    private SiteComentariosDAO comentariosDao;
    private List<SiteComentarios> comentarios;
    private SiteNoticiaDAO noticiaDao;

    @PostConstruct
    public void init() {
        this.comentario = new SiteComentarios();
        this.comentariosDao = new SiteComentariosDAO();
        System.out.println("noticia: "+comentario.getNoticiaId());
        noticiaDao = new SiteNoticiaDAO();
        comentarios = listar();
    }

    public void limpar() {
        this.comentario.setEmail(null);
        this.comentario.setId(null);
        this.comentario.setTexto(null);
        listar();
    }

    public void salvar() {

        try {
            if (comentario.getNoticiaId() != null) {
                comentariosDao.salvar(comentario);
                limpar();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        } catch (Exception e) {
            System.out.println("Erro de inserção: " + e);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void deletar(int id) {
        try {
            comentario = comentariosDao.buscaPorID(id);
            comentariosDao.deletar(comentario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteComentarios> listar() {
        System.out.println("entrou no listar");
        FacesContext context = FacesContext.getCurrentInstance();
        String id = context.getExternalContext().getRequestParameterMap().get("noticia");
        System.out.println("id: " + id);
        if (comentario.getNoticiaId() == null) {
            System.out.println("entrou no listar pelo parametro");
            if (id != null) {
                comentario.setNoticiaId(noticiaDao.buscaPorID(Integer.parseInt(id)));
            }
            this.comentarios = comentariosDao.listaPorNoticia(comentario.getNoticiaId());
            return this.comentarios;
        } /*else if (Integer.parseInt(id) != comentario.getNoticiaId().getId()) {
            System.out.println("entrou no ids diferentes");
            comentario.setNoticiaId(noticiaDao.buscaPorID(Integer.parseInt(id)));
            //comentario.setNoticiaId(noticiaDao.buscaPorID(comentario.getNoticiaId().getId()));
            this.comentarios = comentariosDao.listaPorNoticia(comentario.getNoticiaId());
            return this.comentarios;
        } */else {
            System.out.println("entrou no ids iguais");
            //comentario.setNoticiaId(noticiaDao.buscaPorID(Integer.parseInt(id)));
            comentario.setNoticiaId(noticiaDao.buscaPorID(comentario.getNoticiaId().getId()));
            this.comentarios = comentariosDao.listaPorNoticia(comentario.getNoticiaId());
            return this.comentarios;
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
            if (i.getImgCapa() != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(i.getImgCapa()));
            } else {
                return new DefaultStreamedContent();
            }

        }
    }

    public SiteComentarios getComentario() {
        return comentario;
    }

    public void setComentario(SiteComentarios comentario) {
        this.comentario = comentario;
    }

    public List<SiteComentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<SiteComentarios> comentarios) {
        this.comentarios = comentarios;
    }

}
