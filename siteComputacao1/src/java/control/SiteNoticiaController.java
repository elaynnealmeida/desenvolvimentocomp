package control;

import dao.SiteNoticiaDAO;
import dao.SiteTagDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.System.currentTimeMillis;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import model.SiteNoticia;
import model.SiteTags;
import model.TbUsersystem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class SiteNoticiaController implements Serializable {

    private SiteNoticia noticia;
    private SiteNoticiaDAO noticiaDao;
    private List<SiteNoticia> noticias;
    private List<SiteNoticia> noticiasFiltradas;
    private boolean isEdit;
    private UploadedFile file;
    private List<SiteTags> selectedTags;
    private List<SelectItem> tags;
    private SiteTagDAO tagDao;    

    @PostConstruct
    public void init() {
        this.noticia = new SiteNoticia();
        this.noticiaDao = new SiteNoticiaDAO();
        tagDao = new SiteTagDAO();
        this.isEdit = false;
        this.file = null;
        this.tags = listarTags();
        noticias = listar();
    }

    public void limpar() {
        this.noticia = new SiteNoticia();
        this.isEdit = false;
        this.selectedTags = null;
        listar();
    }

    public void salvar() {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            noticia.setUsuarioId((TbUsersystem) request.getSession().getAttribute("user"));
            noticia.setSiteNoticiaTagsList(selectedTags);
            noticia.setData(getDateTime());//Data de Alteração
            noticia.setHora(getDateTime());//Data de Inserção
            noticia.setHora2(BigInteger.valueOf(currentTimeMillis()));
            gravaImagem();
            if (noticia.getImgCapa() != null) {
                noticiaDao.salvar(noticia);
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

    public void atualizar() {
        try {
            noticia.setData(getDateTime());//Data de Alteração
            noticiaDao.atualizar(noticia);
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
            noticiaDao.deletar(noticia);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }  

    public void gravaImagem() {
        System.out.println("chamou o metodo");
        try {
            byte[] bytes = IOUtils.toByteArray(file.getInputstream());
            noticia.setImgCapa(bytes);

        } catch (Exception ex) {
            System.out.println("arquivo: " + ex);
            ex.printStackTrace();
        }
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List<SiteNoticia> listar() {
        this.noticias = noticiaDao.listarPorData();
        return this.noticias;
    }

    public List<SelectItem> listarTags() {
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<SiteTags> result = new ArrayList<SiteTags>();
        SiteTagDAO perfilDao = new SiteTagDAO();
        result = tagDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            System.out.println("tag: " + result.get(i).getDescricao());
        }
        return toReturn;
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

    public void onRowSelect(SelectEvent event) {
        this.noticia = ((SiteNoticia) event.getObject());
        this.isEdit = true;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public SiteNoticia getNoticia() {
        return noticia;
    }

    public void setNoticia(SiteNoticia noticia) {
        this.noticia = noticia;
    }

    public List<SiteNoticia> getNoticias() {
        return noticias;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<SiteTags> getSelectedTags() {
        return selectedTags;
    }

    public void setSelectedTags(List<SiteTags> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public List<SelectItem> getTags() {
        return tags;
    }

    public void setTags(List<SelectItem> tags) {
        this.tags = tags;
    }

}
