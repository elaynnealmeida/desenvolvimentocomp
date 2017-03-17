
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteHorarioMonitor;
import model.SiteMonitor;

/**
 *
 * @author UFT
 */
public class HorarioMonitorDAO extends GenericDAO<SiteHorarioMonitor>{
    
    public HorarioMonitorDAO() {
        super(SiteHorarioMonitor.class);
    }
    
    public List<SiteHorarioMonitor> listarHorarioAtual(SiteMonitor monitor) {

        List<SiteHorarioMonitor> result = new ArrayList<SiteHorarioMonitor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioMonitor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioMonitor.class);
        Root root = query.from(SiteHorarioMonitor.class);
        query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("monitor", SiteMonitor.class)), monitor)));
        query.orderBy(builder.asc(root.get("dia")),builder.asc(root.get("horaInicio")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
