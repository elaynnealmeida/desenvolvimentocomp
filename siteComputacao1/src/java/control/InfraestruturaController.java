package control;

import dao.EquipamentoDAO;
import dao.InfraestruturaDAO;
import dao.SalaDAO;
import dao.TbProfessoresDAO;
import dao.TipoInfraestruturaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import model.SiteEquipamento;
import model.SiteInfraestrutura;
import model.SiteTipoInfraestrutura;
import model.TbProfessores;
import model.TbSala;
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
@ViewScoped
public class InfraestruturaController implements Serializable {

    private SiteInfraestrutura infra;
    private InfraestruturaDAO infraDao;
    private List<SiteInfraestrutura> infras;
    private List<SiteInfraestrutura> infrasFiltradas;
    private List<SiteEquipamento> selectedEquipamentos;
    private UploadedFile file;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.infra = new SiteInfraestrutura();
        this.infraDao = new InfraestruturaDAO();
        selectedEquipamentos = new ArrayList<SiteEquipamento>();
        this.file = null;
        this.isEdit = false;
        infras = listar();
    }

    public void limpar() {
        this.infra = new SiteInfraestrutura();
        selectedEquipamentos = new ArrayList<SiteEquipamento>();
        this.file = null;
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        System.out.println("entrou no salvar infra ");
        try {
            System.out.println("Foto: "+file.getFileName());
            gravaImagem();
            if (infra.getFoto() != null) {
            infra.setSiteInfraEquipamentosList(selectedEquipamentos);
            infraDao.salvar(infra);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } }catch (Exception e) {
            limpar();
            System.out.println("Erro ao tentar inserir: "+e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
            if (!file.getFileName().isEmpty()) {
                System.out.println("entrou no imagem vazio ");
                infra.setFoto(null);
                gravaImagem();
            }
            infra.setSiteInfraEquipamentosList(selectedEquipamentos);
            infraDao.atualizar(infra);
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
        try {
            infraDao.deletar(infra);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void gravaImagem() {
        if (file != null) {
            System.out.println("file!=null");
            try {
                byte[] bytes = IOUtils.toByteArray(file.getInputstream());
                infra.setFoto(bytes);

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
                SiteInfraestrutura i = infraDao.buscaPorID(Integer.parseInt(id));
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

    public List<SiteInfraestrutura> listar() {
        this.infras = infraDao.listarTodos();
        return this.infras;
    }

    public void onRowSelect(SelectEvent event) {
        this.infra = ((SiteInfraestrutura) event.getObject());
        selectedEquipamentos = new ArrayList<SiteEquipamento>();
        this.selectedEquipamentos.addAll(infra.getSiteInfraEquipamentosList());
        this.isEdit = true;
    }

    public double calculaArea(SiteInfraestrutura i) {
        double area = 0.0;
        area = i.getLargura() * i.getComprimento();
        return area;
    }

    public List<SelectItem> getSala() {
       // System.out.println("entrou no listar sala: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SalaDAO tpdDao = new SalaDAO();
        List<TbSala> result = new ArrayList<TbSala>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getBlocoId().getDescricao() + " - " + result.get(i).getNomeSala()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    
    public List<SelectItem> getTpInfra() {
        //System.out.println("entrou no listar tpinfra: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TipoInfraestruturaDAO tpdDao = new TipoInfraestruturaDAO();
        List<SiteTipoInfraestrutura> result = new ArrayList<SiteTipoInfraestrutura>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    
    public List<SelectItem> getEquipamentos() {
       // System.out.println("entrou no listar equipamentos: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        EquipamentoDAO tpdDao = new EquipamentoDAO();
        List<SiteEquipamento> result = new ArrayList<SiteEquipamento>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

     public List<SelectItem> getProfessor() {
       // System.out.println("entrou no listar professor: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TbProfessoresDAO profDao = new TbProfessoresDAO();
        List<TbProfessores> result = new ArrayList<TbProfessores>();
        result = profDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    public SiteInfraestrutura getInfra() {
        return infra;
    }

    public void setInfra(SiteInfraestrutura infra) {
        this.infra = infra;
    }

    public List<SiteInfraestrutura> getInfras() {
        return infras;
    }

    public void setInfras(List<SiteInfraestrutura> infras) {
        this.infras = infras;
    }

    public List<SiteInfraestrutura> getInfrasFiltradas() {
        return infrasFiltradas;
    }

    public void setInfrasFiltradas(List<SiteInfraestrutura> infrasFiltradas) {
        this.infrasFiltradas = infrasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SiteEquipamento> getSelectedEquipamentos() {
        return selectedEquipamentos;
    }

    public void setSelectedEquipamentos(List<SiteEquipamento> selectedEquipamentos) {
        this.selectedEquipamentos = selectedEquipamentos;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
