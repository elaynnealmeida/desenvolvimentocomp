
package control;

import dao.TbProfessoresDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private boolean isEdit;
    
    
    @PostConstruct
    public void init() {
        this.professor = new TbProfessores();
        this.professorDao = new TbProfessoresDAO();
        this.isEdit = false;
        professores = listar();
    }
    
    public void limpar() {
        this.professor = new TbProfessores();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
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
        try{
        professorDao.atualizar(professor);
        FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try{
        professorDao.deletar(professor);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<TbProfessores> selectFuncao(String query) {
        List<TbProfessores> results = new ArrayList<TbProfessores>();
        List<TbProfessores> result = new ArrayList<TbProfessores>();
        TbProfessoresDAO funcaoDao = new TbProfessoresDAO();
        results = funcaoDao.listarTodos();       
        for(int c = 0;c<results.size();c++){
            result.add(results.get(c));
        }
        return results;
    }

    public List<TbProfessores> listar() {
        this.professores = professorDao.listarTodos();
        return this.professores;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.professor = ((TbProfessores) event.getObject());
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
    
     
}
