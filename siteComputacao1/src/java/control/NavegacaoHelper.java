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

    public void horario_monitores() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/monitores.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void horario_coordenacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/coordenacao.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void horario_estagiarios() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/estagiarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void horario_tecnicos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/tecnicos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atendimento_professores() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/atendimento_professores.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void horarios_aula() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/horarios/aulas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void grupo_pesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pesquisa/grupo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extensao_sobre() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/sobre.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void taekwondo() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/taekwondo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void secomp() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/secomp.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void obi() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/obi.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fabrica() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/fabrica.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void olimpiadasrobotica() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/olimpiadasrobotica.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maratona() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/maratona.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void congressos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/congressos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seminariosepalestras() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/extensao/seminariosepalestras.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nucleo_pesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pesquisa/nucleo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void projeto_pesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pesquisa/projeto.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                    + "/menu/ensino");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/pesquisa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extensao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/extensao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void coordenacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/coordenacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void plano_ensino() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/documentos/plano_ensino");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nucleo_docentes() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/documentos/nucleo_docentes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doc_institucional() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/documentos/doc_institucional");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doc_curso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/documentos/doc_curso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tecnicos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/recursos_humanos/tecnicos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docentes_substitutos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/recursos_humanos/docentes_substitutos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docentes_efetivos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/recursos_humanos/docentes_efetivos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sala_aula() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraestrutura_fisica/sala_aula");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void labin_tematico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraestrutura_fisica/labin_tematico");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void labin_ensino() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraestrutura_fisica/labin_ensino");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infra_coordenacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraestrutura_fisica/coordenacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void campus_palmas() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraestrutura_fisica/campus_palmas");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_lbdes() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_lbdes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_lhac() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_lhac");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_lcgpi() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_lcgpi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_laed() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_laed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_labca() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_labca");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lab_labram() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/lab_labram");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sobre() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/sobre");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void identidadeVisual() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/identidadevisual");
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
                    + "/menu/estrutura_curso/pos_strictu_senso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pos_lato_senso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/pos_lato_senso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void matriz() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/matriz");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void organizacaoadministrativa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/organizacaoadministrativa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void laboratorios() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/laboratorios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infraadministrativa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infraadministrativa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infrapedagogica() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infrapedagogica");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infracompartilhada() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/infracompartilhada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void horarios() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/horarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void historico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/historico");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void linhasdepesquisa() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/linhasdepesquisa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void objetivos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/objetivos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void perfil_egresso() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/perfil_egresso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void centro_academico() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/menu/estrutura_curso/centro_academico");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void professor_formacao() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/professores/professor_formacao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrar_links() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/professores/links.xhtml");
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

    public void tecnicos1() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/tecnicos");
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
                    + "/faces/professores/noticias.xhtml");
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

    public void paginaDocumento2() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/testedocumento");
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

    public void paginaModulo() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/modulo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaAluno() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/aluno");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaIC() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/ic");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaPP() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/pages/pp");
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

    public void paginaDowloadsCondir() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docscondir.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaDowloadsConsuni() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docsconsuni.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaDowloadsConsepe() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docsconsepe.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaDowloadsDocentes() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docsdocentes.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaDowloadsNDE() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docsnde.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void paginaDowloadsRegimento() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/doc_regimentos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
      public void paginaDowloadsDiversos() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/doc_diversos.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paginaDowloadsEnade() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/docsenade.xhtml");
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

    public void paginaTipoInfraestrutura() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/pages/tipoinfraestrutura.xhtml");
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

    public void teste() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/testenoticia.xhtml");
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

    public void alterarSenhar() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/alterarsenha.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recuperarSenhar() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/recuperarsenha.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
