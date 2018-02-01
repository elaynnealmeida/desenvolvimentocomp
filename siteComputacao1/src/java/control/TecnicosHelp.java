package control;

import dao.CargoProfessorDAO;
import dao.DadosComplementaresDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import model.SiteCargo;
import model.SiteProfDadosComplementares;
import model.TbProfessores;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author UFT
 */
@ManagedBean
@SessionScoped
public class TecnicosHelp implements Serializable {

    private DadosComplementaresDAO sevidorDao;
    private List<SiteProfDadosComplementares> tecnicos;
    private List<SiteProfDadosComplementares> tecnicosInativos;
    private List<SiteProfDadosComplementares> tecnicosFiltradas;

    @PostConstruct
    public void init() {
        this.sevidorDao = new DadosComplementaresDAO();
        this.tecnicos = listarAtivos();
        this.tecnicosInativos = listarInativos();
    }

    public List<SiteProfDadosComplementares> listarAtivos() {
        System.out.println("entrou no listar tecnicos ativos");
        this.tecnicos = sevidorDao.listarDadosPorTecnicoAtivo();
        return this.tecnicos;
    }

    public List<SiteProfDadosComplementares> listarInativos() {
        this.tecnicosInativos = sevidorDao.listarDadosPorTecnicoInativos();
        return this.tecnicosInativos;
    }

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("servidor");
            SiteProfDadosComplementares i = sevidorDao.buscaPorID(Integer.parseInt(id));
            System.out.println("Id: " + id);
            if (i.getFoto() != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(i.getFoto()));
            } else {
                byte[] bytes = null;
                return new DefaultStreamedContent();
            }

        }
    }

     public String buscaCargo(TbProfessores id) {
        SiteCargo cargo = new SiteCargo();
        CargoProfessorDAO cDao = new CargoProfessorDAO();
        if (!cDao.listarCargoPorProfessor(id).isEmpty()) {
            cargo = cDao.listarCargoPorProfessor(id).get(0).getCargoId();
        }
        return cargo.getDescricao();
    }

    public void pagina() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entrou no redirecionamento de pagina");
        String id = context.getExternalContext().getRequestParameterMap().get("servidor");
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/servidor.xhtml?servidor=" + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SiteProfDadosComplementares> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<SiteProfDadosComplementares> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public List<SiteProfDadosComplementares> getTecnicosInativos() {
        return tecnicosInativos;
    }

    public void setTecnicosInativos(List<SiteProfDadosComplementares> tecnicosInativos) {
        this.tecnicosInativos = tecnicosInativos;
    }

    public List<SiteProfDadosComplementares> getTecnicosFiltradas() {
        return tecnicosFiltradas;
    }

    public void setTecnicosFiltradas(List<SiteProfDadosComplementares> tecnicosFiltradas) {
        this.tecnicosFiltradas = tecnicosFiltradas;
    }
    
    
}
