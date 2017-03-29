
package control;

import dao.SiteDocumentoDAO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import model.SiteDocumento;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
//@SessionScoped
public class DocumentosHelper implements Serializable {

    private SiteDocumentoDAO documentoDao;
    private List<SiteDocumento> documentos;
    private List<SiteDocumento> documentosDocentes;
    private List<SiteDocumento> documentosNDE;
    private List<SiteDocumento> documentosCondir;
    private List<SiteDocumento> documentosConsepe;
    private List<SiteDocumento> documentosConsuni;    
    
    @PostConstruct
    public void init() {
        this.documentoDao = new SiteDocumentoDAO();
        documentos = listarCoordenacao();
        documentosDocentes = listarDocentes();
        documentosNDE = listarNDE();
        documentosCondir = listarCondir();
        documentosConsepe = listarConsepe();
        documentosConsuni = listarconsuni();
        
        
    }

  public List<SiteDocumento> listarconsuni() {
        this.documentosConsuni = documentoDao.listarConsuni();
        return this.documentosConsuni;
    }
  
  public List<SiteDocumento> listarConsepe() {
        this.documentosConsepe = documentoDao.listarConsepe();
        return this.documentosConsepe;
    }
  
  public List<SiteDocumento> listarDocentes() {
        this.documentosDocentes = documentoDao.listarDocentes();
        return this.documentosDocentes;
    }
  
  public List<SiteDocumento> listarCondir() {
        this.documentosCondir = documentoDao.listarCondir();
        return this.documentosCondir;
    }
  
  public List<SiteDocumento> listarCoordenacao() {
        this.documentos = documentoDao.listarCoordenacao();
        return this.documentos;
    }
  
  public List<SiteDocumento> listarNDE() {
        this.documentosNDE = documentoDao.listarNDE();
        return this.documentosNDE;
    }
  
  public StreamedContent download(SiteDocumento doc) { 
        InputStream stream = new ByteArrayInputStream(doc.getArquivo());
        StreamedContent file1 = null;
        file1 = new DefaultStreamedContent(stream, "application/pdf", doc.getTitulo());
        
        return (StreamedContent) file1;
    }

    public List<SiteDocumento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<SiteDocumento> documentos) {
        this.documentos = documentos;
    }

    public List<SiteDocumento> getDocumentosDocentes() {
        return documentosDocentes;
    }

    public void setDocumentosDocentes(List<SiteDocumento> documentosDocentes) {
        this.documentosDocentes = documentosDocentes;
    }

    public List<SiteDocumento> getDocumentosNDE() {
        return documentosNDE;
    }

    public void setDocumentosNDE(List<SiteDocumento> documentosNDE) {
        this.documentosNDE = documentosNDE;
    }

    public List<SiteDocumento> getDocumentosCondir() {
        return documentosCondir;
    }

    public void setDocumentosCondir(List<SiteDocumento> documentosCondir) {
        this.documentosCondir = documentosCondir;
    }

    public List<SiteDocumento> getDocumentosConsepe() {
        return documentosConsepe;
    }

    public void setDocumentosConsepe(List<SiteDocumento> documentosConsepe) {
        this.documentosConsepe = documentosConsepe;
    }

    public List<SiteDocumento> getDocumentosConsuni() {
        return documentosConsuni;
    }

    public void setDocumentosConsuni(List<SiteDocumento> documentosConsuni) {
        this.documentosConsuni = documentosConsuni;
    }
    
    
}
