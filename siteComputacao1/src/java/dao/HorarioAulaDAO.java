
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteHorarioAula;
import model.SiteTurma;

/**
 *
 * @author UFT
 */
public class HorarioAulaDAO extends GenericDAO<SiteHorarioAula>{
    
    public HorarioAulaDAO() {
        super(SiteHorarioAula.class);
    }
    
    public List<SiteHorarioAula> listarHorarioPorTurma(SiteTurma turma) {

        List<SiteHorarioAula> result = new ArrayList<SiteHorarioAula>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioAula.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioAula.class);
        Root root = query.from(SiteHorarioAula.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("turmaId", SiteTurma.class)), turma));
        query.orderBy(builder.asc(root.get("dia")));
        query.orderBy(builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
    public List<SiteHorarioAula> listarHorarioAtual() {

        List<SiteHorarioAula> result = new ArrayList<SiteHorarioAula>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioAula.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioAula.class);
        Root root = query.from(SiteHorarioAula.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"));
        query.orderBy(builder.asc(root.get("dia")),builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}



