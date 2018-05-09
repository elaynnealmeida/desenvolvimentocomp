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
    private List<SiteDocumento> documentosEnade;
    private List<SiteDocumento> documentos17;
    private List<SiteDocumento> documentos16;
    private List<SiteDocumento> documentos15;
    private List<SiteDocumento> documentos14;
    private List<SiteDocumento> documentos13;
    private List<SiteDocumento> documentos12;
    private List<SiteDocumento> documentos11;
    private List<SiteDocumento> documentos10;
    private List<SiteDocumento> documentos9;
    
    
    

    @PostConstruct
    public void init() {
        this.documentoDao = new SiteDocumentoDAO();
        documentos = listarCoordenacao18();
        documentos17 = listarCoordenacao17();
        documentos16 = listarCoordenacao16();
        documentos15 = listarCoordenacao15();
        documentos14 = listarCoordenacao14();
        documentos13 = listarCoordenacao13();
        documentos12 = listarCoordenacao12();
        documentos11 = listarCoordenacao11();
        documentos10 = listarCoordenacao10();
        documentosDocentes = listarDocentes();
        documentosNDE = listarNDE();
        documentosCondir = listarCondir();
        documentosConsepe = listarConsepe();
        documentosConsuni = listarconsuni();
        documentosEnade = listarenade();

    }

    public List<SiteDocumento> listarconsuni() {
        this.documentosConsuni = documentoDao.listarConsuni();
        return this.documentosConsuni;
    }

    public List<SiteDocumento> listarenade() {
        this.documentosEnade = documentoDao.listarEnade();
        return this.documentosEnade;
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

    public List<SiteDocumento> listarCoordenacao18() {
        this.documentos = documentoDao.listarCoordenacao("2018");
        return this.documentos;
    }

    public List<SiteDocumento> listarCoordenacao17() {
        this.documentos17 = documentoDao.listarCoordenacao("2017");
        return this.documentos17;
    }

    public List<SiteDocumento> listarCoordenacao16() {
        this.documentos16 = documentoDao.listarCoordenacao("2016");
        return this.documentos16;
    }

    public List<SiteDocumento> listarCoordenacao15() {
        this.documentos15 = documentoDao.listarCoordenacao("2015");
        return this.documentos15;
    }

    public List<SiteDocumento> listarCoordenacao14() {
        this.documentos14 = documentoDao.listarCoordenacao("2014");
        return this.documentos14;
    }

    public List<SiteDocumento> listarCoordenacao13() {
        this.documentos13 = documentoDao.listarCoordenacao("2013");
        return this.documentos13;
    }

    public List<SiteDocumento> listarCoordenacao12() {
        this.documentos12 = documentoDao.listarCoordenacao("2012");
        return this.documentos12;
    }

    public List<SiteDocumento> listarCoordenacao11() {
        this.documentos11 = documentoDao.listarCoordenacao("2011");
        return this.documentos11;
    }

    public List<SiteDocumento> listarCoordenacao10() {
        this.documentos10 = documentoDao.listarCoordenacao("2010");
        return this.documentos10;
    }

    public List<SiteDocumento> listarNDE() {
        this.documentosNDE = documentoDao.listarNDE();
        return this.documentosNDE;
    }

    public StreamedContent download(SiteDocumento doc) {
        InputStream stream = new ByteArrayInputStream(doc.getArquivo());
        StreamedContent file1 = null;
        file1 = new DefaultStreamedContent(stream, doc.getExtencao(), doc.getTitulo());

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

    public List<SiteDocumento> getDocumentosEnade() {
        return documentosEnade;
    }

    public void setDocumentosEnade(List<SiteDocumento> documentosEnade) {
        this.documentosEnade = documentosEnade;
    }

    public List<SiteDocumento> getDocumentos17() {
        return documentos17;
    }

    public void setDocumentos17(List<SiteDocumento> documentos17) {
        this.documentos17 = documentos17;
    }

    public List<SiteDocumento> getDocumentos16() {
        return documentos16;
    }

    public void setDocumentos16(List<SiteDocumento> documentos16) {
        this.documentos16 = documentos16;
    }

    public List<SiteDocumento> getDocumentos15() {
        return documentos15;
    }

    public void setDocumentos15(List<SiteDocumento> documentos15) {
        this.documentos15 = documentos15;
    }

    public List<SiteDocumento> getDocumentos14() {
        return documentos14;
    }

    public void setDocumentos14(List<SiteDocumento> documentos14) {
        this.documentos14 = documentos14;
    }

    public List<SiteDocumento> getDocumentos13() {
        return documentos13;
    }

    public void setDocumentos13(List<SiteDocumento> documentos13) {
        this.documentos13 = documentos13;
    }

    public List<SiteDocumento> getDocumentos12() {
        return documentos12;
    }

    public void setDocumentos12(List<SiteDocumento> documentos12) {
        this.documentos12 = documentos12;
    }

    public List<SiteDocumento> getDocumentos11() {
        return documentos11;
    }

    public void setDocumentos11(List<SiteDocumento> documentos11) {
        this.documentos11 = documentos11;
    }

    public List<SiteDocumento> getDocumentos10() {
        return documentos10;
    }

    public void setDocumentos10(List<SiteDocumento> documentos10) {
        this.documentos10 = documentos10;
    }

    public List<SiteDocumento> getDocumentos9() {
        return documentos9;
    }

    public void setDocumentos9(List<SiteDocumento> documentos9) {
        this.documentos9 = documentos9;
    }

}
