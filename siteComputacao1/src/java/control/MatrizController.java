package control;

import dao.SiteMatrizDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.SiteMatriz;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class MatrizController implements Serializable {

    // private TbDisciplina disciplina;
    private SiteMatrizDAO matrizDAO;
    private List<SiteMatriz> matrizes;
    // private List<TbDisciplina> disciplinasFiltradas;
    // private boolean isEdit;

    @PostConstruct
    public void init() {
        // this.disciplina = new TbDisciplina();
        this.matrizDAO = new SiteMatrizDAO();
        // this.isEdit = false;
        matrizes = listar();
    }

    public List<SiteMatriz> listar() {
        this.matrizes = matrizDAO.listarMatriz();
        return this.matrizes;
    }
    
     public void disciplina() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entrou no redirecionamento de pagina");
        String id = context.getExternalContext().getRequestParameterMap().get("disciplina");
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/detalhesdisciplina.xhtml?disciplina=" + id);
    }

    public List<SiteMatriz> getMatrizes() {
        return matrizes;
    }

    public void setMatrizes(List<SiteMatriz> matrizes) {
        this.matrizes = matrizes;
    }
    
}
