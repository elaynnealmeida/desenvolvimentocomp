
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteIniciacaoCientifica;

/**
 *
 * @author UFT
 */
public class SiteIniciacaoCientificaDAO extends GenericDAO<SiteIniciacaoCientifica>{
    
    public SiteIniciacaoCientificaDAO() {
        super(SiteIniciacaoCientifica.class);
    }
    
    public List<SiteIniciacaoCientifica> listarICporData() {

        List<SiteIniciacaoCientifica> result = new ArrayList<SiteIniciacaoCientifica>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteIniciacaoCientifica.class);
        EntityType type = em1.getMetamodel().entity(SiteIniciacaoCientifica.class);
        Root root = query.from(SiteIniciacaoCientifica.class);
        query.orderBy(builder.desc(builder.substring(root.get("dtInicio"), 6, 9)));
        result = em1.createQuery(query).getResultList();
        //result = em1.createQuery("SELECT * from site_iniciacao_cientifica order by (SELECT substring(dt_inicio, 6, 9)) asc;").getResultList();
        em1.close();
        return result;
    }
    
}
