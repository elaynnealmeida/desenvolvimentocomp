/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.SiteFuncaoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.SiteFuncao;
import org.primefaces.event.SelectEvent;


@ManagedBean
@ViewScoped
//@SessionScoped
public class SiteFuncaoController implements Serializable{
    
    private SiteFuncao funcao;
    private SiteFuncaoDAO funcaoDao;
    private List<SiteFuncao> funcoes;
    private List<SiteFuncao> funcoesFiltradas;
    private boolean isEdit;
    
    
    @PostConstruct
    public void init() {
        this.funcao = new SiteFuncao();
        this.funcaoDao = new SiteFuncaoDAO();
        this.isEdit = false;
        funcoes = listar();
    }
    
    public void limpar() {
        this.funcao = new SiteFuncao();
        this.isEdit = false;
        listar();
    }

    public void salvar() {
        try {
            funcaoDao.salvar(funcao);
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
        try{
        funcaoDao.atualizar(funcao);
        FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try{
        funcaoDao.deletar(funcao);
        FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public List<SiteFuncao> selectFuncao(String query) {
        List<SiteFuncao> results = new ArrayList<SiteFuncao>();
        List<SiteFuncao> result = new ArrayList<SiteFuncao>();
        SiteFuncaoDAO funcaoDao = new SiteFuncaoDAO();
        results = funcaoDao.listarTodos();       
        for(int c = 0;c<results.size();c++){
            result.add(results.get(c));
        }
        return results;
    }

    public List<SiteFuncao> listar() {
        this.funcoes = funcaoDao.listarTodos();
        return this.funcoes;
    }
    
     public void onRowSelect(SelectEvent event) {
        this.funcao = ((SiteFuncao) event.getObject());
        this.isEdit = true;
    }

    public SiteFuncao getFuncao() {
        return funcao;
    }

    public void setFuncao(SiteFuncao funcao) {
        this.funcao = funcao;
    }

    public SiteFuncaoDAO getFuncaoDao() {
        return funcaoDao;
    }

    public void setFuncaoDao(SiteFuncaoDAO funcaoDao) {
        this.funcaoDao = funcaoDao;
    }

    public List<SiteFuncao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<SiteFuncao> funcoes) {
        this.funcoes = funcoes;
    }

    public List<SiteFuncao> getFuncoesFiltradas() {
        return funcoesFiltradas;
    }

    public void setFuncoesFiltradas(List<SiteFuncao> funcoesFiltrados) {
        this.funcoesFiltradas = funcoesFiltrados;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
