package control;

import static com.sun.xml.bind.util.CalendarConv.formatter;
import dao.FormacaoDAO;
import dao.ProfessorFormacaoDAO;
import dao.TbProfessoresDAO;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import model.SiteProfDadosComplementares;
import model.SiteProfessorFormacao;
import model.TbProfessores;
import model.TbUsersystem;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

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
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            Date d1 = df.parse("07/09/1822");
            System.out.println(d1);
            Date d2 = df.parse(profFormacao.getDtFim());
            System.out.println(d2);
            long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
            //System.out.println(dt / 86400000L); // passaram-se 67111 dias
            long x = dt / 86400000L;
            profFormacao.setDtFim2((int) x);
            profFormacao.setProfessorId(buscaProf());
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
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            Date d1 = df.parse("07/09/1822");
            System.out.println(d1);
            Date d2 = df.parse(profFormacao.getDtFim());
            System.out.println(d2);
            long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
            //System.out.println(dt / 86400000L); // passaram-se 67111 dias
            long x = dt / 86400000L;
            profFormacao.setDtFim2((int) x);
            System.out.println("data em int: " + x);
            profFormacaoDao.atualizar(profFormacao);
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

    public List<SelectItem> getFormacao() {
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
    
    

    public TbProfessores buscaProf() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        TbUsersystem usuarioSession = (TbUsersystem) session.getAttribute("user");
        TbProfessoresDAO prof = new TbProfessoresDAO();
        return prof.buscaProf(usuarioSession);
    }

    public List<SiteProfessorFormacao> listar() {
        this.formacoes = profFormacaoDao.listarFormacaoPorProfessor(buscaProf());
        return this.formacoes;
    }

    public void onRowSelect(SelectEvent event) {
        this.profFormacao = ((SiteProfessorFormacao) event.getObject());
        this.isEdit = true;
    }

    public SiteProfessorFormacao getProfFormacao() {
        return profFormacao;
    }

    public void setProfFormacao(SiteProfessorFormacao profFormacao) {
        this.profFormacao = profFormacao;
    }

    public List<SiteProfessorFormacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<SiteProfessorFormacao> formacoes) {
        this.formacoes = formacoes;
    }

    public List<SiteProfessorFormacao> getFormacoesFiltrados() {
        return formacoesFiltrados;
    }

    public void setFormacoesFiltrados(List<SiteProfessorFormacao> formacoesFiltrados) {
        this.formacoesFiltrados = formacoesFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

}
