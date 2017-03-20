package control;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author UFT
 */
@ManagedBean
public class NavegacaoHelper {

    public void all_noticias() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/all_noticias.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ensino() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/ensino.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    
    public void pesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/pesquisa.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void extensao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/extensao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void coordenacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/coordenacao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void plano_ensino() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/documentos/plano_ensino.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void nucleo_docentes() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/documentos/nucleo_docentes.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void doc_institucional() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/documentos/doc_institucional.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void doc_curso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/documentos/doc_curso.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void tecnicos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/recursos_humanos/tecnicos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void docentes_substitutos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/recursos_humanos/docentes_substitutos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void docentes_efetivos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/recursos_humanos/docentes_efetivos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sala_aula() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/infraestrutura_fisica/sala_aula.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void labin_tematico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/infraestrutura_fisica/labin_tematico.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void labin_ensino() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/infraestrutura_fisica/labin_ensino.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void infra_coordenacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/infraestrutura_fisica/coordenacao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void campus_palmas() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/infraestrutura_fisica/campus_palmas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sobre() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/sobre.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void matrizCurricular() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/matrizcurricular.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pos_strictu_senso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/pos_strictu_senso.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pos_lato_senso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/pos_lato_senso.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void matriz() throws IOException {
       ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/matriz.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void laboratorios() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/laboratorios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void horarios() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/horarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void historico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/historico.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void centro_academico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/menu/estrutura_curso/centro_academico.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void professor_formacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/professores/professor_formacao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public void servidores() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/servidores");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public void horariosGeral() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/horarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaUsuario() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/usuario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaFormacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/formacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaPerfil() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/perfil");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaProfessor() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/professor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaCargo() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/sitecargo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaFuncao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/sitefuncao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaTag() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/tags");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaAssociarPerfil() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/usuarioperfil");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paginaNoticias() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/professores/noticias");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void paginaDocumento() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/documento");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
      public void paginaTpDocumento() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/tipodocumento");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
       public void paginaTpPublicacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/tipopublicacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       
       public void paginaConselho() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/conselho");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       public void paginaEstagiario() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/estagiario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       
     public void paginaMonitor() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/monitor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
     
     public void paginaTurma() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/turma");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
      
     
     public void paginaDowloads() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/downloadsdocs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public void paginaTipoEquipamento() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/tipoequipamento");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public void paginaEquipamento() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/equipamento");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public void paginaInfraestrutura() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/infraestrutura");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void inicio() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
