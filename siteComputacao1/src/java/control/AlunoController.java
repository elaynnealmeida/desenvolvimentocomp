
package control;

import dao.SiteAlunoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteAluno;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class AlunoController implements Serializable {

    private SiteAluno aluno;
    private SiteAlunoDAO alunoDao;
    private List<SiteAluno> alunos;
    private List<SiteAluno> alunosFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.aluno = new SiteAluno();
        this.alunoDao = new SiteAlunoDAO();
        this.isEdit = false;
        alunos = listar();
    }
    
   public void limpar() {
        this.aluno = new SiteAluno();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            alunoDao.salvar(aluno);
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
        alunoDao.atualizar(aluno);
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
        alunoDao.deletar(aluno);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   

    public List<SiteAluno> listar() {
        this.alunos = alunoDao.listarTodos();
        return this.alunos;
    }
    
    public void onRowSelect(SelectEvent event) {
        this.aluno = ((SiteAluno) event.getObject());
        this.isEdit = true;
    }

    public SiteAluno getAluno() {
        return aluno;
    }

    public void setAluno(SiteAluno aluno) {
        this.aluno = aluno;
    }

    public List<SiteAluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<SiteAluno> alunos) {
        this.alunos = alunos;
    }

    public List<SiteAluno> getAlunosFiltrados() {
        return alunosFiltrados;
    }

    public void setAlunosFiltrados(List<SiteAluno> alunosFiltrados) {
        this.alunosFiltrados = alunosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
     

    
}
