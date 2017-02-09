package control;

import dao.DisciplinaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbDisciplina;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class DisciplinaController implements Serializable {

    private TbDisciplina disciplina;
    private DisciplinaDAO disciplinaDAO;
    private List<TbDisciplina> disciplinas;
    // private List<TbDisciplina> disciplinasFiltradas;
    // private boolean isEdit;

    @PostConstruct
    public void init() {
        this.disciplina = new TbDisciplina();        
        this.disciplinaDAO = new DisciplinaDAO();
        this.disciplina = viewDisciplina();
        // this.isEdit = false;
        //disciplinas = listar();
    }

    public TbDisciplina viewDisciplina() {
        //this.disciplinas = disciplinaDAO.listarTodos();
        FacesContext context = FacesContext.getCurrentInstance();
        String id = context.getExternalContext().getRequestParameterMap().get("disciplina");
        System.out.println("id: " + id);
        this.disciplina = disciplinaDAO.buscaPorID2(Long.parseLong(id));       
        return this.disciplina;
    }

    public List<TbDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<TbDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public TbDisciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(TbDisciplina disciplina) {
        this.disciplina = disciplina;
    }
   
}
