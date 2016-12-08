package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteComentarios;
import model.SiteNoticia;

/**
 *
 * @author UFT
 */
public class SiteComentariosDAO extends GenericDAO<SiteComentarios>{
    
     public SiteComentariosDAO() {
        super(SiteComentarios.class);
    }
     
     public List<SiteComentarios> listaPorNoticia(SiteNoticia noticia){
         System.out.println("entrou no dao listar-----------");
        List<SiteComentarios> result = new ArrayList<SiteComentarios>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteComentarios.class);
        //EntityType type = em1.getMetamodel().entity(SiteComentarios.class);
        Root root = query.from(SiteComentarios.class);
        query.where(builder.equal(root.get("noticiaId"), noticia));
        query.orderBy(builder.desc(root.get("id")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
     
     }
    
}
