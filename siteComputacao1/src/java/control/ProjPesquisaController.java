package control;

import dao.SiteAlunoDAO;
import dao.SitePpAlunosDAO;
import dao.SitePpCoordenadorDAO;
import dao.SitePpProfpesquisadorDAO;
import dao.SiteProjPesquisaDAO;
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
import model.SiteAluno;
import model.SiteProjPesquisa;
import model.TbProfessores;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class ProjPesquisaController implements Serializable {

    private SiteProjPesquisa projpesquisa;
    private SiteProjPesquisaDAO projpesquisaDao;
    private List<SiteProjPesquisa> projpesquisasFiltrados;
    private List<SiteProjPesquisa> projpesquisas;
    private List<SiteAluno> alunos;
    private SiteAluno aluno;
    private List<SiteAluno> alunosRemover;
    private List<TbProfessores> coordenadores;
    private List<TbProfessores> coordenadoresRemover;
    private TbProfessores coordenador;
    private List<TbProfessores> pesquisadores;
    private List<TbProfessores> pesquisadoresRemover;
    private TbProfessores pesquisador;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.projpesquisa = new SiteProjPesquisa();
        this.projpesquisaDao = new SiteProjPesquisaDAO();
        this.isEdit = false;
        this.aluno = new SiteAluno();
        this.coordenador = new TbProfessores();
        this.pesquisador = new TbProfessores();
        this.alunos = new ArrayList<SiteAluno>();
        this.coordenadores = new ArrayList<TbProfessores>();
        this.pesquisadores = new ArrayList<TbProfessores>();
        this.alunosRemover = new ArrayList<SiteAluno>();
        this.coordenadoresRemover = new ArrayList<TbProfessores>();
        this.pesquisadoresRemover = new ArrayList<TbProfessores>();
        this.projpesquisas = listar();
    }

    public void limpar() {
        this.projpesquisa = new SiteProjPesquisa();
        this.isEdit = false;
        this.aluno = new SiteAluno();
        this.coordenador = new TbProfessores();
        this.pesquisador = new TbProfessores();
        alunos = new ArrayList<SiteAluno>();
        coordenadores = new ArrayList<TbProfessores>();
        pesquisadores = new ArrayList<TbProfessores>();
        listar();
    }

    public void salvar() {
        try {
            projpesquisa.setSitePpAlunosList(alunos);
            projpesquisa.setSitePpCoordenadorList(coordenadores);
            projpesquisa.setSitePpProfpesquisadorList(pesquisadores);
            projpesquisaDao.salvar(projpesquisa);
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
            attCoordenador();
            attPesquisador();
            attAluno();
            projpesquisaDao.atualizar(projpesquisa);
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar atualizar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void attCoordenador() {
        SitePpCoordenadorDAO hDao = new SitePpCoordenadorDAO();        
        if (!this.coordenadoresRemover.isEmpty()) {            
            for (int i = 0; i < this.coordenadoresRemover.size(); i++) {                
                hDao.deletar(hDao.ppcoordenador(projpesquisa, this.coordenadoresRemover.get(i)));
            }
        }
        if (projpesquisa.getSitePpCoordenadorList() != coordenadores) {
            for (int i = 0; i < this.coordenadores.size(); i++) {
                if (this.coordenadores.get(i).getId() != null) {
                    hDao.atualizar(hDao.ppcoordenador(projpesquisa, this.coordenadores.get(i)));
                } else {
                    System.out.println("Entrou no coordenadores novo ");
                    //horario.setTurmaId(turma);
                    hDao.salvar(hDao.ppcoordenador(projpesquisa, this.coordenadores.get(i)));
                }
            }
        }
        projpesquisa.setSitePpCoordenadorList(coordenadores);
    }
    
     public void attPesquisador() {
        SitePpProfpesquisadorDAO hDao = new SitePpProfpesquisadorDAO();        
        if (!this.pesquisadoresRemover.isEmpty()) {            
            for (int i = 0; i < this.pesquisadoresRemover.size(); i++) {                
                hDao.deletar(hDao.pppesquisador(projpesquisa, this.pesquisadoresRemover.get(i)));
            }
        }
        if (projpesquisa.getSitePpProfpesquisadorList() != pesquisadores) {
            for (int i = 0; i < this.pesquisadores.size(); i++) {
                if (this.pesquisadores.get(i).getId() != null) {
                    hDao.atualizar(hDao.pppesquisador(projpesquisa, this.pesquisadores.get(i)));
                } else {
                    System.out.println("Entrou no pesquisadores novo ");
                    //horario.setTurmaId(turma);
                    hDao.salvar(hDao.pppesquisador(projpesquisa, this.pesquisadores.get(i)));
                }
            }
        }
        projpesquisa.setSitePpProfpesquisadorList(pesquisadores);
    }
     
      public void attAluno() {
        SitePpAlunosDAO hDao = new SitePpAlunosDAO();        
        if (!this.alunosRemover.isEmpty()) {            
            for (int i = 0; i < this.alunosRemover.size(); i++) {                
                hDao.deletar(hDao.ppaluno(projpesquisa, this.alunosRemover.get(i)));
            }
        }
        if (projpesquisa.getSitePpAlunosList() != alunos) {
            for (int i = 0; i < this.alunos.size(); i++) {
                if (this.alunos.get(i).getId() != null) {
                    hDao.atualizar(hDao.ppaluno(projpesquisa, this.alunos.get(i)));
                } else {
                    System.out.println("Entrou no alunos novo ");
                    //horario.setTurmaId(turma);
                    hDao.salvar(hDao.ppaluno(projpesquisa, this.alunos.get(i)));
                }
            }
        }
        projpesquisa.setSitePpAlunosList(alunos);
    }

    public void deletar() {
        try {
            projpesquisaDao.deletar(projpesquisa);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar deletar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SiteProjPesquisa> listar() {
        this.projpesquisas = projpesquisaDao.listarTodos();
        return this.projpesquisas;
    }

    public void onRowSelect(SelectEvent event) {
        this.projpesquisa = ((SiteProjPesquisa) event.getObject());
        if (!projpesquisa.getSitePpCoordenadorList().isEmpty()) {
            this.coordenadores.addAll(projpesquisa.getSitePpCoordenadorList());
        }

        if (!projpesquisa.getSitePpProfpesquisadorList().isEmpty()) {
            this.pesquisadores.addAll(projpesquisa.getSitePpProfpesquisadorList());
        }

        if (!projpesquisa.getSitePpAlunosList().isEmpty()) {
            this.alunos.addAll(this.projpesquisa.getSitePpAlunosList());
        }
        this.isEdit = true;
    }

    public void addAcademico() {
        this.alunos.add(aluno);
        this.aluno = new SiteAluno();
    }

    public void removeAluno(SiteAluno h) {
        System.out.println("Excluido: " + h);
        this.alunos.remove(h);
        if (h.getId() != null) {
            this.alunosRemover.add(h);
        }
        this.aluno = new SiteAluno();
    }
    

    public void addCoordenador() {
        this.coordenadores.add(coordenador);
        this.coordenador = new TbProfessores();
    }

    public void removeCoordenador(TbProfessores h) {
        System.out.println("Excluido: " + h);
        this.coordenadores.remove(h);
        if (h.getId() != null) {
            this.coordenadoresRemover.add(h);
        }
        this.coordenador = new TbProfessores();
    }

    public void addPesquisador() {
        this.pesquisadores.add(pesquisador);
        System.out.println("pesquisador: "+pesquisador.getNome());
        this.pesquisador = new TbProfessores();
    }

    public void removePesquisador(TbProfessores h) {
        System.out.println("Excluido: " + h);
        this.pesquisadores.remove(h);
        if (h.getId() != null) {
            this.pesquisadoresRemover.add(h);
        }
        this.pesquisador = new TbProfessores();
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

    public List<SelectItem> getCoordenador1() {
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

    public List<SelectItem> getAluno1() {
        System.out.println("entrou no listar alunos: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        SiteAlunoDAO dao = new SiteAlunoDAO();
        List<SiteAluno> result = new ArrayList<SiteAluno>();
        result = dao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getNome() + " - " + result.get(i).getMatricula()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }
    
    public String getLink(){
     return "https://sistemas.uft.edu.br/gpu/busca_projeto/show/"+projpesquisa.getNumRegistro();
    }

    public SiteProjPesquisa getProjpesquisa() {
        return projpesquisa;
    }

    public void setProjpesquisa(SiteProjPesquisa projpesquisa) {
        this.projpesquisa = projpesquisa;
    }

    public List<SiteProjPesquisa> getProjpesquisasFiltrados() {
        return projpesquisasFiltrados;
    }

    public void setProjpesquisasFiltrados(List<SiteProjPesquisa> projpesquisasFiltrados) {
        this.projpesquisasFiltrados = projpesquisasFiltrados;
    }

    public List<SiteProjPesquisa> getProjpesquisas() {
        return projpesquisas;
    }

    public void setProjpesquisas(List<SiteProjPesquisa> projpesquisas) {
        this.projpesquisas = projpesquisas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public List<SiteAluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<SiteAluno> alunos) {
        this.alunos = alunos;
    }

    public SiteAluno getAluno() {
        return aluno;
    }

    public void setAluno(SiteAluno aluno) {
        this.aluno = aluno;
    }

    public TbProfessores getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(TbProfessores pesquisador) {
        this.pesquisador = pesquisador;
    }

    public List<TbProfessores> getPesquisadores() {
        return pesquisadores;
    }

    public void setPesquisadores(List<TbProfessores> pesquisadores) {
        this.pesquisadores = pesquisadores;
    }

    public List<TbProfessores> getCoordenadores() {
        return coordenadores;
    }

    public void setCoordenadores(List<TbProfessores> coordenadores) {
        this.coordenadores = coordenadores;
    }

    public TbProfessores getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(TbProfessores coordenador) {
        this.coordenador = coordenador;
    }

}
