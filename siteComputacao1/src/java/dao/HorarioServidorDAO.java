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
import model.SiteHorarioServidor;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class HorarioServidorDAO extends GenericDAO<SiteHorarioServidor> {

    public HorarioServidorDAO() {
        super(SiteHorarioServidor.class);
    }

    public List<SiteHorarioServidor> listarHorarioPorProfessor(TbProfessores id) {

        List<SiteHorarioServidor> result = new ArrayList<SiteHorarioServidor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioServidor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioServidor.class);
        Root root = query.from(SiteHorarioServidor.class);
        query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("servidorId", TbProfessores.class)), id), 
                builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

    public List<SiteHorarioServidor> listarTecnicos() {
        List<SiteHorarioServidor> result = new ArrayList<SiteHorarioServidor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioServidor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioServidor.class);
        Root root = query.from(SiteHorarioServidor.class);
        Join<SiteHorarioServidor, TbProfessores> join = root.join("servidorId", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
        query.where(builder.and(builder.or(builder.equal(join3.get("id"), "4"), builder.equal(join3.get("id"), "5")), 
                    builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true")));
        query.orderBy(builder.asc(root.get("dia")), builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

    public List<SiteHorarioServidor> listarProfessores() {

        List<SiteHorarioServidor> result = new ArrayList<SiteHorarioServidor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioServidor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioServidor.class);
        Root root = query.from(SiteHorarioServidor.class);
        Join<SiteHorarioServidor, TbProfessores> join = root.join("servidorId", JoinType.INNER);
        Join<TbProfessores, SiteCargoProfessor> join2 = join.join("siteCargoProfessorList", JoinType.INNER);
        Join<SiteCargoProfessor, SiteCargo> join3 = join2.join("cargoId", JoinType.INNER);
        query.equals(join3.get("id"));
         query.where(builder.and(builder.or(builder.equal(join3.get("id"), "1"), builder.equal(join3.get("id"), "2")), 
                    builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true")));
        query.orderBy(builder.asc(root.get("dia")), builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
