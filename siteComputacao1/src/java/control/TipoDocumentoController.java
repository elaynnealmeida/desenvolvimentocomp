
package control;

import dao.TipoDocumentoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteTipoArquivo;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class TipoDocumentoController  implements Serializable {

    private SiteTipoArquivo tipoDocumento;
    private TipoDocumentoDAO tipoDocumentoDao;
    private List<SiteTipoArquivo> tipoDocumentos;
    private List<SiteTipoArquivo> tipoDocumentosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.tipoDocumento = new SiteTipoArquivo();
        this.tipoDocumentoDao = new TipoDocumentoDAO();
        this.isEdit = false;
        tipoDocumentos = listar();
    }
    
   public void limpar() {
        this.tipoDocumento = new SiteTipoArquivo();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            tipoDocumentoDao.salvar(tipoDocumento);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try{
        tipoDocumentoDao.atualizar(tipoDocumento);
        FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar atualizar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try{
        tipoDocumentoDao.deletar(tipoDocumento);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
   
    public List<SiteTipoArquivo> listar() {
        this.tipoDocumentos = tipoDocumentoDao.listarTodos();
        return this.tipoDocumentos;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.tipoDocumento = ((SiteTipoArquivo) event.getObject());
        this.isEdit = true;
    }

    public SiteTipoArquivo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(SiteTipoArquivo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<SiteTipoArquivo> getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(List<SiteTipoArquivo> tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public List<SiteTipoArquivo> getTipoDocumentosFiltrados() {
        return tipoDocumentosFiltrados;
    }

    public void setTipoDocumentosFiltrados(List<SiteTipoArquivo> tipoDocumentosFiltrados) {
        this.tipoDocumentosFiltrados = tipoDocumentosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

   
    
}
