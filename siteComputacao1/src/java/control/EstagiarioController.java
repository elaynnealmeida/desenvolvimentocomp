package control;

import dao.EstagiarioDAO;
import dao.HorarioDAO;
import dao.SalaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteEstagiarios;
import model.SiteHorario;
import model.TbSala;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class EstagiarioController implements Serializable {

    private SiteEstagiarios estagiario;
    private EstagiarioDAO estagiarioDao;
    private List<SiteEstagiarios> estagiarios;
    private List<SiteEstagiarios> estagiariosFiltrados;
    private List<SiteHorario> horarios;
    private List<SiteHorario> horariosRemover;
    private SiteHorario horario;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.estagiario = new SiteEstagiarios();
        this.estagiarioDao = new EstagiarioDAO();
        this.horarios = new ArrayList<SiteHorario>();
        this.horariosRemover = new ArrayList<SiteHorario>();
        this.horario = new SiteHorario();
        this.isEdit = false;
        estagiarios = listar();
    }

    public void limpar() {
        this.estagiario = new SiteEstagiarios();
        this.horarios = new ArrayList<SiteHorario>();
        this.horariosRemover = new ArrayList<SiteHorario>();
        this.horario = new SiteHorario();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            estagiario.setSiteHorarioList(horarios);
            estagiarioDao.salvar(estagiario);
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
            if (!this.horariosRemover.isEmpty()) {
                for (int i = 0; i < this.horariosRemover.size(); i++) {
                    System.out.println("Excluido: " + this.horariosRemover.get(i));
                    HorarioDAO hDao = new HorarioDAO();
                    hDao.deletar(this.horariosRemover.get(i));
                }
            }
            if (estagiario.getSiteHorarioList() != horarios) {
                for (int i = 0; i < this.horarios.size(); i++) {
                    if (this.horarios.get(i).getId() != null) {
                        HorarioDAO hDao = new HorarioDAO();
                        this.horarios.get(i).setDia(atualizaDia());
                        hDao.atualizar(this.horarios.get(i));
                    } else {
                        System.out.println("Entrou no horario novo ");
                        HorarioDAO hDao = new HorarioDAO();
                        horario.setDia(atualizaDia());
                        horario.setEstagiarioId(estagiario);
                        hDao.salvar(this.horarios.get(i));
                    }
                }
            }
            estagiario.setSiteHorarioList(horarios);
            estagiarioDao.atualizar(estagiario);
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
            estagiarioDao.deletar(estagiario);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteEstagiarios> listar() {
        this.estagiarios = estagiarioDao.listarTodos();
        return this.estagiarios;
    }

    public void onRowSelect(SelectEvent event) {
        this.estagiario = ((SiteEstagiarios) event.getObject());
        System.out.println("horarios: " + this.estagiario.getSiteHorarioList());
        horarios.addAll(this.estagiario.getSiteHorarioList());
        this.isEdit = true;
    }

    public void addHorario() {
        System.out.println("horario: " + horario.getSala().getBlocoId().getDescricao() + " - " + horario.getSala().getNomeSala() + " - " + horario.getDiaSemana() + " - " + horario.getHoraInicio() + " as " + horario.getHoraFim());
        horario.setDia(atualizaDia());
        horario.setEstagiarioId(estagiario);
        this.horarios.add(horario);
        this.horario = new SiteHorario();
    }

    public void removeHorario(SiteHorario h) {
        System.out.println("Excluido: " + h);
        this.horarios.remove(h);
        if (h.getId() != null) {
            this.horariosRemover.add(h);
        }
        this.horario = new SiteHorario();
    }

    public void editaHorario(SiteHorario h) {
        System.out.println("horarios1 " + horarios);
        this.horario = h;
        this.horarios.remove(h);
        System.out.println("horarios2 " + horarios);
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

    public SiteEstagiarios getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(SiteEstagiarios estagiario) {
        this.estagiario = estagiario;
    }

    public List<SiteEstagiarios> getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(List<SiteEstagiarios> estagiarios) {
        this.estagiarios = estagiarios;
    }

    public List<SiteEstagiarios> getEstagiariosFiltrados() {
        return estagiariosFiltrados;
    }

    public void setEstagiariosFiltrados(List<SiteEstagiarios> estagiariosFiltrados) {
        this.estagiariosFiltrados = estagiariosFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SiteHorario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SiteHorario> horarios) {
        this.horarios = horarios;
    }

    public SiteHorario getHorario() {
        return horario;
    }

    public void setHorario(SiteHorario horario) {
        this.horario = horario;
    }

}
