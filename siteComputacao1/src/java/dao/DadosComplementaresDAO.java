package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteCargo;
import model.SiteCargoProfessor;
import model.SiteProfDadosComplementares;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class DadosComplementaresDAO extends GenericDAO<SiteProfDadosComplementares> {

    public DadosComplementaresDAO() {
        super(SiteProfDadosComplementares.class);
    }

    public List<SiteProfDadosComplementares> listarDadosPorProfessor(TbProfessores id) {
        //System.out.println("Id do professor: " + id);
        List<SiteProfDadosComplementares> result = new ArrayList<SiteProfDadosComplementares>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfDadosComplementares.class);
        EntityType type = em1.getMetamodel().entity(SiteProfDadosComplementares.class);
        Root root = query.from(SiteProfDadosComplementares.class);
        Join<SiteProfDadosComplementares, TbProfessores> join = root.join("idProfessor", JoinType.INNER);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("idProfessor", TbProfessores.class)), id));
         query.orderBy(builder.asc(join.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

    public List<SiteProfDadosComplementares> listarDadosPorProfessorAtivo() {

        List<SiteProfDadosComplementares> result = new ArrayList<SiteProfDadosComplementares>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfDadosComplementares.class);
        EntityType type = em1.getMetamodel().entity(SiteProfDadosComplementares.class);
        Root root = query.from(SiteProfDadosComplementares.class);
        Join<SiteProfDadosComplementares, TbProfessores> join = root.join("idProfessor", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
        query.equals(join.get("id"));
        query.where(builder.and(builder.equal(join.get("ativo"), "true"), builder.or((builder.equal(join3.get("id"), 1)), (builder.equal(join3.get("id"), 2)))));
        query.orderBy(builder.asc(join.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();

        return result;
    }

    public List<SiteProfDadosComplementares> listarDadosPorProfessorInativos() {
         List<SiteProfDadosComplementares> result = new ArrayList<SiteProfDadosComplementares>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfDadosComplementares.class);
        EntityType type = em1.getMetamodel().entity(SiteProfDadosComplementares.class);
        Root root = query.from(SiteProfDadosComplementares.class);
        Join<SiteProfDadosComplementares, TbProfessores> join = root.join("idProfessor", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
        query.where(builder.and(builder.equal(join.get("ativo"), "false"), builder.or((builder.equal(join3.get("id"), 1)), (builder.equal(join3.get("id"), 2)))));
        query.orderBy(builder.asc(join.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();

        return result;
    }
    
    public List<SiteProfDadosComplementares> listarDadosPorTecnicoAtivo() {

        List<SiteProfDadosComplementares> result = new ArrayList<SiteProfDadosComplementares>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfDadosComplementares.class);
        EntityType type = em1.getMetamodel().entity(SiteProfDadosComplementares.class);
        Root root = query.from(SiteProfDadosComplementares.class);
        Join<SiteProfDadosComplementares, TbProfessores> join = root.join("idProfessor", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
        query.where(builder.and(builder.equal(join.get("ativo"), "true"), builder.or((builder.equal(join3.get("id"), 3)), (builder.equal(join3.get("id"), 4)))));
        query.orderBy(builder.asc(join.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();

        return result;
    }

    public List<SiteProfDadosComplementares> listarDadosPorTecnicoInativos() {
         List<SiteProfDadosComplementares> result = new ArrayList<SiteProfDadosComplementares>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfDadosComplementares.class);
        EntityType type = em1.getMetamodel().entity(SiteProfDadosComplementares.class);
        Root root = query.from(SiteProfDadosComplementares.class);
        Join<SiteProfDadosComplementares, TbProfessores> join = root.join("idProfessor", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
        query.where(builder.and(builder.equal(join.get("ativo"), "false"), builder.or((builder.equal(join3.get("id"), 3)), (builder.equal(join3.get("id"), 4)))));
        query.orderBy(builder.asc(join.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();

        return result;
    }
}
