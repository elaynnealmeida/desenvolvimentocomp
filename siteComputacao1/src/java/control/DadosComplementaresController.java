package control;

import dao.DadosComplementaresDAO;
import dao.TbProfessoresDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.SiteProfDadosComplementares;
import model.TbProfessores;
import model.TbUsersystem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
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
public class DadosComplementaresController implements Serializable {

    private SiteProfDadosComplementares dadoComplementar;
    private boolean isEdit;
    private UploadedFile file;
    private DadosComplementaresDAO dadosComplementaresDAO;
    private List<SiteProfDadosComplementares> dadosComplementares;

    @PostConstruct
    public void init() {
        this.dadoComplementar = new SiteProfDadosComplementares();
        this.dadosComplementaresDAO = new DadosComplementaresDAO();
        this.file = null;
        dadosComplementares = listar();
        this.isEdit = verificaInfos();
    }

    public void limpar() {
        this.dadoComplementar = new SiteProfDadosComplementares();
        //this.isEdit = false;
        this.file = null;
        listar();
    }

    public void handleFileUpload(FileUploadEvent event) {  
        System.out.println("entrou no handleFileUpload");
        this.file=event.getFile();
        System.out.println("file: "+file.getFileName());
    }
    
    public void salvar() {
        try {
            dadoComplementar.setIdProfessor(buscaProf());
            System.out.println("dentro do salvar professor: "+dadoComplementar.getIdProfessor().getId());
            if (file==null) {
               System.out.println("file == null ");
            }
            System.out.println("file: "+file.getFileName());
            
            if (!file.getFileName().isEmpty()) {
                gravaImagem();
            }
            System.out.println("dados complementar: ");
            dadosComplementaresDAO.salvar(this.dadoComplementar);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
             System.out.println("Erro2: "+e.toString());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
            if (!file.getFileName().isEmpty()) {
                dadoComplementar.setFoto(null);
                gravaImagem();
            }
            dadosComplementaresDAO.atualizar(dadoComplementar);
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            System.out.println("erro: " + e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar atualizar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try {
            dadosComplementaresDAO.deletar(dadoComplementar);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void gravaImagem() {
         System.out.println("chamou o metodo gravar imagem");

        if (file != null) {
            System.out.println("file!=null");
            try {
                byte[] bytes = IOUtils.toByteArray(file.getInputstream());
                dadoComplementar.setFoto(bytes);

            } catch (Exception ex) {
                // System.out.println("arquivo: " + ex);
                ex.printStackTrace();
            }
        } else {
            System.out.println("nao setou o file, file==null");
        }

    }

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("foto");
            if (!id.isEmpty()) {
                SiteProfDadosComplementares i = dadosComplementaresDAO.buscaPorID(Integer.parseInt(id));
                //System.out.println("Id: " + id);
                if (i.getFoto() != null) {
                    return new DefaultStreamedContent(new ByteArrayInputStream(i.getFoto()));
                } else {
                    return new DefaultStreamedContent();
                }
            }
        }
        return new DefaultStreamedContent();
    }

    public boolean verificaInfos() {
        if (this.dadosComplementares.isEmpty()) {
            return true;
        } else {
            this.dadoComplementar = this.dadosComplementares.get(0);
            return false;
        }

    }

    public TbProfessores buscaProf() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        TbUsersystem usuarioSession = (TbUsersystem) session.getAttribute("user");
        TbProfessoresDAO prof = new TbProfessoresDAO();
        return prof.buscaProf(usuarioSession);
    }

    public List<SiteProfDadosComplementares> listar() {
        this.dadosComplementares = dadosComplementaresDAO.listarDadosPorProfessor(buscaProf());
        return this.dadosComplementares;
    }

    public void onRowSelect(SelectEvent event) {
        System.out.println("Entrou no selecionar!!!!!!!!");
        this.dadoComplementar = ((SiteProfDadosComplementares) event.getObject());
        //this.isEdit = true;
    }

    public SiteProfDadosComplementares getDadoComplementar() {
        return dadoComplementar;
    }

    public void setDadoComplementar(SiteProfDadosComplementares dadoComplementar) {
        this.dadoComplementar = dadoComplementar;
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

    public List<SiteProfDadosComplementares> getDadosComplementares() {
        return dadosComplementares;
    }

    public void setDadosComplementares(List<SiteProfDadosComplementares> dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

}
