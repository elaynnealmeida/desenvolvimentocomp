package control;

import dao.FormacaoDAO;
import dao.ProfessorFormacaoDAO;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.SiteFormacao;
import model.SiteProfessorFormacao;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class ProfessorFormacaoController implements Serializable {

    private SiteProfessorFormacao profFormacao;
    private ProfessorFormacaoDAO profFormacaoDao;
    private List<SiteProfessorFormacao> formacoes;
    private List<SiteProfessorFormacao> formacoesFiltrados;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.profFormacao = new SiteProfessorFormacao();
        this.profFormacaoDao = new ProfessorFormacaoDAO();
        this.isEdit = false;
        formacoes = listar();
    }

    public void limpar() {
        this.profFormacao = new SiteProfessorFormacao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = (HttpSession) request.getSession();
            TbUsersystem usuarioSession = (TbUsersystem) session.getAttribute("user");            
            TbProfessoresDAO prof = new TbProfessoresDAO();
            
            profFormacao.setProfessorId(prof.buscaProf(usuarioSession));
            profFormacaoDao.salvar(profFormacao);
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
            profFormacaoDao.atualizar(profFormacao);
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
            profFormacaoDao.deletar(profFormacao);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteFormacao> selectFormacao(String query) {
        List<SiteFormacao> results = new ArrayList<SiteFormacao>();
        FormacaoDAO fDao = new FormacaoDAO();
        results = fDao.listarTodos();       
        return results;
    }
    
    public List<SelectItem> listarFormacao() {
        System.out.println("entrou no listar formacao: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        FormacaoDAO fDao = new FormacaoDAO();
        List<SiteFormacao> result = new ArrayList<SiteFormacao>();
        result = fDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public List<SiteProfessorFormacao> listar() {
        this.formacoes = profFormacaoDao.listarTodos();
        return this.formacoes;
    }

    public void onRowSelect(SelectEvent event) {
        this.profFormacao = ((SiteProfessorFormacao) event.getObject());
        this.isEdit = true;
    }

}
