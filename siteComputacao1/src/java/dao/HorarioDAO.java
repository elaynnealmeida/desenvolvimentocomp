
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteEstagiarios;
import model.SiteHorario;

/**
 *
 * @author UFT
 */
public class HorarioDAO extends GenericDAO<SiteHorario>{
    
    public HorarioDAO() {
        super(SiteHorario.class);
    }
    public List<SiteHorario> listarHorarioAtual(SiteEstagiarios estagiario) {

        List<SiteHorario> result = new ArrayList<SiteHorario>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorario.class);
        EntityType type = em1.getMetamodel().entity(SiteHorario.class);
        Root root = query.from(SiteHorario.class);
         query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("estagiarioId", SiteEstagiarios.class)), estagiario)));
        query.orderBy(builder.asc(root.get("dia")),builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
