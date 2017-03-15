
package control;

import dao.HorarioServidorDAO;
import dao.SalaDAO;
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
import model.SiteHorarioServidor;
import model.TbProfessores;
import model.TbSala;
import model.TbUsersystem;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class HorarioServidorController implements Serializable {
    private HorarioServidorDAO horarioDAO;
    private List<SiteHorarioServidor> horarios;
     private SiteHorarioServidor horario;
    private boolean isEdit;
    
    @PostConstruct
    public void init() {
        this.horarios = new ArrayList<SiteHorarioServidor>();
        this.horario = new SiteHorarioServidor();
        this.horarioDAO = new HorarioServidorDAO();
        this.isEdit = false;
        horarios = listar();
    }

    public void limpar() {
        this.horario = new SiteHorarioServidor();
        this.horarios = new ArrayList<SiteHorarioServidor>();
        this.horario = new SiteHorarioServidor();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            horario.setDia(atualizaDia());
            horario.setServidorId(buscaProf());
            horarioDAO.salvar(horario);
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
            horario.setDia(atualizaDia());
            horarioDAO.atualizar(horario);
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
            horarioDAO.deletar(horario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public TbProfessores buscaProf() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        TbUsersystem usuarioSession = (TbUsersystem) session.getAttribute("user");
        TbProfessoresDAO prof = new TbProfessoresDAO();
        return prof.buscaProf(usuarioSession);
    }

    public List<SiteHorarioServidor> listar() {
        this.horarios = horarioDAO.listarHorarioPorProfessor(buscaProf());
        return this.horarios;
    }

    public void onRowSelect(SelectEvent event) {
        this.horario = ((SiteHorarioServidor) event.getObject());        
        this.isEdit = true;
    }

        
    public List<SelectItem> getSala() {
        System.out.println("entrou no listar sala: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SalaDAO tpdDao = new SalaDAO();
        List<TbSala> result = new ArrayList<TbSala>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getBlocoId().getDescricao() + " - " + result.get(i).getNomeSala()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public Integer atualizaDia(){
        System.out.println("dia escolhido:----------------------"+horario.getDiaSemana());
        if(horario.getDiaSemana().equals("Segunda-Feira")){
           return 2;
        }
        else if(horario.getDiaSemana().equals("Terça-Feira")){
            return 3;
        }
        else if(horario.getDiaSemana().equals("Quarta-Feira")){
            return 4;
        }
        else if(horario.getDiaSemana().equals("Quinta-Feira")){
            return 5;
        }
       else if(horario.getDiaSemana().equals("Sexta-Feira")){
            return 6;
        }
       else{
           return 7;
        }       
    }
    
    public List<SiteHorarioServidor> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SiteHorarioServidor> horarios) {
        this.horarios = horarios;
    }

    public SiteHorarioServidor getHorario() {
        return horario;
    }

    public void setHorario(SiteHorarioServidor horario) {
        this.horario = horario;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
    
}
