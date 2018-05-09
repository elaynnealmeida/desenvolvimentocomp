package control;

import dao.DisciplinaDAO;
import dao.HorarioMonitorDAO;
import dao.MonitorDAO;
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
import model.SiteHorarioMonitor;
import model.SiteMonitor;
import model.TbDisciplina;
import model.TbSala;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class MonitorController implements Serializable {

    private SiteMonitor monitor;
    private MonitorDAO monitorDao;
    private List<SiteMonitor> monitores;
    private List<SiteMonitor> monitoresFiltrados;
    private List<SiteHorarioMonitor> horarios;
    private List<SiteHorarioMonitor> horariosRemover;
    private SiteHorarioMonitor horario;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.monitor = new SiteMonitor();
        this.monitorDao = new MonitorDAO();
        this.horarios = new ArrayList<SiteHorarioMonitor>();
        this.horariosRemover = new ArrayList<SiteHorarioMonitor>();
        this.horario = new SiteHorarioMonitor();
        this.isEdit = false;
        monitores = listar();
    }

    public void limpar() {
        this.monitor = new SiteMonitor();
        this.horarios = new ArrayList<SiteHorarioMonitor>();
        this.horariosRemover = new ArrayList<SiteHorarioMonitor>();
        this.horario = new SiteHorarioMonitor();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {            
            monitor.setSiteHorarioMonitorList(horarios);
            monitorDao.salvar(monitor);
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
                    HorarioMonitorDAO hDao = new HorarioMonitorDAO();
                    hDao.deletar(this.horariosRemover.get(i));
                }
            }
            if (monitor.getSiteHorarioMonitorList() != horarios) {
                for (int i = 0; i < this.horarios.size(); i++) {
                    if (this.horarios.get(i).getId() != null) {                        
                        HorarioMonitorDAO hDao = new HorarioMonitorDAO();
                        this.horarios.get(i).setDia(atualizaDia());
                        hDao.atualizar(this.horarios.get(i));
                    } else {
                        System.out.println("Entrou no horario novo ");
                        HorarioMonitorDAO hDao = new HorarioMonitorDAO();
                        horario.setDia(atualizaDia());
                        horario.setMonitor(monitor);
                        hDao.salvar(this.horarios.get(i));
                    }
                }
            }
            monitor.setSiteHorarioMonitorList(horarios);
            monitorDao.atualizar(monitor);
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
            monitorDao.deletar(monitor);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteMonitor> listar() {
        this.monitores = monitorDao.listarTodos();
        return this.monitores;
    }

    public void onRowSelect(SelectEvent event) {
        this.monitor = ((SiteMonitor) event.getObject());
        System.out.println("horarios: " + this.monitor.getSiteHorarioMonitorList());
        horarios.addAll(this.monitor.getSiteHorarioMonitorList());
        this.isEdit = true;
    }

    public void addHorario() {
        System.out.println("horario: " + horario.getSala().getBlocoId().getDescricao() + " - " + horario.getSala().getNomeSala() + " - " + horario.getDiaSemana() + " - " + horario.getHoraInicio() + " as " + horario.getHoraFim());
        horario.setDia(atualizaDia());
        horario.setMonitor(monitor);
        this.horarios.add(horario);
        this.horario = new SiteHorarioMonitor();
    }

    public void removeHorario(SiteHorarioMonitor h) {
        System.out.println("Excluido: " + h);
        this.horarios.remove(h);
        if (h.getId() != null) {
            this.horariosRemover.add(h);
        }
        this.horario = new SiteHorarioMonitor();
    }

    public void editaHorario(SiteHorarioMonitor h) {
        System.out.println("horarios1 " + horarios);
        this.horario = h;
        this.horarios.remove(h);
        System.out.println("horarios2 " + horarios);
    }

    public List<SelectItem> getDisciplina() {
        System.out.println("entrou no listar disciplina: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        List<TbDisciplina> result = new ArrayList<TbDisciplina>();
        result = disciplinaDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public List<SelectItem> getSala() {
        System.out.println("entrou no listar sala: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SalaDAO tpdDao = new SalaDAO();
        List<TbSala> result = new ArrayList<TbSala>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), "Bloco "+result.get(i).getBlocoId().getDescricao() + " - Sala " + result.get(i).getNomeSala()));
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

    public SiteMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(SiteMonitor monitor) {
        this.monitor = monitor;
    }

    public List<SiteMonitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<SiteMonitor> monitores) {
        this.monitores = monitores;
    }

    public List<SiteMonitor> getMonitoresFiltrados() {
        return monitoresFiltrados;
    }

    public void setMonitoresFiltrados(List<SiteMonitor> monitoresFiltrados) {
        this.monitoresFiltrados = monitoresFiltrados;
    }

    public List<SiteHorarioMonitor> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SiteHorarioMonitor> horarios) {
        this.horarios = horarios;
    }

    public List<SiteHorarioMonitor> getHorariosRemover() {
        return horariosRemover;
    }

    public void setHorariosRemover(List<SiteHorarioMonitor> horariosRemover) {
        this.horariosRemover = horariosRemover;
    }

    public SiteHorarioMonitor getHorario() {
        return horario;
    }

    public void setHorario(SiteHorarioMonitor horario) {
        this.horario = horario;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

}
