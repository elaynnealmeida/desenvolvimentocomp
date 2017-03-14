
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteMonitor;

/**
 *
 * @author UFT
 */
public class MonitorDAO extends GenericDAO<SiteMonitor>{
    
    public MonitorDAO() {
        super(SiteMonitor.class);
    }
    
    public List<SiteMonitor> listarTodosAtivos() {

        System.out.println("entrou no dao listar estagiarios ativos-----------");
        List<SiteMonitor> result = new ArrayList<SiteMonitor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteMonitor.class);
        EntityType type = em1.getMetamodel().entity(SiteMonitor.class);
        Root root = query.from(SiteMonitor.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"));
        query.orderBy(builder.asc(root.get("id")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
}
