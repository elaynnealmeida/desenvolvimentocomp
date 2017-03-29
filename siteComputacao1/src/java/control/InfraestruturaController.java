package control;

import dao.EquipamentoDAO;
import dao.InfraestruturaDAO;
import dao.SalaDAO;
import dao.TipoInfraestruturaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteEquipamento;
import model.SiteInfraestrutura;
import model.SiteTipoInfraestrutura;
import model.TbSala;
import org.primefaces.event.SelectEvent;

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
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.infra = new SiteInfraestrutura();
        this.infraDao = new InfraestruturaDAO();
        selectedEquipamentos = new ArrayList<SiteEquipamento>();
        this.isEdit = false;
        infras = listar();
    }

    public void limpar() {
        this.infra = new SiteInfraestrutura();
        selectedEquipamentos = new ArrayList<SiteEquipamento>();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            infra.setSiteInfraEquipamentosList(selectedEquipamentos);
            infraDao.salvar(infra);
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
        try {
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
        System.out.println("entrou no listar sala: ");
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
        System.out.println("entrou no listar tpinfra: ");
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
        System.out.println("entrou no listar equipamentos: ");
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

}
