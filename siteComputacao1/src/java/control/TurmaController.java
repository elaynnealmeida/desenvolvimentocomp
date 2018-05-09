
package control;

import dao.DisciplinaDAO;
import dao.HorarioAulaDAO;
import dao.SalaDAO;
import dao.TbProfessoresDAO;
import dao.TurmaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.SiteHorarioAula;
import model.SiteTurma;
import model.TbDisciplina;
import model.TbProfessores;
import model.TbSala;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class TurmaController implements Serializable {

    private SiteTurma turma;
    private TurmaDAO turmaDao;
    private List<SiteTurma> turmas;
    private List<SiteTurma> turmasFiltrados;
    private List<SiteHorarioAula> horarios;
    private List<SiteHorarioAula> horariosRemover;
    private SiteHorarioAula horario;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.turma = new SiteTurma();
        this.turmaDao = new TurmaDAO();
        this.horarios = new ArrayList<SiteHorarioAula>();
        this.horariosRemover = new ArrayList<SiteHorarioAula>();
        this.horario = new SiteHorarioAula();
        this.isEdit = false;
        turmas = listar();
    }

    public void limpar() {
        this.turma = new SiteTurma();
        this.horarios = new ArrayList<SiteHorarioAula>();
        this.horariosRemover = new ArrayList<SiteHorarioAula>();
        this.horario = new SiteHorarioAula();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {            
            turma.setSiteHorarioAulaList(horarios);
            turmaDao.salvar(turma);
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
                    HorarioAulaDAO hDao = new HorarioAulaDAO();
                    hDao.deletar(this.horariosRemover.get(i));
                }
            }
            if (turma.getSiteHorarioAulaList() != horarios) {
                for (int i = 0; i < this.horarios.size(); i++) {
                    if (this.horarios.get(i).getId() != null) {                        
                        HorarioAulaDAO hDao = new HorarioAulaDAO();
                        this.horarios.get(i).setDia(atualizaDia());
                        hDao.atualizar(this.horarios.get(i));
                    } else {
                        System.out.println("Entrou no horario novo ");
                        HorarioAulaDAO hDao = new HorarioAulaDAO();
                        horario.setDia(atualizaDia());
                        horario.setTurmaId(turma);
                        hDao.salvar(this.horarios.get(i));
                    }
                }
            }
            turma.setSiteHorarioAulaList(horarios);
            turmaDao.atualizar(turma);
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
            turmaDao.deletar(turma);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteTurma> listar() {
        this.turmas = turmaDao.listarTodos();
        //for(int i=0;i<this.turmas.size();i++){
         //this.turmas.get(i).setSiteHorarioAulaList(buscaHorario(turmas.get(i)));
        //}        
        return this.turmas;
    }

    public void onRowSelect(SelectEvent event) {
        this.turma = ((SiteTurma) event.getObject());
        System.out.println("horarios: " + this.turma.getSiteHorarioAulaList());
        horarios.addAll(this.turma.getSiteHorarioAulaList());
        this.isEdit = true;
    }

    public void addHorario() {
        System.out.println("horario: " + horario.getSalaId().getBlocoId().getDescricao() + " - " + horario.getSalaId().getNomeSala() + " - " + horario.getDiaSemana() + " - " + horario.getHoraInicio() + " as " + horario.getHoraFim());
        horario.setDia(atualizaDia());
        horario.setTurmaId(turma);
        this.horarios.add(horario);
        this.horario = new SiteHorarioAula();
    }

    public void removeHorario(SiteHorarioAula h) {
        System.out.println("Excluido: " + h);
        this.horarios.remove(h);
        if (h.getId() != null) {
            this.horariosRemover.add(h);
        }
        this.horario = new SiteHorarioAula();
    }

    public void editaHorario(SiteHorarioAula h) {
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
    
    public List<SelectItem> getProfessor() {
        System.out.println("entrou no listar professor: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        TbProfessoresDAO profDao = new TbProfessoresDAO();
        List<TbProfessores> result = new ArrayList<TbProfessores>();
        result = profDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome()));
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
            toReturn.add(new SelectItem(result.get(i), "Bloco "+result.get(i).getBlocoId().getDescricao() + " - Sala" + result.get(i).getNomeSala()));
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
    
    public List<SiteHorarioAula> buscaHorario(SiteTurma turma){
        if(turma != null){
        List<SiteHorarioAula> ha = new ArrayList<SiteHorarioAula>();
        HorarioAulaDAO hDao = new HorarioAulaDAO();
        ha = hDao.listarHorarioPorTurma(turma);
        return ha;
        }
        else {
            return null;
        }
    }

    public SiteTurma getTurma() {
        return turma;
    }

    public void setTurma(SiteTurma turma) {
        this.turma = turma;
    }

    public List<SiteTurma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<SiteTurma> turmas) {
        this.turmas = turmas;
    }

    public List<SiteTurma> getTurmasFiltrados() {
        return turmasFiltrados;
    }

    public void setTurmasFiltrados(List<SiteTurma> turmasFiltrados) {
        this.turmasFiltrados = turmasFiltrados;
    }

    public List<SiteHorarioAula> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SiteHorarioAula> horarios) {
        this.horarios = horarios;
    }

    public List<SiteHorarioAula> getHorariosRemover() {
        return horariosRemover;
    }

    public void setHorariosRemover(List<SiteHorarioAula> horariosRemover) {
        this.horariosRemover = horariosRemover;
    }

    public SiteHorarioAula getHorario() {
        return horario;
    }

    public void setHorario(SiteHorarioAula horario) {
        this.horario = horario;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
