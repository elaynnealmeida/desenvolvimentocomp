package control;

import dao.DadosComplementaresDAO;
import dao.HorarioServidorDAO;
import dao.ProfessorFormacaoDAO;
import dao.TbProfessoresDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import model.SiteHorarioServidor;
import model.SiteProfDadosComplementares;
import model.SiteProfessorFormacao;
import model.TbProfessores;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class ServidorInfo implements Serializable {

    private SiteProfDadosComplementares servidor;
    private DadosComplementaresDAO sevidorDao;
    private List<SiteProfessorFormacao> formacaoList;
    private List<SiteHorarioServidor> horarioList;

    @PostConstruct
    public void init() {
        this.servidor = new SiteProfDadosComplementares();       
        this.sevidorDao = new DadosComplementaresDAO();
        this.formacaoList = listarFormacao();
        this.horarioList = listarHorario();
    }

    public StreamedContent getImage() throws IOException {
        System.out.println("entrou no getImage -------------");
        FacesContext context = FacesContext.getCurrentInstance();
        /* if (servidor.getId() != null) {
            System.out.println("entrou no servidor !=null id= " + servidor.getId());
            SiteProfDadosComplementares i = sevidorDao.buscaPorID(servidor.getId());
            if (i.getFoto() != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(i.getFoto()));
            } else {
                return new DefaultStreamedContent();
            }
        } else */
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("servidor");
            SiteProfDadosComplementares i = sevidorDao.buscaPorID(Integer.parseInt(id));
            System.out.println("entrou no id da foto -------------" + id);
            if (i.getFoto() != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(i.getFoto()));
            } else {
                return new DefaultStreamedContent();
            }

        }
    }

    public void serv() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.

        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("servidor");
            this.servidor = sevidorDao.buscaPorID(Integer.parseInt(id));
            System.out.println("Id: " + id);
            //getImage();

        }
    }

    public List<SiteProfessorFormacao> listarFormacao() {
        List<SiteProfessorFormacao> pf = new ArrayList<SiteProfessorFormacao>();
        ProfessorFormacaoDAO pfDao = new ProfessorFormacaoDAO();
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return null;
        } else {
            TbProfessoresDAO pDao = new TbProfessoresDAO();
            String id = context.getExternalContext().getRequestParameterMap().get("servidor");
            System.out.println("entrou no listar formacao pelo parametro id: " + id);
            servidor = sevidorDao.buscaPorID(Integer.parseInt(id));
            TbProfessores s = pDao.buscaPorID2(servidor.getIdProfessor().getId());
            pf = pfDao.listarFormacaoPorProfessor(s);
        }       
        return pf;
    }
    
    public List<SiteHorarioServidor> listarHorario() {
        List<SiteHorarioServidor> pf = new ArrayList<SiteHorarioServidor>();
        HorarioServidorDAO pfDao = new HorarioServidorDAO();
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return null;
        } else {
            TbProfessoresDAO pDao = new TbProfessoresDAO();
            String id = context.getExternalContext().getRequestParameterMap().get("servidor");
            System.out.println("entrou no listar formacao pelo parametro id: " + id);
            servidor = sevidorDao.buscaPorID(Integer.parseInt(id));
            TbProfessores s = pDao.buscaPorID2(servidor.getIdProfessor().getId());
            pf = pfDao.listarHorarioPorProfessor(s);
        }       
        return pf;
    }

    public SiteProfDadosComplementares getServidor() {
        return servidor;
    }

    public void setServidor(SiteProfDadosComplementares servidor) {
        this.servidor = servidor;
    }

    public List<SiteProfessorFormacao> getFormacaoList() {
        return formacaoList;
    }

    public void setFormacaoList(List<SiteProfessorFormacao> formacaoList) {
        this.formacaoList = formacaoList;
    }

    public List<SiteHorarioServidor> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<SiteHorarioServidor> horarioList) {
        this.horarioList = horarioList;
    }

}
