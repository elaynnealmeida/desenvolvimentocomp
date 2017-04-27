
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteLinks;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
public class LinksDAO extends GenericDAO<SiteLinks>{
    public LinksDAO() {
        super(SiteLinks.class);
    }
    
     public List<SiteLinks> listarPorUsuario(TbUsersystem id) {
        List<SiteLinks> result = new ArrayList<SiteLinks>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteLinks.class);
        EntityType type = em1.getMetamodel().entity(SiteLinks.class);
        Root root = query.from(SiteLinks.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("usuarioId", TbUsersystem.class)), id));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
}
