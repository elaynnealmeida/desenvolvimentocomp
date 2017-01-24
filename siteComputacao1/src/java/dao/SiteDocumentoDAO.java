
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.SiteDocumento;

/**
 *
 * @author UFT
 */
public class SiteDocumentoDAO extends GenericDAO<SiteDocumento>{
    
    public SiteDocumentoDAO(){
        super(SiteDocumento.class);
    }
    
    public List<SiteDocumento> listarPorData() {
        System.out.println("entrou no dao listar documentos");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        //EntityType type = em1.getMetamodel().entity(SiteNoticia.class);
        Root root = query.from(SiteDocumento.class);
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
}
