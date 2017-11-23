
package control;

import dao.SiteAlunoDAO;
import dao.SiteIniciacaoCientificaDAO;
import dao.SiteModuloDAO;
import dao.TbProfessoresDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteAluno;
import model.SiteIniciacaoCientifica;
import model.SiteModulo;
import model.TbProfessores;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class IniciacaoCientificaController implements Serializable {

    private SiteIniciacaoCientifica ic;
    private SiteIniciacaoCientificaDAO icDao;
    private List<SiteIniciacaoCientifica> ics;
    private List<SiteIniciacaoCientifica> icsFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.ic = new SiteIniciacaoCientifica();
        this.icDao = new SiteIniciacaoCientificaDAO();
        this.isEdit = false;
        ics = listar();
    }
    
   public void limpar() {
        this.ic = new SiteIniciacaoCientifica();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            icDao.salvar(ic);
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
        icDao.atualizar(ic);
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
        icDao.deletar(ic);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteIniciacaoCientifica> listar() {
        this.ics = icDao.listarTodos();
        return this.ics;
    }
    
    public void onRowSelect(SelectEvent event) {
        this.ic = ((SiteIniciacaoCientifica) event.getObject());
        this.isEdit = true;
    }
    
    public List<SelectItem> getProfessor() {
        //System.out.println("entrou no listar professor: ");
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
    
    public List<SelectItem> getModal() {
        //System.out.println("entrou no listar modulos: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SiteModuloDAO dao = new SiteModuloDAO();
        List<SiteModulo> result = new ArrayList<SiteModulo>();
        result = dao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    
    public List<SelectItem> getAluno() {
       // System.out.println("entrou no listar alunos: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SiteAlunoDAO dao = new SiteAlunoDAO();
        List<SiteAluno> result = new ArrayList<SiteAluno>();
        result = dao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome()+" - "+result.get(i).getMatricula()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public SiteIniciacaoCientifica getIc() {
        return ic;
    }

    public void setIc(SiteIniciacaoCientifica ic) {
        this.ic = ic;
    }

    public List<SiteIniciacaoCientifica> getIcs() {
        return ics;
    }

    public void setIcs(List<SiteIniciacaoCientifica> ics) {
        this.ics = ics;
    }

    public List<SiteIniciacaoCientifica> getIcsFiltrados() {
        return icsFiltrados;
    }

    public void setIcsFiltrados(List<SiteIniciacaoCientifica> icsFiltrados) {
        this.icsFiltrados = icsFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
