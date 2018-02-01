package control;

import dao.SiteCargoDAO;
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
import model.SiteCargo;
import model.SiteCargoProfessor;
import model.TbProfessores;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
//@SessionScoped
public class TbProfessoresController implements Serializable {

    private TbProfessores professor;
    private TbProfessoresDAO professorDao;
    private List<TbProfessores> professores;
    private List<TbProfessores> professoresFiltrados;
    private SiteCargoProfessor cargoProf;
    private List<SiteCargoProfessor> cargoProfList;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.professor = new TbProfessores();
        this.professorDao = new TbProfessoresDAO();
        this.cargoProf = new SiteCargoProfessor();
        this.cargoProfList = new ArrayList<SiteCargoProfessor>();
        this.isEdit = false;
        professores = listar();
    }

    public void limpar() {
        this.professor = new TbProfessores();
        this.cargoProf = new SiteCargoProfessor();
        this.cargoProfList = new ArrayList<SiteCargoProfessor>();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            cargoProf.setProfessorId(professor);
            cargoProfList.add(cargoProf);
            professor.setSiteCargoProfessorList(cargoProfList);
            if(cargoProf.getDtFim().isEmpty()){
                professor.setAtivo(true);
            }
            else{
                professor.setAtivo(false);
            }
            professorDao.salvar(professor);
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
            cargoProf.setProfessorId(professor);
            cargoProfList.add(cargoProf);
            professor.setSiteCargoProfessorList(cargoProfList);
             if(cargoProf.getDtFim().isEmpty()){
                professor.setAtivo(true);
            }
            else{
                professor.setAtivo(false);
            }
            professorDao.atualizar(professor);
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
            professorDao.deletar(professor);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<TbProfessores> selectFuncao(String query) {
        List<TbProfessores> results = new ArrayList<TbProfessores>();
        List<TbProfessores> result = new ArrayList<TbProfessores>();
        TbProfessoresDAO funcaoDao = new TbProfessoresDAO();
        results = funcaoDao.listarTodos();
        for (int c = 0; c < results.size(); c++) {
            result.add(results.get(c));
        }
        return results;
    }

    public List<SelectItem> getCargo() {
        System.out.println("entrou no listar cargo: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SiteCargoDAO cargoDao = new SiteCargoDAO();
        List<SiteCargo> result = new ArrayList<SiteCargo>();
        result = cargoDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public List<TbProfessores> listar() {
        this.professores = professorDao.listarProfessores();
        return this.professores;
    }

    public void onRowSelect(SelectEvent event) {
        this.professor = ((TbProfessores) event.getObject());
        if (!professor.getSiteCargoProfessorList().isEmpty()) {
            this.cargoProf = professor.getSiteCargoProfessorList().get(0);
        }
        this.isEdit = true;
    }

    public TbProfessores getProfessor() {
        return professor;
    }

    public void setProfessor(TbProfessores professor) {
        this.professor = professor;
    }

    public TbProfessoresDAO getProfessorDao() {
        return professorDao;
    }

    public void setProfessorDao(TbProfessoresDAO professorDao) {
        this.professorDao = professorDao;
    }

    public List<TbProfessores> getProfessores() {
        return professores;
    }

    public void setProfessores(List<TbProfessores> professores) {
        this.professores = professores;
    }

    public List<TbProfessores> getProfessoresFiltrados() {
        return professoresFiltrados;
    }

    public void setProfessoresFiltrados(List<TbProfessores> professoresFiltrados) {
        this.professoresFiltrados = professoresFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public SiteCargoProfessor getCargoProf() {
        return cargoProf;
    }

    public void setCargoProf(SiteCargoProfessor cargoProf) {
        this.cargoProf = cargoProf;
    }

}
