package control;

import dao.ConselhoDAO;
import dao.PublicacaoDAO;
import dao.SiteDocumentoDAO;
import dao.TipoDocumentoDAO;
import dao.TipoPublicacaoDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import model.SiteConselho;
import model.SiteDocumento;
import model.SitePublicacao;
import model.SiteTipoArquivo;
import model.SiteTipoPublicacao;
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
public class DocumentoController implements Serializable {

    private SiteDocumento documento;
    private SiteDocumentoDAO documentoDao;
    private List<SiteDocumento> documentos;
    private List<SiteDocumento> documentosFiltrados;
    private boolean isEdit;
    private UploadedFile file;

    @PostConstruct
    public void init() {
        this.documento = new SiteDocumento();
        this.documentoDao = new SiteDocumentoDAO();
        this.isEdit = false;
        this.file = null;
        documentos = listar();
    }

    public void limpar() {
        this.documento = new SiteDocumento();
        this.isEdit = false;
        this.file = null;
        listar();
    }

    public void salvar() throws IOException {
        System.out.println("entrou no salvar documento");
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            Date d1 = df.parse("07/09/1822");
            System.out.println(d1);
            Date d2 = df.parse(documento.getDataArquivo());
            System.out.println(d2);
            long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
            //System.out.println(dt / 86400000L); // passaram-se 67111 dias
            long x = dt / 86400000L;
            documento.setDataArquivo2((int) x);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            documento.setUsuarioInclusao((TbUsersystem) request.getSession().getAttribute("user"));
            documento.setDataInclusao(getDateTime());//Data de Alteração
            documento.setHora(BigInteger.valueOf(currentTimeMillis()));//Data de Inserção            
            gravaArquivo();
            documento.setTamanhoDoArquivo(BigInteger.valueOf(this.file.getSize()));
            System.out.println("arquivo: " + this.file.getFileName());
            if (documento.getArquivo() != null) {
                documentoDao.salvar(documento);
                limpar();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            // System.out.println("Erro de inserção: " + e);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            Date d1 = df.parse("07/09/1822");
            System.out.println(d1);
            Date d2 = df.parse(documento.getDataArquivo());
            System.out.println(d2);
            long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
            //System.out.println(dt / 86400000L); // passaram-se 67111 dias
            long x = dt / 86400000L;
            documento.setDataArquivo2((int) x);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            documento.setUsuarioInclusao((TbUsersystem) request.getSession().getAttribute("user"));
            documento.setDataInclusao(getDateTime());//Data de Alteração
            if (!file.getFileName().isEmpty()) {
                documento.setArquivo(null);
                gravaArquivo();
            }
            documentoDao.atualizar(documento);
            limpar();
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            System.out.println("Erro de atualizaçao: " + e);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar atualizar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try {
            documentoDao.deletar(documento);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SelectItem> getTpDocumento() {
        System.out.println("entrou no listar tp documento: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TipoDocumentoDAO tpdDao = new TipoDocumentoDAO();
        List<SiteTipoArquivo> result = new ArrayList<SiteTipoArquivo>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public List<SelectItem> getPublicacao() {
        System.out.println("entrou no listar publicaçao: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        PublicacaoDAO publicacaoDao = new PublicacaoDAO();
        List<SitePublicacao> result = new ArrayList<SitePublicacao>();
        result = publicacaoDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getConselhoId().getNome() + " - " + String.valueOf(result.get(i).getNumero()) + " - " + result.get(i).getData()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public void gravaArquivo() throws IOException {
        System.out.println("chamou o metodo de gravar aquivo");
        if (file != null) {
            System.out.println("arquivo: " + this.file.getFileName());
            try {
                byte[] bytes = IOUtils.toByteArray(file.getInputstream());

                documento.setArquivo(bytes);

            } catch (Exception ex) {
                // System.out.println("arquivo: " + ex);
                ex.printStackTrace();
            }
        } else {
            System.out.println("arquivo esta vazio ");
        }
    }

    public StreamedContent download(SiteDocumento doc) {
        InputStream stream = new ByteArrayInputStream(doc.getArquivo());
        StreamedContent file1 = null;
        file1 = new DefaultStreamedContent(stream, "application/pdf", doc.getTitulo());

        return (StreamedContent) file1;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List<SiteDocumento> listar() {
        this.documentos = documentoDao.listarPorData();
        return this.documentos;
    }

    public void onRowSelect(SelectEvent event) {
        this.documento = ((SiteDocumento) event.getObject());
        this.isEdit = true;
    }

    public SiteDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(SiteDocumento documento) {
        this.documento = documento;
    }

    public List<SiteDocumento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<SiteDocumento> documentos) {
        this.documentos = documentos;
    }

    public List<SiteDocumento> getDocumentosFiltrados() {
        return documentosFiltrados;
    }

    public void setDocumentosFiltrados(List<SiteDocumento> documentosFiltrados) {
        this.documentosFiltrados = documentosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
