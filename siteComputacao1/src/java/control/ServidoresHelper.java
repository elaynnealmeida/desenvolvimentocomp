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
public class ServidoresHelper implements Serializable {

    private DadosComplementaresDAO sevidorDao;
    private List<SiteProfDadosComplementares> servidores;
    private List<SiteProfDadosComplementares> servidoresInativos;
    private List<SiteProfDadosComplementares> servidoresFiltradas;

    @PostConstruct
    public void init() {
        this.sevidorDao = new DadosComplementaresDAO();
        this.servidores = listarAtivos();
        this.servidoresInativos = listarInativos();
    }

    public List<SiteProfDadosComplementares> listarAtivos() {
        System.out.println("entrou no listar servidores ativos");
        this.servidores = sevidorDao.listarDadosPorProfessorAtivo();
        return this.servidores;
    }

    public List<SiteProfDadosComplementares> listarInativos() {
        this.servidoresInativos = sevidorDao.listarDadosPorProfessorInativos();
        return this.servidoresInativos;
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

    public List<SiteProfDadosComplementares> getServidores() {
        return servidores;
    }

    public void setServidores(List<SiteProfDadosComplementares> servidores) {
        this.servidores = servidores;
    }

    public List<SiteProfDadosComplementares> getServidoresInativos() {
        return servidoresInativos;
    }

    public void setServidoresInativos(List<SiteProfDadosComplementares> servidoresInativos) {
        this.servidoresInativos = servidoresInativos;
    }

    public List<SiteProfDadosComplementares> getServidoresFiltradas() {
        return servidoresFiltradas;
    }

    public void setServidoresFiltradas(List<SiteProfDadosComplementares> servidoresFiltradas) {
        this.servidoresFiltradas = servidoresFiltradas;
    }

}
