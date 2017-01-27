
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
    
    @PostConstruct
    public void init() {
        this.documentoDao = new SiteDocumentoDAO();
        documentos = listar();
    }

  public List<SiteDocumento> listar() {
        this.documentos = documentoDao.listarPorData();
        return this.documentos;
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
    
    
}
